package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.enums.StaticEnum;

@Entity(tableName = "achievementRequests")
public class AchievementRequestModel {
    @ColumnInfo(name = "achievementRequestId")
    @PrimaryKey(autoGenerate = true)
    public long achievementRequestId;

    @ColumnInfo(name = "achievementId")
    public long achievementId;

    @ColumnInfo(name = "achievementRequestStatic")
    public StaticModel requestStatic;

    @ColumnInfo(name = "achievementRequestTarget")
    public long requestTarget;

    @ColumnInfo(name = "achievementRequestLive")
    public boolean requestLive = false;

    @ColumnInfo(name = "achievementRequestStatus")
    public boolean requestStatus = false;

    @Ignore
    public boolean isCompleted() {
        if (requestLive || !requestStatus) {
            if (requestStatic.staticValue >= requestTarget) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }

    @Ignore
    public AchievementRequestModel insert() {
        this.achievementRequestId = Singleton.db.achievementRequestDao().insert(this);

        return this;
    }

    @Ignore
    public AchievementRequestModel update() {
        Singleton.db.achievementRequestDao().update(this);

        return this;
    }

    @ColumnInfo(name = "achievementRequestInsertedAt")
    public Date insertedAt = new Date(System.currentTimeMillis());

    @ColumnInfo(name = "achievementRequestUpdatedAt")
    public Date updatedAt = new Date(System.currentTimeMillis());
}

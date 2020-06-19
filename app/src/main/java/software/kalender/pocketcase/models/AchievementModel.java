package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.enums.CurrencyEnum;
import software.kalender.pocketcase.helpers.MoneyHelper;

@Entity(tableName = "achievements")
public class AchievementModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "achievementId")
    public long achievementId;

    @ColumnInfo(name = "achievementNameCode")
    public String nameCode;

    @ColumnInfo(name = "achievementIcon")
    public String icon;

    @Ignore
    private AchievementRequestModel[] requests;

    @Ignore
    public AchievementRequestModel[] getAchievementRequests() {
        if (requests == null) {

            List<AchievementRequestModel> achievementRequestModels = Singleton.db.achievementRequestDao().listFromAchievementId(achievementId);
            requests = achievementRequestModels.toArray(new AchievementRequestModel[0]);
        }

        return requests;
    }

    @ColumnInfo(name = "achievementAchieved")
    public boolean isAchieved = false;

    @ColumnInfo(name = "achievementPrizeMoney")
    public MoneyHelper prizeMoney = new MoneyHelper(CurrencyEnum.USD, 0L);

    @ColumnInfo(name = "achievementPrizeXP")
    public int prizeXP = 0;

    @Ignore
    public AchievementModel insert() {
        this.achievementId = Singleton.db.achievementDao().insert(this);

        return this;
    }

    @Ignore
    public AchievementModel update() {
        Singleton.db.achievementDao().update(this);

        return this;
    }

    @Ignore
    public boolean isCanBeAchieved() {
        //TODO

        if (requests == null || requests.length == 0) {
            return true;
        }

        boolean isCanBeAchieved = true;

        for (AchievementRequestModel achievementRequest : requests) {
            if (!achievementRequest.isCompleted()) {
                isCanBeAchieved = false;
                break;
            }
        }

        return isCanBeAchieved;
    }

    @ColumnInfo(name = "achievementInsertedAt")
    public Date insertedAt = new Date(System.currentTimeMillis());

    @ColumnInfo(name = "achievementUpdatedAt")
    public Date updatedAt = new Date(System.currentTimeMillis());
}

package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "achievements")
public class AchievementModel {
    @ColumnInfo(name = "achievementId")
    public Long achievementId;

    @ColumnInfo(name = "achievementNameCode")
    public String achievementNameCode;

    @ColumnInfo(name = "achievementIcon")
    public String achievementIcon;
}

package software.kalender.pocketcase.models;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.enums.AchievementEnum;
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

    @NonNull
    @ColumnInfo(name = "achievementEnum")
    public AchievementEnum achievementEnum;

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
        getAchievementRequests();

        if (requests == null || requests.length == 0) {
            Log.e("asda", "boş");
            return false;
        }

        boolean isCanBeAchieved = true;

        for (AchievementRequestModel achievementRequest : requests) {
            if (!achievementRequest.isCompleted()) {
                Log.e("asda", "bitmemiş var");
                isCanBeAchieved = false;
                break;
            }
        }
        Log.e("asda", "sonuö " + (isCanBeAchieved));
        return isCanBeAchieved;
    }

    @Ignore
    public boolean checkGained() {
        if (requests == null || requests.length == 0) {
            Log.e("sada", " boşşş");
            return false;
        }

        boolean currentStatus = this.isAchieved;
        boolean isGainable = isCanBeAchieved();

        Log.e("Mevcutta", currentStatus ? "T" : "F");
        Log.e("Alabilirmi", isGainable ? "T" : "F");

        return !currentStatus && isGainable;
    }

    @ColumnInfo(name = "achievementInsertedAt")
    public Date insertedAt = new Date(System.currentTimeMillis());

    @ColumnInfo(name = "achievementUpdatedAt")
    public Date updatedAt = new Date(System.currentTimeMillis());
}

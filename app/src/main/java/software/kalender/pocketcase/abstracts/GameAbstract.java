package software.kalender.pocketcase.abstracts;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.Map;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.codes.InfoCode;
import software.kalender.pocketcase.constants.GameConstant;
import software.kalender.pocketcase.enums.AchievementEnum;
import software.kalender.pocketcase.interfaces.GameInterface;
import software.kalender.pocketcase.models.AchievementModel;

public abstract class GameAbstract implements GameInterface {
    protected Context context;
    protected View view;
    protected AchievementModel[] relationalModels;

    public GameAbstract(@NonNull Context context, @NonNull AchievementEnum[] achievementModelCodes) {
        this.context = context;

        relationalModels = new AchievementModel[achievementModelCodes.length];

        for (int i = 0; i < achievementModelCodes.length; i++) {
            relationalModels[i] = Singleton.db.achievementDao().getFromEnum(achievementModelCodes[i]);
        }
    }

    public View getView() {
        if (view != null) {
            return view;
        }

        view = this.generateView();

        return view;
    }

    public boolean completeAchievement() {
        if (relationalModels == null || relationalModels.length == 0) {
            Log.e("asda", "tanıtılmamı");
            return false;
        }

        boolean isCompleteAnyAchievement = false;

        for (AchievementModel achievementModel : relationalModels) {
            isCompleteAnyAchievement = achievementModel.checkGained();

            if (isCompleteAnyAchievement) {
                Singleton.log.info(InfoCode.INFO_UNKNOWN, "Gained");

                break;
            }
        }

        return isCompleteAnyAchievement;
    }
}

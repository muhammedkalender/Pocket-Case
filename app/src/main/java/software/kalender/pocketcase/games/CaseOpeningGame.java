package software.kalender.pocketcase.games;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.abstracts.GameAbstract;
import software.kalender.pocketcase.components.CaseOpeningScrollComponent;
import software.kalender.pocketcase.components.CaseSelectingComponent;
import software.kalender.pocketcase.components.WinItemComponent;
import software.kalender.pocketcase.constants.GameConstant;
import software.kalender.pocketcase.enums.AchievementEnum;
import software.kalender.pocketcase.enums.CaseTypeEnum;
import software.kalender.pocketcase.helpers.ViewHelper;
import software.kalender.pocketcase.models.AchievementModel;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.ItemSkinModel;

public class CaseOpeningGame extends GameAbstract {
    //TODO
    private CaseModel currentCase;

    public CaseOpeningGame(@NonNull Context context, AchievementEnum[] achievementEnums) {
        super(context, achievementEnums);
    }

    @Override
    public CaseOpeningGame reset() {
        return null;
    }

    @Override
    public View generateView() {
        this.view = ((Activity) this.context).getLayoutInflater().inflate(R.layout.game_case_open, null);

        final CaseSelectingComponent caseSelectingComponent = new CaseSelectingComponent(this.context, view.findViewById(R.id.areaCaseSelect));

        caseSelectingComponent.generateView();

        final CaseOpeningScrollComponent caseOpeningScrollComponent = new CaseOpeningScrollComponent(this.context, view.findViewById(R.id.areaCaseScroll));
        caseOpeningScrollComponent.generateView();

        final Button caseScrollButton = view.findViewById(R.id.componentCaseScrollButton);

        currentCase = Singleton.db.caseDao().getLastCaseFromType(CaseTypeEnum.values()[0]);


        caseOpeningScrollComponent.loadCaseDetail(currentCase);
        caseScrollButton.setText(Singleton.resource.getString(R.string.case_opening_button_start_with_case, currentCase.name, currentCase.getTotalPriceWithSymbol()));

        caseSelectingComponent.setOnCaseChanged(new Runnable() {
            @Override
            public void run() {
                if (!caseOpeningScrollComponent.isRunning) {
                    caseScrollButton.setText(Singleton.resource.getString(R.string.case_opening_button_start_with_case, currentCase.name, currentCase.getTotalPriceWithSymbol()));
                }

                caseOpeningScrollComponent.hideViewsOfComponent();

                currentCase = caseSelectingComponent.getSelectedCase();
                caseOpeningScrollComponent.loadCaseDetail(caseSelectingComponent.getSelectedCase());


            }
        });

        //TODO


        caseScrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final ItemSkinModel[] itemSkinModels = new ItemSkinModel[36];

                for (int i = 0; i < 36; i++) {
                    itemSkinModels[i] = Singleton.db.caseDao().getRandomItemFromColor(currentCase.caseId, currentCase.caseChance.random());
                }

                final ViewHelper viewHelper = new ViewHelper();

                caseOpeningScrollComponent.reset();

                caseOpeningScrollComponent.setOnStart(new Runnable() {
                    @Override
                    public void run() {
                        viewHelper.makeDisable(caseScrollButton, R.string.case_opening_button_start);
                    }
                });
                caseOpeningScrollComponent.setOnFinish(new Runnable() {
                    @Override
                    public void run() {
                        viewHelper.makeEnable(caseScrollButton, Singleton.resource.getString(R.string.case_opening_button_start_with_case, currentCase.name, currentCase.getTotalPriceWithSymbol()));

                        ItemQualityModel itemQualityModel = Singleton.db.itemQualityDao().qualityFromEnum(itemSkinModels[GameConstant.CASE_OPEN_WIN_INDEX].itemSkinId, itemSkinModels[GameConstant.CASE_OPEN_WIN_INDEX].itemQualityChance.random());

                        WinItemComponent winItemComponent = new WinItemComponent(context);

                        View winItemComponentView = winItemComponent.getView();
                        winItemComponent.loadItemQuality(itemQualityModel);
                        winItemComponentView.setForegroundGravity(Gravity.CENTER);
                        ((RelativeLayout) CaseOpeningGame.super.view).addView(winItemComponentView);
                    }
                });
                caseOpeningScrollComponent.addToScroll(itemSkinModels);

                caseOpeningScrollComponent.play();
            }
        });

        return view; //TODO
    }
}

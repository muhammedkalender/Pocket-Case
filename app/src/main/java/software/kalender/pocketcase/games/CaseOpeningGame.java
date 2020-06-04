package software.kalender.pocketcase.games;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.abstracts.GameAbstract;
import software.kalender.pocketcase.components.CaseOpeningScrollComponent;
import software.kalender.pocketcase.components.CaseSelectingComponent;
import software.kalender.pocketcase.interfaces.GameInterface;
import software.kalender.pocketcase.models.CaseChanceModel;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.ItemSkinModel;

public class CaseOpeningGame extends GameAbstract {
    //TODO

    public CaseOpeningGame(@NonNull Context context) {
        super(context);
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

        caseSelectingComponent.setOnCaseChanged(new Runnable() {
            @Override
            public void run() {
                caseOpeningScrollComponent.loadCaseDetail(caseSelectingComponent.getSelectedCase());
            }
        });

        //TODO
        final CaseModel caseModel = Singleton.db.caseDao().get(8L);

        view.findViewById(R.id.componentCaseScrollButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                ItemSkinModel[] itemSkinModels = new ItemSkinModel[36];

                for (int i = 0; i < 36; i++) {
                    itemSkinModels[i] = Singleton.db.caseDao().getRandomItemFromColor(caseModel.id, caseModel.caseChance.random());
                }


                caseOpeningScrollComponent.setOnStart(new Runnable() {
                    @Override
                    public void run() {
                        ((Button)view.findViewById(R.id.componentCaseScrollButton)).setText("KASA AÇILIYOR ...");
                        Log.e("asda", "başladı");
                    }
                });
                caseOpeningScrollComponent.setOnFinish(new Runnable() {
                    @Override
                    public void run() {
                        ((Button)view.findViewById(R.id.componentCaseScrollButton)).setText("KASA AÇ");
                        Log.e("aaaa", "bitti");
                    }
                });
                caseOpeningScrollComponent.addToScroll(itemSkinModels);

                caseOpeningScrollComponent.play();
            }
        });

        return view; //TODO
    }
}

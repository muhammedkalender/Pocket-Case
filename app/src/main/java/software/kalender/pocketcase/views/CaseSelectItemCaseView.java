package software.kalender.pocketcase.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.abstracts.ViewAbstract;
import software.kalender.pocketcase.models.CaseModel;

public class CaseSelectItemCaseView extends ViewAbstract<CaseModel> {
    public CaseSelectItemCaseView(@NonNull Context context, @NonNull CaseModel model) {
        super(context, model);
    }

    @Override
    public View generateView() {
        //TODO
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        view = inflater.inflate(R.layout.case_select_item, null);

        //TODO IMAGE, GLIDE VS.. view.findViewById(R.id.imageCase)

        ((TextView) view.findViewById(R.id.nameCase)).setText(model.name);

        return view;
    }
}

package software.kalender.pocketcase.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.abstracts.ViewAbstract;
import software.kalender.pocketcase.models.ItemSkinModel;

public class CaseSelectItemSkinView extends ViewAbstract<ItemSkinModel> {
    public CaseSelectItemSkinView(@NonNull Context context, @NonNull ItemSkinModel model) {
        super(context, model);
    }

    @Override
    public View generateView() {
        //TODO
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        view = inflater.inflate(R.layout.case_select_item_skin, null);

        //TODO IMAGE, GLIDE VS.. view.findViewById(R.id.imageCase)

        ((TextView) view.findViewById(R.id.nameItem)).setText(model.item.name);
        view.findViewById(R.id.nameItem).setBackground(model.color.drawable());

        ((TextView) view.findViewById(R.id.nameSkin)).setText(model.name);
        view.findViewById(R.id.nameSkin).setBackground(model.color.drawable());

        return view;
    }
}

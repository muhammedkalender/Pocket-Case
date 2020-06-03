package software.kalender.pocketcase.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.abstracts.ViewAbstract;
import software.kalender.pocketcase.interfaces.ViewInterface;
import software.kalender.pocketcase.models.ItemSkinModel;

public class OpeningScrollItemView extends ViewAbstract<ItemSkinModel> {
    public OpeningScrollItemView(@NonNull Context context, @NonNull ItemSkinModel itemSkinModel) {
        super(context, itemSkinModel);
    }

    public View generateView() {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        view = inflater.inflate(R.layout.case_opening_item, null);

        //TODO IMAGE
        //TODO IMAGE BACKGORUND
        //TODO UNIQUE ONLY IMAGE ITEM

        view.findViewById(R.id.nameItem).setBackgroundColor(model.color.color());
        ((TextView) view.findViewById(R.id.nameItem)).setText(model.item.name);

        view.findViewById(R.id.nameSkin).setBackgroundColor(model.color.color());
        ((TextView) view.findViewById(R.id.nameSkin)).setText(model.name);

        return view;
    }

    public static OpeningScrollItemView builder(Context context, ItemSkinModel itemSkinModel) {
        return new OpeningScrollItemView(context, itemSkinModel);
    }
}

package software.kalender.pocketcase.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.models.ItemSkinModel;

public class OpeningScrollItemView {
    private Context context;
    private ItemSkinModel itemSkinModel;
    private View view;

    public OpeningScrollItemView(@NonNull Context context, @NonNull ItemSkinModel itemSkinModel) {
        this.context = context;
        this.itemSkinModel = itemSkinModel;
    }

    public View generateView() {
        if (view != null) {
            return view;
        }

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();


        view = inflater.inflate(R.layout.case_opening_item, null);

        //TODO IMAGE
        //TODO IMAGE BACKGORUND
        //TODO UNIQUE ONLY IMAGE ITEM

        view.findViewById(R.id.nameItem).setBackgroundColor(itemSkinModel.color.color());
        ((TextView) view.findViewById(R.id.nameItem)).setText(itemSkinModel.item.name);

        view.findViewById(R.id.nameSkin).setBackgroundColor(itemSkinModel.color.color());
        ((TextView) view.findViewById(R.id.nameSkin)).setText(itemSkinModel.name);

        return view;
    }

    public static OpeningScrollItemView builder(Context context, ItemSkinModel itemSkinModel) {
        return new OpeningScrollItemView(context, itemSkinModel);
    }
}

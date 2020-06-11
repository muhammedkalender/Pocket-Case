package software.kalender.pocketcase.components;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.abstracts.ComponentAbstract;
import software.kalender.pocketcase.codes.ErrorCode;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;

public class WinItemComponent extends ComponentAbstract {
    public WinItemComponent(Context context) {
        super(context);
    }

    public WinItemComponent(Context context, View view) {
        super(context, view);
    }

    @Override
    public View generateView() {
        if(view == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();

            view = inflater.inflate(R.layout.component_win_item, null);
        }

        return view;
    }

    public boolean loadItemQuality(final ItemQualityModel itemQualityModel){
        view.findViewById(R.id.componentWinItemHeader).setBackgroundColor(itemQualityModel.skin.color.color());
        view.findViewById(R.id.componentWinItemQualityAndPrice).setBackgroundColor(itemQualityModel.skin.color.color());
        view.findViewById(R.id.componentWinItemInfo).setBackgroundColor(itemQualityModel.skin.color.color());

        ((TextView)view.findViewById(R.id.componentWinItemQualityAndPrice)).setText(String.format("%1$s - %2$s", itemQualityModel.quality, itemQualityModel.price.getFormattedText()));
        ((TextView)view.findViewById(R.id.componentWinItemInfo)).setText(String.format("%s - %s", itemQualityModel.skin.item.name, itemQualityModel.skin.name));

        ((Button)view.findViewById(R.id.componentWinItemAddInventoryButton)).setText(R.string.win_item_add_inventory);
        view.findViewById(R.id.componentWinItemAddInventoryButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("asda", "naber");
                //TODO

                InventoryItemModel inventoryItemModel = new InventoryItemModel();
                inventoryItemModel.quality = itemQualityModel;
                inventoryItemModel.insert();

                List<InventoryItemModel> inventoryItemModels = Singleton.db.inventoryItemDao().list();
                ((RelativeLayout)WinItemComponent.this.view.getParent()).removeView(WinItemComponent.this.view);

                Log.e("aa", "ddd");
            }
        });

        ((Button)view.findViewById(R.id.componentWinItemSellButton)).setText(Singleton.resource.getString(R.string.win_item_sell, itemQualityModel.price.getFormattedText()));
        view.findViewById(R.id.componentWinItemSellButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO

                Singleton.userHelper.sumBalance(itemQualityModel.price);


                ((RelativeLayout)WinItemComponent.this.view.getParent()).removeView(WinItemComponent.this.view);
                Log.e("asda", "moruq");
            }
        });

        //TODO
        return true;
    }
}

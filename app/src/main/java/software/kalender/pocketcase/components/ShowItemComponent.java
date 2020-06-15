package software.kalender.pocketcase.components;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.abstracts.ComponentAbstract;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;

public class ShowItemComponent extends ComponentAbstract {
    public Runnable onSell, onClose;

    public ShowItemComponent(Context context) {
        super(context);
    }

    public ShowItemComponent(Context context, View view) {
        super(context, view);
    }

    public Runnable getOnSell() {
        return onSell;
    }

    public void setOnSell(Runnable onSell) {
        this.onSell = onSell;
    }

    public Runnable getOnClose() {
        return onClose;
    }

    public void setOnClose(Runnable onClose) {
        this.onClose = onClose;
    }

    @Override
    public View generateView() {
        if(view == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();

            view = inflater.inflate(R.layout.component_show_item, null);
        }

        return view;
    }

    public boolean loadInventoryItem(final InventoryItemModel inventoryItemModel){
        view.findViewById(R.id.componentShowItemQualityAndPrice).setBackgroundColor(inventoryItemModel.quality.skin.color.color());
        view.findViewById(R.id.componentShowItemInfo).setBackgroundColor(inventoryItemModel.quality.skin.color.color());

        ((TextView)view.findViewById(R.id.componentShowItemQualityAndPrice)).setText(String.format("%1$s - %2$s", inventoryItemModel.quality.quality, inventoryItemModel.quality.price.getFormattedText()));
        ((TextView)view.findViewById(R.id.componentShowItemInfo)).setText(String.format("%s - %s", inventoryItemModel.quality.skin.item.name, inventoryItemModel.quality.skin.name));

        ((Button)view.findViewById(R.id.componentShowItemCloseButton)).setText(R.string.show_item_close_button);
        view.findViewById(R.id.componentShowItemCloseButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("asda", "naber");
                //TODO
                ((RelativeLayout)ShowItemComponent.this.view.getParent()).removeView(ShowItemComponent.this.view);


                Log.e("aa", "ddd");
                if(onClose != null){
                    onClose.run();
                }
            }
        });

        ((Button)view.findViewById(R.id.componentShowItemSellButton)).setText(Singleton.resource.getString(R.string.show_item_sell, inventoryItemModel.quality.price.getFormattedText()));
        view.findViewById(R.id.componentShowItemSellButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO

                Singleton.userHelper.sumBalance(inventoryItemModel.quality.price);


                //TODO LOG
                Singleton.db.inventoryItemDao().passive(inventoryItemModel.inventoryItemId);

                ((RelativeLayout)ShowItemComponent.this.view.getParent()).removeView(ShowItemComponent.this.view);

                if(onSell != null){
                    onSell.run();
                }
                Log.e("asda", "moruq");
            }
        });

        //TODO
        return true;
    }
}

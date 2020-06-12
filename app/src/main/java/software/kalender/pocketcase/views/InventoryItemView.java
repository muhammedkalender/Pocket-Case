package software.kalender.pocketcase.views;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.abstracts.ViewAbstract;
import software.kalender.pocketcase.models.InventoryItemModel;

public class InventoryItemView extends ViewAbstract<InventoryItemModel> {
    private View.OnClickListener onItemClick;
    private boolean selected = false;

    public InventoryItemView(@NonNull Context context, InventoryItemModel model) {
        super(context, model);
    }

    @Override
    public View generateView() {
        LayoutInflater layoutInflater = ((Activity)this.context).getLayoutInflater();
        //TODO

         view = layoutInflater.inflate(R.layout.inventory_item, null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                Log.e("azz", "asdas");
                if(isSelected()){
                    setSelected(false);

                    InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).setVisibility(View.INVISIBLE);
                    InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).bringToFront();
                }else{
                    setSelected(true);

                    InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).setVisibility(View.VISIBLE);
                    InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).bringToFront();
                }

                if(onItemClick != null){
                    onItemClick.onClick(view);
                }
            }
        });

        ((TextView)view.findViewById(R.id.componentInventoryItemQuality)).setText(model.quality.quality);
        ((TextView)view.findViewById(R.id.componentInventoryItemName)).setText(model.quality.skin.item.name);
        ((TextView)view.findViewById(R.id.componentInventoryItemSkin)).setText(model.quality.skin.name);
        ((TextView)view.findViewById(R.id.componentInventoryItemPrice)).setText(model.quality.price.getFormattedText());

        return view;
    }

    public View.OnClickListener getOnItemClick() {
        return onItemClick;
    }

    public void setOnItemClick(View.OnClickListener onItemClick) {
        this.onItemClick = onItemClick;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

package software.kalender.pocketcase.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.abstracts.ViewAbstract;
import software.kalender.pocketcase.models.InventoryItemModel;

public class InventoryItemView extends ViewAbstract<InventoryItemModel> {
    //region Private Variables

    private View.OnClickListener onItemClick;
    private Runnable onItemSelected, onItemUnSelected;
    private boolean selected = false;
    private boolean selectable = false;

    //endregion

    //region Constructors

    public InventoryItemView(@NonNull Context context, InventoryItemModel model) {
        super(context, model);
    }

    //endregion

    //region Generator

    @Override
    public View generateView() {
        LayoutInflater layoutInflater = ((Activity) this.context).getLayoutInflater();
        //TODO

        view = layoutInflater.inflate(R.layout.inventory_item, null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                if (selectable) {
                    if (isSelected()) {
                        setSelected(false);

                        InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).setVisibility(View.INVISIBLE);
                        InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).bringToFront();

                        if (onItemUnSelected != null) {
                            onItemUnSelected.run();
                        }
                    } else {
                        setSelected(true);

                        InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).setVisibility(View.VISIBLE);
                        InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).bringToFront();

                        if (onItemSelected != null) {
                            onItemSelected.run();
                        }
                    }
                }

                if (onItemClick != null) {
                    onItemClick.onClick(view);
                }
            }
        });

        ((TextView) view.findViewById(R.id.componentInventoryItemQuality)).setText(model.quality.quality);
        view.findViewById(R.id.componentInventoryItemQuality).setBackgroundColor(model.quality.skin.color.color());
        ((TextView) view.findViewById(R.id.componentInventoryItemName)).setText(model.quality.skin.item.name);
        view.findViewById(R.id.componentInventoryItemName).setBackgroundColor(model.quality.skin.color.color());
        ((TextView) view.findViewById(R.id.componentInventoryItemSkin)).setText(model.quality.skin.name);
        view.findViewById(R.id.componentInventoryItemSkin).setBackgroundColor(model.quality.skin.color.color());
        ((TextView) view.findViewById(R.id.componentInventoryItemPrice)).setText(model.quality.price.getFormattedText());

        if(model.quality.statTrak){
            view.findViewById(R.id.componentInventoryItemStattrak).setVisibility(View.VISIBLE);
        }else{
            view.findViewById(R.id.componentInventoryItemStattrak).setVisibility(View.GONE);
        }

        view.setTag(model.inventoryItemId);

        return view;
    }

    //endregion

    //region Getters & Setters

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    //endregion

    //region EVents

    public View.OnClickListener getOnItemClick() {
        return onItemClick;
    }

    public void setOnItemClick(View.OnClickListener onItemClick) {
        this.onItemClick = onItemClick;
    }

    public Runnable getOnItemSelected() {
        return onItemSelected;
    }

    public void setOnItemSelected(Runnable onItemSelected) {
        this.onItemSelected = onItemSelected;
    }

    public Runnable getOnItemUnSelected() {
        return onItemUnSelected;
    }

    public void setOnItemUnSelected(Runnable onItemUnSelected) {
        this.onItemUnSelected = onItemUnSelected;
    }

    //endregion

    //region Secondary Methods

    public void revertSelection() {
        setSelected(false);

        InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).setVisibility(View.INVISIBLE);
        InventoryItemView.this.view.findViewById(R.id.componentInventoryItemSelected).bringToFront();
    }

    //endregion
}

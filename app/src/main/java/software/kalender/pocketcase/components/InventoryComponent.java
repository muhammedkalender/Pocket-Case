package software.kalender.pocketcase.components;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;

import java.util.List;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.abstracts.ComponentAbstract;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.views.InventoryItemView;

public class InventoryComponent extends ComponentAbstract {
    private boolean itemSelectionEnable = false;
    private int itemSelectionLimit = 10;

    private boolean itemSelectionBalanceLimit = false;
    private long selectedBalanceLowerLimit = 0L;
    private long selectedBalanceUpperLimit = 0L;

    private long selectedItemBalance = 0L;

    //Gerekli şartları sağlıyorsa
    private Runnable onValidated;

    //Gerekli şartları sağlıyordu ama şimdi sağlamıyor
    private Runnable onCancelValidation;

    public InventoryComponent(Context context) {
        super(context);
    }

    public InventoryComponent(Context context, View view) {
        super(context, view);
    }

    public boolean isItemSelectionEnable() {
        return itemSelectionEnable;
    }

    public void setItemSelectionEnable(boolean itemSelectionEnable, int itemSelectionLimit) {
        this.itemSelectionEnable = itemSelectionEnable;
        this.itemSelectionLimit = itemSelectionLimit;
    }

    public int getItemSelectionLimit() {
        return itemSelectionLimit;
    }

    public void setItemSelectionLimit(int itemSelectionLimit) {
        this.itemSelectionLimit = itemSelectionLimit;
    }

    public void setItemSelectionEnable(boolean itemSelectionEnable) {
        this.itemSelectionEnable = itemSelectionEnable;
    }

    public boolean isItemSelectionBalanceLimit() {
        return itemSelectionBalanceLimit;
    }

    public void setItemSelectionBalanceLimit(boolean itemSelectionBalanceLimit) {
        this.itemSelectionBalanceLimit = itemSelectionBalanceLimit;
    }

    public long getSelectedBalanceLowerLimit() {
        return selectedBalanceLowerLimit;
    }

    public void setSelectedBalanceLowerLimit(long selectedBalanceLowerLimit) {
        this.selectedBalanceLowerLimit = selectedBalanceLowerLimit;
    }

    public long getSelectedBalanceUpperLimit() {
        return selectedBalanceUpperLimit;
    }

    public void setSelectedBalanceUpperLimit(long selectedBalanceUpperLimit) {
        this.selectedBalanceUpperLimit = selectedBalanceUpperLimit;
    }

    public Runnable getOnValidated() {
        return onValidated;
    }

    public void setOnValidated(Runnable onValidated) {
        this.onValidated = onValidated;
    }

    public Runnable getOnCancelValidation() {
        return onCancelValidation;
    }

    public void setOnCancelValidation(Runnable onCancelValidation) {
        this.onCancelValidation = onCancelValidation;
    }

    public boolean isValid() {
        if (getSelectedBalanceLowerLimit() != 0L) {

        }

        return true;
    }

    @Override
    public View generateView() {
        if(view == null){
            LayoutInflater layoutInflater = ((Activity) this.context).getLayoutInflater();

            this.view = layoutInflater.inflate(R.layout.component_inventory, null);

        }
        //TODO

        List<InventoryItemModel> inventoryItemModels = Singleton.db.inventoryItemDao().list();


        for (InventoryItemModel inventoryItemModel : inventoryItemModels) {
            InventoryItemView inventoryItemView = new InventoryItemView(this.context, inventoryItemModel);

            if (isItemSelectionEnable()) {
                inventoryItemView.setOnItemSelected(new Runnable() {
                    @Override
                    public void run() {
                        //TODO
                    }
                });

                inventoryItemView.setOnItemUnSelected(new Runnable() {
                    @Override
                    public void run() {
                        //TODO
                    }
                });

                inventoryItemView.setOnItemClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO
                    }
                });
            }

            View _view = inventoryItemView.getView();

            ((GridLayout) this.view.findViewById(R.id.componentInventoryGrid)).addView(_view);
        }

        return this.view;
    }
}

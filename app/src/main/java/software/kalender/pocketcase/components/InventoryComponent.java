package software.kalender.pocketcase.components;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.sqlite.db.SimpleSQLiteQuery;

import java.util.HashMap;
import java.util.List;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.abstracts.ComponentAbstract;
import software.kalender.pocketcase.enums.ColorEnum;
import software.kalender.pocketcase.enums.CurrencyEnum;
import software.kalender.pocketcase.helpers.MoneyHelper;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.ItemTypeModel;
import software.kalender.pocketcase.views.InventoryItemView;

public class InventoryComponent extends ComponentAbstract {
    private HashMap<Long, InventoryItemModel> selectedItems = new HashMap<>();

    private boolean selectedItemEnable = false;
    private int selectedItemCountLowerLimit = 0;
    private int selectedItemCountUpperLimit = 0;
    private int selectedItemCount = 0;

    private boolean itemSelectionBalanceLimit = false;
    private long selectedBalanceLowerLimit = 0L;
    private long selectedBalanceUpperLimit = 0L;

    private long selectedItemBalance = 0L;

    private boolean showItemInfo = false;
    private RelativeLayout showItemInfoLayout = null;

    //region Filter Variables

    private boolean filterEnable = false;
    private boolean filterPaginationEnable = false;

    private Boolean filterStattrak;
    private Long filterItemType;
    private ColorEnum filterColor;

    //Background filters
    private Long filterCase;

    private int filterCurrentPage = 0;
    private int filterTotalPage = 0;
    private int filterPageCount = 9;
    private int filterTotalCount = 0;
    private String filterOrderBy = "itemSkinColor";

    private List<InventoryItemModel> filterItems;

    //endregion

    //Gerekli şartları sağlıyorsa
    private Runnable onValidated;

    //Gerekli şartları sağlıyordu ama şimdi sağlamıyor
    private Runnable onCancelValidation;

    private Runnable onFilterReset;

    public InventoryComponent(Context context) {
        super(context);
    }

    public InventoryComponent(Context context, View view) {
        super(context, view);
    }

    public boolean isSelectedItemEnable() {
        return selectedItemEnable;
    }

    public void setSelectedItemEnable(boolean selectedItemEnable) {
        this.selectedItemEnable = selectedItemEnable;
    }

    public void setSelectedItemEnable(boolean selectedItemEnable, int selectedItemCount) {
        this.selectedItemEnable = selectedItemEnable;
        this.selectedItemCountUpperLimit = selectedItemCount;
    }

    public int getSelectedItemCountLowerLimit() {
        return selectedItemCountLowerLimit;
    }

    public void setSelectedItemCountLowerLimit(int selectedItemCountLowerLimit) {
        this.selectedItemCountLowerLimit = selectedItemCountLowerLimit;
    }

    public int getSelectedItemCountUpperLimit() {
        return selectedItemCountUpperLimit;
    }

    public void setSelectedItemCountUpperLimit(int selectedItemCountUpperLimit) {
        this.selectedItemCountUpperLimit = selectedItemCountUpperLimit;
    }

    public boolean isShowItemInfo() {
        return showItemInfo;
    }

    public void setShowItemInfo(boolean showItemInfo) {
        this.showItemInfo = showItemInfo;
    }

    public Long getFilterCase() {
        return filterCase;
    }

    public void setFilterCase(Long filterCase) {
        this.filterCase = filterCase;
    }

    public String getFilterOrderBy() {
        return filterOrderBy;
    }

    public void setFilterOrderBy(String filterOrderBy) {
        this.filterOrderBy = filterOrderBy;
    }

    public Runnable getOnFilterReset() {
        return onFilterReset;
    }

    public void setOnFilterReset(Runnable onFilterReset) {
        this.onFilterReset = onFilterReset;
    }

    public boolean isFilterEnable() {
        return filterEnable;
    }

    public void setFilterEnable(boolean filterEnable) {
        this.filterEnable = filterEnable;
    }

    public boolean isFilterPaginationEnable() {
        return filterPaginationEnable;
    }

    public void setFilterPaginationEnable(boolean filterPaginationEnable) {
        this.filterPaginationEnable = filterPaginationEnable;
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

    public void setShowItemEnable(RelativeLayout relativeLayout) {
        showItemInfoLayout = relativeLayout;
        showItemInfo = true;
        selectedItemEnable = false;
    }

    public void setDisableShowItem() {
        showItemInfo = false;
    }

    public boolean isValid() {
        if (selectedItemEnable) {
            if (selectedItemCountLowerLimit != 0) {
                if (selectedBalanceLowerLimit > selectedItemCount) {
                    return false;
                }
            }

            if (selectedItemCountUpperLimit != 0) {
                if (selectedItemCountUpperLimit < selectedItemCount) {
                    return false;
                }
            }
        }

        if (selectedBalanceLowerLimit != 0L) {
            if (selectedItemBalance < selectedBalanceLowerLimit) {
                return false;
            }
        }

        if (selectedBalanceUpperLimit != 0L) {
            if (selectedItemBalance > selectedBalanceUpperLimit) {
                return false;
            }
        }

        return true;
    }

    public long getSelectedItemBalance() {
        return selectedItemBalance;
    }

    public void setSelectedItemBalance(long selectedItemBalance) {
        boolean beforeTransaction = isValid();

        this.selectedItemBalance = selectedItemBalance;

        if (isValid()) {
            if (!beforeTransaction) {
                if (onValidated != null) {
                    onValidated.run();
                }
            }
        } else {
            if (beforeTransaction) {
                if (onCancelValidation != null) {
                    onCancelValidation.run();
                }
            }
        }
    }

    private void minusSelectedItemBalance(@NonNull ItemQualityModel itemQualityModel) {
        setSelectedItemBalance(getSelectedItemBalance() - itemQualityModel.price.getBalance());
    }

    private void plusSelectedItemBalance(@NonNull ItemQualityModel itemQualityModel) {
        setSelectedItemBalance(getSelectedItemBalance() + itemQualityModel.price.getBalance());
    }

    public void addItemToSelected(InventoryItemModel inventoryItemModel) {
        selectedItems.put(inventoryItemModel.inventoryItemId, inventoryItemModel);
        selectedItemCount++;
        plusSelectedItemBalance(inventoryItemModel.quality);
    }

    public void delItemFromSelected(InventoryItemModel inventoryItemModel) {
        selectedItems.remove(inventoryItemModel.inventoryItemId);
        selectedItemCount--;
        minusSelectedItemBalance(inventoryItemModel.quality);
    }

    public HashMap<Long, InventoryItemModel> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(HashMap<Long, InventoryItemModel> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<InventoryItemModel> filter() {
        return filter(true);
    }

    public List<InventoryItemModel> filter(boolean chanceFilter) {
        if (chanceFilter) {
            //TODO
            selectedItems.clear();
            selectedItemCount = 0;
            selectedItemBalance = 0;
            filterCurrentPage = 0;

            if (onFilterReset != null) {
                onFilterReset.run();
            }
        }

        String query = "";

        if (filterStattrak != null) {
            query += " AND itemQualityStatTrak = " + (filterStattrak ? 1 : 0);
        }

        if (filterColor != null) {
            query += " AND itemSkinColor = " + filterColor.ordinal();
        }

        if (filterItemType != null) {
            query += " AND itemTypeId = " + filterItemType;
        }

        if(filterCase != null){
            query += " AND item caseId = " + filterCase;
        }

        String suffix = " ORDER BY " + filterOrderBy + " DESC LIMIT " + filterPageCount + " OFFSET " + (filterCurrentPage * filterPageCount);

        filterItems = Singleton.db.inventoryItemDao().listQueryWithPagination(new SimpleSQLiteQuery("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 " + query + suffix));
        filterTotalCount = Singleton.db.inventoryItemDao().countQuery(new SimpleSQLiteQuery("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1 " + query));

        if (filterTotalCount == 0) {
            filterTotalPage = 1;
        } else {
            float page = (float) (filterTotalCount) / (float) (filterPageCount);

            filterTotalPage = (int) page;

            if (page - filterTotalPage > 0) {
                filterTotalPage++;
            }
        }

        //TODO
        return filterItems;
    }

    @Override
    public View generateView() {
        if (view == null) {
            LayoutInflater layoutInflater = ((Activity) this.context).getLayoutInflater();

            this.view = layoutInflater.inflate(R.layout.component_inventory, null);

        }
        //TODO

        filter();

        refreshUI();

        this.view.findViewById(R.id.componentInventoryFilterStattrak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
                //builderSingle.setIcon(R.drawable.ic_format_list_bulleted_24dp);
                builderSingle.setTitle("TODO");

                String[] choices = new String[]{"Farketmez", "Evet", "Hayır"};

                builderSingle.setSingleChoiceItems(choices, filterStattrak == null ? 0 : (filterStattrak ? 1 : 2), (dialog, which) -> {
                    dialog.dismiss();

                    switch (which) {
                        case 0:
                            filterStattrak = null;
                            break;
                        case 1:
                            filterStattrak = true;
                            break;
                        case 2:
                            filterStattrak = false;
                            break;
                    }

                    filter();
                    refreshUI();

                    Log.e("asda", which + "--");
                });

                builderSingle.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builderSingle.show();
            }
        });

        this.view.findViewById(R.id.componentInventoryFilterColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
                //builderSingle.setIcon(R.drawable.ic_format_list_bulleted_24dp);
                builderSingle.setTitle("TODO");

                String[] choices = new String[ColorEnum.values().length + 1];
                choices[0] = "heosş"; //todo

                int index = 0;

                for (int i = 0; i < choices.length - 1; i++) {
                    choices[i + 1] = ColorEnum.values()[i].name();

                    if (filterColor != null && ColorEnum.values()[i] == filterColor) {
                        index = i + 1;
                    }
                }

                builderSingle.setSingleChoiceItems(choices, index, (dialog, which) -> {
                    dialog.dismiss();

                    if (which == 0) {
                        filterColor = null;
                    } else {
                        filterColor = ColorEnum.values()[which - 1];
                    }

                    filter();
                    refreshUI();

                    Log.e("asda", which + "--");
                });

                builderSingle.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builderSingle.show();
            }
        });

        this.view.findViewById(R.id.componentInventoryFilterItemType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
                //builderSingle.setIcon(R.drawable.ic_format_list_bulleted_24dp);
                builderSingle.setTitle("TODO");

                List<ItemTypeModel> itemTypeModels = Singleton.db.itemTypeDao().list();

                String[] choices = new String[itemTypeModels.size() + 1];
                choices[0] = "Hepsi"; //todo

                int index = 0;

                for (int i = 0; i < choices.length - 1; i++) {
                    choices[i + 1] = itemTypeModels.get(i).name;

                    if (filterItemType != null && filterItemType == itemTypeModels.get(i).itemTypeId) {
                        index = i + 1;
                    }
                }

                builderSingle.setSingleChoiceItems(choices, index, (dialog, which) -> {
                    dialog.dismiss();

                    if (which == 0) {
                        filterItemType = null;
                    } else {
                        filterItemType = itemTypeModels.get(which - 1).itemTypeId;
                    }

                    filter();
                    refreshUI();

                    Log.e("asda", which + "--");
                });

                builderSingle.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builderSingle.show();
            }
        });

        this.view.findViewById(R.id.componentInventoryFilterPanel).setVisibility(filterEnable ? View.VISIBLE : View.GONE);
        this.view.findViewById(R.id.componentInventoryPaginationMovePanel).setVisibility(filterPaginationEnable ? View.VISIBLE : View.GONE); //TODO
        this.view.findViewById(R.id.componentInventoryPaginationInfoPanel).setVisibility(filterPaginationEnable ? View.VISIBLE : View.GONE); //TODO

        return this.view;
    }

    public void refreshUI() {
        MoneyHelper moneyHelper = MoneyHelper.make(CurrencyEnum.USD, 0L);

        ((GridLayout) this.view.findViewById(R.id.componentInventoryGrid)).removeAllViews();

        for (InventoryItemModel inventoryItemModel : filterItems) {
            InventoryItemView inventoryItemView = new InventoryItemView(this.context, inventoryItemModel);

            moneyHelper.sum(inventoryItemModel.quality.price);

            if (selectedItemEnable) {
                inventoryItemView.setSelectable(true);

                inventoryItemView.setOnItemSelected(() -> {
                    if (selectedItemCountUpperLimit != 0 && selectedItemCountUpperLimit <= selectedItemCount) {
                        inventoryItemView.revertSelection();
                    } else {
                        addItemToSelected(inventoryItemModel);

                        Log.e("asda", String.valueOf(selectedItemBalance));
                    }

                    //TODO
                });

                inventoryItemView.setOnItemUnSelected(new Runnable() {
                    @Override
                    public void run() {
                        delItemFromSelected(inventoryItemModel);


                        Log.e("unslect", String.valueOf(selectedItemBalance));
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

            if (showItemInfo && showItemInfoLayout != null) {
                inventoryItemView.setOnItemClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ShowItemComponent showItemComponent = new ShowItemComponent(InventoryComponent.super.context);
                        showItemInfoLayout.addView(showItemComponent.getView());
                        showItemComponent.loadInventoryItem(inventoryItemModel);
                        showItemComponent.setOnSell(new Runnable() {
                            @Override
                            public void run() {
                                ((GridLayout) inventoryItemView.getView().getParent()).removeView(inventoryItemView.getView());
                            }
                        });
                    }
                });
            }

            View _view = inventoryItemView.getView();

            if (selectedItems.get(inventoryItemModel.inventoryItemId) != null) {
                inventoryItemView.setSelected(true);
            }

            ((GridLayout) this.view.findViewById(R.id.componentInventoryGrid)).addView(_view);
        }

        ((TextView) view.findViewById(R.id.componentInventoryInfoTotalValue)).setText(moneyHelper.getFormattedText());
        ((TextView) view.findViewById(R.id.componentInventoryInfoPages)).setText(String.format("%d/%d", filterCurrentPage + 1, filterTotalPage));

        view.findViewById(R.id.componentInventoryBackPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backPage();
            }
        });

        view.findViewById(R.id.componentInventoryNextPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextPage();
            }
        });
    }

    public void nextPage() {
        if (filterCurrentPage == filterTotalPage - 1) {
            return;
        }

        filterCurrentPage++;

        filter(false);
        refreshUI();

        //TODO
    }

    public void backPage() {
        if (filterCurrentPage == 0) {
            return;
        }

        filterCurrentPage--;

        filter(false);
        refreshUI();

        //TODO
    }
}

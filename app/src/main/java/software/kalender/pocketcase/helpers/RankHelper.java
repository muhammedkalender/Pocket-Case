package software.kalender.pocketcase.helpers;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.RankModel;

public class RankHelper {
    //region Private Variables

    private long inventoryValue = 0;
    private RankModel rank;

    //endregion

    //region Constructors

    public RankHelper() {
        this.inventoryValue = Singleton.db.inventoryItemDao().calculateInventoryValue();

        this.rank = Singleton.db.rankDao().currentRank(this.inventoryValue);
    }

    public RankHelper(long inventoryValue) {
        this.inventoryValue = inventoryValue;

        this.rank = Singleton.db.rankDao().currentRank(this.inventoryValue);
    }

    //endregion

    //region Getters

    public long getInventoryValue() {
        return inventoryValue;
    }

    //endregion

    //region Add Item

    public boolean addItem(ItemQualityModel itemQualityModel) {
        return addItem(itemQualityModel.price);
    }

    public boolean addItem(InventoryItemModel inventoryItemModel) {
        return addItem(inventoryItemModel.quality.price);
    }

    public boolean addItem(MoneyHelper moneyHelper) {
        //TODO

        inventoryValue += moneyHelper.getBalance();

        if (inventoryValue >= rank.moneyToRankUp) {
            return true;
        }

        return false;
    }

    //endregion

    //region Del Item

    public boolean delItem(ItemQualityModel itemQualityModel) {
        return delItem(itemQualityModel.price);
    }

    public boolean delItem(InventoryItemModel inventoryItemModel) {
        return delItem(inventoryItemModel.quality.price);
    }

    public boolean delItem(MoneyHelper moneyHelper) {
        inventoryValue -= moneyHelper.getBalance();

        if (inventoryValue < rank.moneyToRank) {
            return true;
        }

        return false;
    }

    //endregion
}

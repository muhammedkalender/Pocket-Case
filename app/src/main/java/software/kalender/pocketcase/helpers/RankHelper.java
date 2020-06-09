package software.kalender.pocketcase.helpers;

import androidx.room.Ignore;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.RankModel;

public class RankHelper {
    //region Private Variables

    @Ignore
    private long inventoryValue = 0;

    @Ignore
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

    @Ignore
    public long getInventoryValue() {
        return inventoryValue;
    }

    //endregion

    //region Add Item

    @Ignore
    public boolean addItem(ItemQualityModel itemQualityModel) {
        return addItem(itemQualityModel.price);
    }

    @Ignore
    public boolean addItem(InventoryItemModel inventoryItemModel) {
        return addItem(inventoryItemModel.quality.price);
    }

    @Ignore
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

    @Ignore
    public boolean delItem(ItemQualityModel itemQualityModel) {
        return delItem(itemQualityModel.price);
    }

    @Ignore
    public boolean delItem(InventoryItemModel inventoryItemModel) {
        return delItem(inventoryItemModel.quality.price);
    }

    @Ignore
    public boolean delItem(MoneyHelper moneyHelper) {
        inventoryValue -= moneyHelper.getBalance();

        if (inventoryValue < rank.moneyToRank) {
            return true;
        }

        return false;
    }

    //endregion
}

package software.kalender.pocketcase.database;

import androidx.room.TypeConverter;

import java.security.Key;
import java.util.Date;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.enums.ColorEnum;
import software.kalender.pocketcase.enums.CurrencyEnum;
import software.kalender.pocketcase.helpers.MoneyHelper;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.ItemSkinModel;
import software.kalender.pocketcase.models.ItemTypeModel;
import software.kalender.pocketcase.models.KeyModel;

//https://developer.android.com/training/data-storage/room/referencing-data
public class Converters {
    //region Date

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    //endregion

    //region Color Enum

    @TypeConverter
    public static ColorEnum colorFromIndex(int index) {
        return ColorEnum.values()[index];
    }

    @TypeConverter
    public static int colorEnumToInteger(ColorEnum colorEnum) {
        return colorEnum.ordinal();
    }

    //endregion

    //region Case

    @TypeConverter
    public static CaseModel caseModelFromId(long id) {
        return Singleton.db.caseDao().get(id);
    }

    @TypeConverter
    public static long caseModelToId(CaseModel caseModel) {
        return caseModel == null ? 0 : caseModel.id;
    }

    //endregion

    //region Inventory Item

    @TypeConverter
    public static long inventoryItemToId(InventoryItemModel inventoryItemModel) {
        return inventoryItemModel == null ? 0 : inventoryItemModel.id;
    }

    @TypeConverter
    public static InventoryItemModel inventoryItemFromId(long id) {
        return Singleton.db.inventoryItemDao().get(id);
    }

    //endregion

    //region Item

    @TypeConverter
    public static long itemToId(ItemModel itemModel) {
        return itemModel == null ? 0 : itemModel.id;
    }

    @TypeConverter
    public static ItemModel itemFromId(long id) {
        return Singleton.db.itemDao().get(id);
    }

    //endregion

    //region Item Quality

    @TypeConverter
    public static long itemQualityToId(ItemQualityModel itemQualityModel) {
        return itemQualityModel == null ? 0 : itemQualityModel.id;
    }

    @TypeConverter
    public static ItemQualityModel itemQualityFromId(long id) {
        return Singleton.db.itemQualityDao().get(id);
    }

    //endregion

    //region Item Skin

    @TypeConverter
    public static long itemSkinToId(ItemSkinModel itemSkinModel) {
        return itemSkinModel == null ? 0 : itemSkinModel.id;
    }

    @TypeConverter
    public static ItemSkinModel itemSkinFromId(long id) {
        return Singleton.db.itemSkinDao().get(id);
    }

    //endregion

    //region Item Type

    @TypeConverter
    public static long itemTypeToId(ItemTypeModel Model) {
        return Model == null ? 0 : Model.id;
    }

    @TypeConverter
    public static ItemTypeModel itemTypeFromId(long id) {
        return Singleton.db.itemTypeDao().get(id);
    }

    //endregion

    //region Key

    @TypeConverter
    public static KeyModel keyFromId(long id) {
        return Singleton.db.keyDao().get(id);
    }

    @TypeConverter
    public static long keyToId(KeyModel keyModel) {
        return keyModel == null ? 0 : keyModel.id;
    }

    //endregion

    //region Money Helper

    @TypeConverter
    public static String moneyToString(MoneyHelper moneyHelper) {
        if (moneyHelper == null || moneyHelper.getCurrency() == null) {
            return "";
        }

        return moneyHelper.getCurrency().ordinal() + "|" + moneyHelper.getBalance();
    }

    @TypeConverter
    public static MoneyHelper moneyFromString(String moneyString) {
        if (moneyString.equals("")) {
            return MoneyHelper.make(CurrencyEnum.USD, 0L);
        }

        CurrencyEnum currency = CurrencyEnum.values()[Integer.parseInt(String.valueOf(moneyString.charAt(0)))];

        MoneyHelper money = new MoneyHelper();
        money.setCurrency(currency);
        money.setBalance(Long.valueOf(moneyString.substring(2)));

        return money;
    }

    //endregion
}


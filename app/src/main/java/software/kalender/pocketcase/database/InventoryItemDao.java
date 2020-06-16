package software.kalender.pocketcase.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.enums.ColorEnum;
import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.InventoryItemModel;

@Dao
public interface InventoryItemDao extends DaoInterface<InventoryItemModel> {
    @Query("SELECT * FROM 'inventoryItems' WHERE inventoryItemId = :id")
    public InventoryItemModel get(long id);

    @Query("SELECT SUM(itemQualityPrice) FROM inventoryItems WHERE inventoryItemActive = 1")
    public long calculateInventoryValue();

    @Query("SELECT SUM(itemQualityPrice) FROM inventoryItems")
    public long calculateInventoryValueIncludePassives();

    @Query("UPDATE inventoryItems SET inventoryItemActive = 0 WHERE inventoryItemId = :inventoryItemId")
    public void passive(long inventoryItemId);

    //region List

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 ORDER BY itemSkinColor DESC")
    public List<InventoryItemModel> list();

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 ORDER BY itemSkinColor DESC LIMIT :count OFFSET :skip")
    public List<InventoryItemModel> listWithPagination(int count, int skip);

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 AND itemQualityStatTrak = :stattrak ORDER BY itemSkinColor DESC LIMIT :count OFFSET :skip")
    public List<InventoryItemModel> listFromStattrakWithPagination(boolean stattrak, int count, int skip);

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 AND itemSkinColor = :color LIMIT :count OFFSET :skip")
    public List<InventoryItemModel> listFromColorWithPagination(ColorEnum color, int count, int skip);

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 AND itemTypeId = :type ORDER BY itemSkinColor DESC LIMIT :count OFFSET :skip")
    public List<InventoryItemModel> listFromColorWithPagination(int type, int count, int skip);

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 AND itemQualityStatTrak = :stattrak and itemSkinColor = :color ORDER BY itemSkinColor DESC LIMIT :count OFFSET :skip")
    public List<InventoryItemModel> listFromStattrakAndColorWithPagination(boolean stattrak, ColorEnum color, int count, int skip);

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 AND itemSkinColor = :color AND itemTypeId = :type LIMIT :count OFFSET :skip")
    public List<InventoryItemModel> listFromColorAndTypeWithPagination(ColorEnum color, int type, int count, int skip);

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 AND itemQualityStatTrak = :stattrak and itemTypeId = :type ORDER BY itemSkinColor DESC LIMIT :count OFFSET :skip")
    public List<InventoryItemModel> listFromStattrakAndColorWithPagination(boolean stattrak, int type, int count, int skip);

    @Query("SELECT * FROM inventoryItems WHERE inventoryItemActive = 1 AND itemQualityStatTrak = :stattrak and itemSkinColor = :color AND itemTypeId = :type ORDER BY itemSkinColor DESC LIMIT :count OFFSET :skip")
    public List<InventoryItemModel> listFromStattrakAndColorAndTypeWithPagination(boolean stattrak, ColorEnum color, int type, int count, int skip);

    //endregion

    //region Item Count

    @Query("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1")
    public int count();

    @Query("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1 AND itemQualityStatTrak = :stattrak")
    public int countFromStattrak(boolean stattrak);

    @Query("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1 AND itemSkinColor = :color")
    public int countFromColor(ColorEnum color);

    @Query("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1 AND itemTypeId = :type")
    public int countFromColor(int type);

    @Query("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1 AND itemQualityStatTrak = :stattrak and itemSkinColor = :color")
    public int countFromStattrakAndColor(boolean stattrak, ColorEnum color);

    @Query("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1 AND itemTypeId = :type AND itemSkinColor = :color")
    public int countFromColorAndType(ColorEnum color, int type);

    @Query("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1 AND itemQualityStatTrak = :stattrak and itemTypeId = :type")
    public int countFromStattrakAndColor(boolean stattrak, int type);

    @Query("SELECT COUNT(*) FROM inventoryItems WHERE inventoryItemActive = 1 AND itemQualityStatTrak = :stattrak and itemSkinColor = :color AND itemTypeId = :type")
    public int countFromStattrakAndColorAndType(boolean stattrak, ColorEnum color, int type);

    //endregion
}

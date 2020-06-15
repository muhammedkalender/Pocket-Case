package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.InventoryItemModel;

@Dao
public interface InventoryItemDao extends DaoInterface<InventoryItemModel> {
    @Query("SELECT * FROM 'inventoryItems' WHERE inventoryItemId = :id")
    public InventoryItemModel get(long id);

    @Query("SELECT * FROM 'inventoryItems' WHERE inventoryItemActive = 1")
    public List<InventoryItemModel> list();

    @Query("SELECT SUM(itemQualityPrice) FROM inventoryItems WHERE inventoryItemActive = 1")
    public long calculateInventoryValue();

    @Query("SELECT SUM(itemQualityPrice) FROM inventoryItems")
    public long calculateInventoryValueIncludePassives();

    @Query("UPDATE inventoryItems SET inventoryItemActive = 0 WHERE inventoryItemId = :inventoryItemId")
    public void passive(long inventoryItemId);
}

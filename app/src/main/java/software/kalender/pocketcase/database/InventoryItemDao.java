package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.models.InventoryItemModel;

@Dao
public interface InventoryItemDao {
    @Query("SELECT * FROM 'inventoryItems' WHERE inventoryItemId = :id")
    public InventoryItemModel get(int id);

    @Query("SELECT * FROM 'inventoryItems'")
    public List<InventoryItemModel> list();
}

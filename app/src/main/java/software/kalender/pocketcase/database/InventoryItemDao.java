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

    @Query("SELECT * FROM 'inventoryItems'")
    public List<InventoryItemModel> list();
}

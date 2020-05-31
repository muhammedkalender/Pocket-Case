package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.ItemModel;

@Dao
public interface ItemDao extends DaoInterface<ItemModel> {
    @Query("SELECT * FROM 'items' WHERE itemId = :id")
    public ItemModel get(long id);

    @Query("SELECT * FROM 'items'")
    public List<ItemModel> list();
}

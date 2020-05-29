package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.models.ItemModel;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM 'items' WHERE itemId = :id")
    public ItemModel get(int id);

    @Query("SELECT * FROM 'items'")
    public List<ItemModel> list();
}

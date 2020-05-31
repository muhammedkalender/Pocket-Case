package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.ItemTypeModel;

@Dao
public interface ItemTypeDao extends DaoInterface<ItemTypeModel> {
    @Query("SELECT * FROM 'itemTypes' WHERE itemTypeId = :id")
    public ItemTypeModel get(long id);

    @Query("SELECT * FROM 'itemTypes'")
    public List<ItemTypeModel> list();
}

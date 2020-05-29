package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.models.ItemSkinModel;

@Dao
public interface ItemSkinDao {
    @Query("SELECT * FROM 'itemSkins' WHERE itemSkinId = :id")
    public ItemSkinModel get(int id);

    @Query("SELECT * FROM 'itemSkins'")
    public List<ItemSkinModel> list();
}

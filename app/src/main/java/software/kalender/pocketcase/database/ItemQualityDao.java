package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.models.ItemQualityModel;

@Dao
public interface ItemQualityDao {
    @Query("SELECT * FROM 'itemqualities' WHERE itemQualityId = :id")
    public ItemQualityModel get(int id);

    @Query("SELECT * FROM 'itemqualities'")
    public List<ItemQualityModel> list();
}

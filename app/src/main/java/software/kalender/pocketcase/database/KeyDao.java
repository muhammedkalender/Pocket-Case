package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.models.KeyModel;

@Dao
public interface KeyDao {
    @Query("SELECT * FROM 'keys' WHERE keyId = :id")
    public KeyModel get(int id);

    @Query("SELECT * FROM 'keys'")
    public List<KeyModel> list();
}

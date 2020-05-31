package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.KeyModel;

@Dao
public interface KeyDao extends DaoInterface<KeyModel> {
    @Query("SELECT * FROM 'keys' WHERE keyId = :id")
    public KeyModel get(long id);

    @Query("SELECT * FROM 'keys'")
    public List<KeyModel> list();
}

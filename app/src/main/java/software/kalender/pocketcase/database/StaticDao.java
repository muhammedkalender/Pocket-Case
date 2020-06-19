package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import software.kalender.pocketcase.enums.StaticEnum;
import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.StaticModel;

@Dao
public interface StaticDao extends DaoInterface<StaticModel> {
    @Query("SELECT * FROM statics WHERE staticId = :staticId")
    public StaticModel get(long staticId);

    @Query("SELECT * FROM statics")
    public List<StaticModel> list();

    @Query("SELECT * FROM statics WHERE staticEnum = :staticEnum LIMIT 1")
    public StaticModel getFromEnum(StaticEnum staticEnum);
}

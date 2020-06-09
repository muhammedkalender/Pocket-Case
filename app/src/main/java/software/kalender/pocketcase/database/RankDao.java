package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.RankModel;

@Dao
public interface RankDao extends DaoInterface<RankModel> {
    @Query("SELECT * FROM ranks WHERE rankId = :id")
    public RankModel get(long id);

    @Query("SELECT * FROM ranks")
    public List<RankModel> list();

    @Query("SELECT * FROM ranks WHERE moneyToRank < :currentInventoryValue ORDER BY moneyToRank DESC")
    public RankModel currentRank(long currentInventoryValue);
}

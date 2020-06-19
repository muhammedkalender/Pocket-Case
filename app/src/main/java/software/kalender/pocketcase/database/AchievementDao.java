package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.enums.AchievementEnum;
import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.AchievementModel;
import software.kalender.pocketcase.models.ItemModel;

@Dao
public interface AchievementDao extends DaoInterface<AchievementModel> {
    @Query("SELECT * FROM achievements WHERE achievementId = :id")
    public AchievementModel get(long id);

    @Query("SELECT * FROM achievements")
    public List<AchievementModel> list();

    @Query("SELECT * FROM achievements WHERE achievementEnum = :achievementEnum")
    public AchievementModel getFromEnum(AchievementEnum achievementEnum);
}

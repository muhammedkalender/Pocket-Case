package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.AchievementModel;
import software.kalender.pocketcase.models.AchievementRequestModel;

@Dao
public interface AchievementRequestDao extends DaoInterface<AchievementRequestModel> {
    @Query("SELECT * FROM achievementRequests WHERE achievementRequestId = :id")
    public AchievementRequestModel get(long id);

    @Query("SELECT * FROM achievementRequests")
    public List<AchievementRequestModel> list();

    @Query("SELECT * FROM achievementRequests WHERE achievementId = :achievementId")
    public List<AchievementRequestModel> listFromAchievementId(Long achievementId);
}

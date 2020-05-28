package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import software.kalender.pocketcase.interfaces.IDao;
import software.kalender.pocketcase.models.CaseModel;

@Dao
public interface CaseDao extends IDao<CaseModel> {
    @Query("SELECT * FROM 'cases' WHERE caseId = :id")
    public CaseModel get(int id);

    @Query("SELECT * FROM 'cases'")
    public List<CaseModel> list();
}

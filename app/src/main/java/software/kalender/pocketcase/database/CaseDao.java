package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.CaseModel;

@Dao
public interface CaseDao extends DaoInterface<CaseModel> {
    @Query("SELECT * FROM 'cases' WHERE caseId = :id")
    public CaseModel get(long id);

    @Query("SELECT * FROM 'cases'")
    public List<CaseModel> list();
}

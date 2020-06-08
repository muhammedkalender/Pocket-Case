package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.enums.CaseTypeEnum;
import software.kalender.pocketcase.enums.ColorEnum;
import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.ItemSkinModel;

@Dao
public interface CaseDao extends DaoInterface<CaseModel> {
    @Query("SELECT * FROM cases WHERE caseId = :id")
    public CaseModel get(long id);

    @Query("SELECT * FROM cases")
    public List<CaseModel> list();

    @Query("SELECT * FROM cases WHERE caseType = :caseType")
    public List<CaseModel> listFromType(CaseTypeEnum caseType);

    @Query("SELECT * FROM itemSkins WHERE caseId = :caseId AND itemSkinColor = :colorEnum ORDER BY RANDOM() LIMIT 1")
    public ItemSkinModel getRandomItemFromColor(Long caseId, ColorEnum colorEnum);

    @Query("SELECT * FROM cases WHERE caseType = :caseType LIMIT 1")
    public CaseModel getLastCaseFromType(CaseTypeEnum caseType);
}

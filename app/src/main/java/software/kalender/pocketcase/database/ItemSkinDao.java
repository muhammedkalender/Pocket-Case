package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.ItemSkinModel;

@Dao
public interface ItemSkinDao extends DaoInterface<ItemSkinModel> {
    @Query("SELECT * FROM itemSkins WHERE itemSkinId = :id")
    public ItemSkinModel get(long id);

    @Query("SELECT * FROM itemSkins")
    public List<ItemSkinModel> list();

    @Query("SELECT * FROM itemskins WHERE caseId = :caseId ORDER BY itemSkinColor ASC")
    public List<ItemSkinModel> listFromCaseId(long caseId);
}

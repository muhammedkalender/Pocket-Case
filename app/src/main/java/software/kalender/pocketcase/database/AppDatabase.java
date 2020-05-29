package software.kalender.pocketcase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.ItemSkinModel;
import software.kalender.pocketcase.models.ItemTypeModel;
import software.kalender.pocketcase.models.KeyModel;

@Database(entities = {
        CaseModel.class,
        InventoryItemModel.class,
        ItemModel.class,
        ItemQualityModel.class,
        ItemSkinModel.class,
        ItemTypeModel.class,
        KeyModel.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CaseDao caseDao();
}

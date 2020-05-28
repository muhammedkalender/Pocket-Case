package software.kalender.pocketcase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import software.kalender.pocketcase.models.CaseModel;

@Database(entities = {
        CaseModel.class
//        InventoryItemModel.class,
//        ItemModel.class,
//        ItemQualityModel.class,
//        ItemSkinModel.class,
//        ItemTypeModel.class,
//        KeyModel.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CaseDao caseDao();
}

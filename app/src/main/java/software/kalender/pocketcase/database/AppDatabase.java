package software.kalender.pocketcase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import software.kalender.pocketcase.models.AchievementModel;
import software.kalender.pocketcase.models.AchievementRequestModel;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.ItemSkinModel;
import software.kalender.pocketcase.models.ItemTypeModel;
import software.kalender.pocketcase.models.KeyModel;
import software.kalender.pocketcase.models.RankModel;
import software.kalender.pocketcase.models.StaticModel;
import software.kalender.pocketcase.models.UserModel;

@Database(entities = {
        CaseModel.class,
        InventoryItemModel.class,
        ItemModel.class,
        ItemQualityModel.class,
        ItemSkinModel.class,
        ItemTypeModel.class,
        KeyModel.class,
        UserModel.class,
        RankModel.class,
        StaticModel.class,
        AchievementModel.class,
        AchievementRequestModel.class,
}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract CaseDao caseDao();

    public abstract InventoryItemDao inventoryItemDao();

    public abstract ItemDao itemDao();

    public abstract ItemQualityDao itemQualityDao();

    public abstract ItemSkinDao itemSkinDao();

    public abstract ItemTypeDao itemTypeDao();

    public abstract KeyDao keyDao();

    public abstract UserDao userDao();

    public abstract RankDao rankDao();

    public abstract StaticDao staticDao();

    public abstract AchievementDao achievementDao();

    public abstract AchievementRequestDao achievementRequestDao();
}

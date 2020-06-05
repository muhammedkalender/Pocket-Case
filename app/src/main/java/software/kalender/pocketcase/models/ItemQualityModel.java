package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.helpers.MoneyHelper;

@Entity(tableName = "itemQualities")
public class ItemQualityModel {
    @ColumnInfo(name = "itemQualityId")
    @PrimaryKey(autoGenerate = true)
    public long itemQualityId;

    @NonNull
    @ColumnInfo(name = "itemQualityName")
    public String quality;

    @NonNull
    @ColumnInfo(name = "itemQualityPrice")
    public MoneyHelper price;

    @ColumnInfo(name = "itemQualityStatTrak")
    public boolean statTrak = false;

    @NonNull
    @Embedded
    public ItemSkinModel skin;

    @Ignore
    public ItemQualityModel insert() {
        this.itemQualityId = Singleton.db.itemQualityDao().insert(this);

        return this;
    }
}

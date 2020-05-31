package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;

@Entity(tableName = "itemQualities")
public class ItemQualityModel {
    @ColumnInfo(name = "itemQualityId")
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    @ColumnInfo(name = "itemQualityName")
    public String quality;

    @NonNull
    @ColumnInfo(name = "itemQualityPrice")
    public float price; //TODO

    @ColumnInfo(name = "itemQualityStatTrak")
    public boolean statTrak = false;

    @NonNull
    @Embedded
    public ItemSkinModel skin;

    @Ignore
    public ItemQualityModel insert() {
        this.id = Singleton.db.itemQualityDao().insert(this);

        return this;
    }
}

package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "itemQualities")
public class ItemQualityModel {
    @ColumnInfo(name = "itemQualityId")
    @PrimaryKey(autoGenerate = true)
    public int id;

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
    @ColumnInfo(name = "itemQualityItemSkin")
    public ItemSkinModel skin;
}

package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "inventoryItem")
public class InventoryItemModel {
    @ColumnInfo(name = "inventoryItemId")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "inventoryItemQuality")
    public ItemQualityModel quality;

    @ColumnInfo(name = "inventoryItemActive")
    public boolean active = true;

    @NonNull
    @ColumnInfo(name = "inventoryItemInsertedAt")
    public Date insertedAt = new Date(System.currentTimeMillis());

    @NonNull
    @ColumnInfo(name = "inventoryItemUpdatedAt")
    public Date updatedAt = new Date(System.currentTimeMillis());
}

package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

import software.kalender.pocketcase.Singleton;

@Entity(tableName = "inventoryItems")
public class InventoryItemModel {
    @ColumnInfo(name = "inventoryItemId")
    @PrimaryKey(autoGenerate = true)
    public long id;

    @Embedded
    public ItemQualityModel quality;

    @ColumnInfo(name = "inventoryItemActive")
    public boolean active = true;

    @ColumnInfo(name = "inventoryItemInsertedAt")
    public Date insertedAt = new Date(System.currentTimeMillis());

    @ColumnInfo(name = "inventoryItemUpdatedAt")
    public Date updatedAt = new Date(System.currentTimeMillis());

    @Ignore
    public InventoryItemModel insert() {
        this.id = Singleton.db.inventoryItemDao().insert(this);

        return this;
    }
}

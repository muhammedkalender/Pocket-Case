package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;

@Entity(tableName = "items")
public class ItemModel {
    @ColumnInfo(name = "itemId")
    @PrimaryKey(autoGenerate = true)
    public long itemId;

    @NonNull
    @ColumnInfo(name = "itemName")
    public String name;

    @Embedded
    public ItemTypeModel type;

    @Ignore
    public ItemModel insert() {
        this.itemId = Singleton.db.itemDao().insert(this);

        return this;
    }
}

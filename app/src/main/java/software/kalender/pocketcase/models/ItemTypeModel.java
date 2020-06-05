package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;

@Entity(tableName = "itemTypes")
public class ItemTypeModel {
    @ColumnInfo(name = "itemTypeId")
    @PrimaryKey(autoGenerate = true)
    public long itemTypeId;

    @NonNull
    @ColumnInfo(name = "itemTypeName")
    public String name;

    @Ignore
    public ItemTypeModel insert() {
        this.itemTypeId = Singleton.db.itemTypeDao().insert(this);

        return this;
    }
}

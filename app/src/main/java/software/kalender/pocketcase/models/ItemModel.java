package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "items")
public class ItemModel {
    @ColumnInfo(name = "itemId")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "itemName")
    public String name;

    @NonNull
    @ColumnInfo(name = "itemType")
    public ItemTypeModel type;
}

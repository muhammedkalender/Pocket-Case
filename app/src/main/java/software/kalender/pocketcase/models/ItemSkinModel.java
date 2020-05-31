package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.enums.ColorEnum;

@Entity(tableName = "itemSkins")
public class ItemSkinModel {
    @ColumnInfo(name = "itemSkinId")
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    @ColumnInfo(name = "itemSkinName")
    public String name;

    @NonNull
    @Embedded
    public ItemModel item;

    @NonNull
    @ColumnInfo(name = "itemSkinColor")
    public ColorEnum color;

    @NonNull
    @Embedded
    public CaseModel skinCase;

    @Ignore
    public ItemSkinModel insert() {
        this.id = Singleton.db.itemSkinDao().insert(this);

        return this;
    }
}

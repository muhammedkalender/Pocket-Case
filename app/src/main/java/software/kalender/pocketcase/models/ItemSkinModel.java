package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.enums.ColorEnum;

@Entity(tableName = "itemSkin")
public class ItemSkinModel {
    @ColumnInfo(name = "itemSkinId")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "itemSkinName")
    public String name;

    @NonNull
    @Embedded
    @ColumnInfo(name = "itemSkinItem")
    public ItemModel item;

    @NonNull
    @Embedded
    @ColumnInfo(name = "itemSkinColor")
    public ColorEnum color;

    @NonNull
    @Embedded
    public CaseModel skinCase;
}

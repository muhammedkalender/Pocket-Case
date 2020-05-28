package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "keys")
public class KeyModel {
    @ColumnInfo(name = "keyId")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "keyName")
    public String name;

    //TODO
    @ColumnInfo(name = "keyPrice")
    public float price;

}

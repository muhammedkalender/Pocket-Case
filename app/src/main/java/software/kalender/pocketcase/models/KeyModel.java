package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;

@Entity(tableName = "keys")
public class KeyModel {
    @ColumnInfo(name = "keyId")
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "keyName")
    public String name;

    //TODO
    @ColumnInfo(name = "keyPrice")
    public float price;

    @Ignore
    public KeyModel insert() {
        this.id = Singleton.db.keyDao().insert(this);

        return this;
    }
}

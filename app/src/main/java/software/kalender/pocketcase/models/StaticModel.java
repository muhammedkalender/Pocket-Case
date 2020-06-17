package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;

@Entity(tableName = "statics")
public class StaticModel {
    @ColumnInfo(name = "staticId")
    @PrimaryKey(autoGenerate = true)
    public Long staticId;

    @ColumnInfo(name = "staticKey")
    public String staticKey;

    @ColumnInfo(name = "staticValue")
    public Long staticValue;

    @Ignore
    public StaticModel update(){
        Singleton.db.staticDao().update(this);

        return this;
    }

    @Ignore
    public StaticModel increment(long value){
        this.staticValue += value;

        return this.update();
    }

    @Ignore
    public StaticModel decrement(long value){
        this.staticValue -= value;

        return this.update();
    }
}

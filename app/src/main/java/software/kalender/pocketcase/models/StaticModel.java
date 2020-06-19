package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.enums.StaticEnum;

@Entity(tableName = "statics")
public class StaticModel {
    @ColumnInfo(name = "staticId")
    @PrimaryKey(autoGenerate = true)
    public long staticId;

    @ColumnInfo(name = "staticEnum")
    public StaticEnum staticEnum;

    @ColumnInfo(name = "staticValue")
    public long staticValue = 0L;

    @Ignore
    public StaticModel insert() {
        this.staticId = Singleton.db.staticDao().insert(this);

        return this;
    }

    @Ignore
    public StaticModel update(){
        Singleton.db.staticDao().update(this);

        return this;
    }

    @Ignore
    public StaticModel increment(long value){
        //TODO Bİitip bitmediğine bak
        this.staticValue += value;

        return this.update();
    }

    @Ignore
    public StaticModel decrement(long value){
        //TODO Bİitip bitmediğine bak
        this.staticValue -= value;

        return this.update();
    }

    @Ignore
    public StaticModel max(long value){
        //TODO Bİitip bitmediğine bak
        if(value > this.staticValue){
            this.staticValue = value;

            return this.update();
        }

        return this;
    }

    @Ignore
    public StaticModel min(long value){
        //TODO Bİitip bitmediğine bak
        if(value < this.staticValue){
            this.staticValue = value;

            return this.update();
        }

        return this;
    }
}

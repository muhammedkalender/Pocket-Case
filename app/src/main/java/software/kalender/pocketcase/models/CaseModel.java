package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;

@Entity(tableName = "cases")
public class CaseModel {
    @ColumnInfo(name = "caseId")
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    @ColumnInfo(name = "caseName")
    public String name;

    //TODO
    @ColumnInfo(name = "casePrice")
    public float price;

    @ColumnInfo(name = "caseKey")
    public KeyModel caseKey;

    @Ignore
    public CaseModel insert() {
        this.id = Singleton.db.caseDao().insert(this);

        return this;
    }
}

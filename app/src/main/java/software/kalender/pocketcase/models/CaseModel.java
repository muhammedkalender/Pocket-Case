package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cases")
public class CaseModel {
    @ColumnInfo(name = "caseId")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "caseName")
    public String name;

    //TODO
    @ColumnInfo(name = "casePrice")
    public float price;

    @Embedded
    public KeyModel caseKey;
}

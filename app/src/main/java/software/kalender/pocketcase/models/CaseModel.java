package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.enums.CaseTypeEnum;
import software.kalender.pocketcase.helpers.MoneyHelper;

@Entity(tableName = "cases")
public class CaseModel {
    @ColumnInfo(name = "caseId")
    @PrimaryKey(autoGenerate = true)
    public long caseId;

    @NonNull
    @ColumnInfo(name = "caseName")
    public String name;

    @ColumnInfo(name = "casePrice")
    public MoneyHelper price;

    @ColumnInfo(name = "caseKey")
    public KeyModel caseKey;

    @NonNull
    @ColumnInfo(name = "caseChance")
    public CaseChanceModel caseChance;

    @NonNull
    @ColumnInfo(name = "caseType")
    public CaseTypeEnum caseType;

    @Ignore
    public CaseModel insert() {
        this.caseId = Singleton.db.caseDao().insert(this);

        return this;
    }
}

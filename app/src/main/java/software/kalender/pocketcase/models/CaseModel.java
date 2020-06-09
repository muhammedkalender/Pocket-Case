package software.kalender.pocketcase.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.enums.CaseSpecialEnum;
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

    @ColumnInfo(name = "caseSpecial")
    public CaseSpecialEnum caseSpecial;

    @Nullable
    @ColumnInfo(name = "caseSpecialName")
    public String caseSpecialName;

    @Nullable
    @ColumnInfo(name = "caseSpecialImagePath")
    public String caseSpecialImagePath;

    @Ignore
    public CaseModel insert() {
        this.caseId = Singleton.db.caseDao().insert(this);

        return this;
    }

    @Ignore
    public String getTotalPriceWithSymbol() {
        if (caseKey != null) {
            return price.sum(caseKey.price.getBalance()).getFormattedText();
        }

        return price.getFormattedText();
    }
}

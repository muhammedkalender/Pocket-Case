package software.kalender.pocketcase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import software.kalender.pocketcase.Singleton;

/*
    Rank calculated from total inventory value
    Every login check inventory value and calculate dynamically
    This Nodel var ranks, ranks can be added dynamically
 */
@Entity(tableName = "ranks")
public class RankModel {
    @ColumnInfo(name = "rankId")
    @PrimaryKey(autoGenerate = true)
    public long rankId;

    @ColumnInfo(name = "rankName")
    public String rankName;

    @ColumnInfo(name = "rankIcon")
    public String rankIcon; //TODO

    @ColumnInfo(name = "moneyToRank")
    public long moneyToRank;

    @ColumnInfo(name = "moneyToRankUp")
    public long moneyToRankUp;

    @ColumnInfo(name = "rankOpened")
    public boolean isRankOpened = false;

    @Ignore
    public RankModel insert() {
        this.rankId = Singleton.db.rankDao().insert(this);

        return this;
    }
}

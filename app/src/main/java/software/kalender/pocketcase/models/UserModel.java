package software.kalender.pocketcase.models;

import android.widget.TextView;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.HashMap;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.constants.GameConstant;
import software.kalender.pocketcase.enums.CurrencyEnum;
import software.kalender.pocketcase.helpers.MoneyHelper;
import software.kalender.pocketcase.helpers.RankHelper;
import software.kalender.pocketcase.helpers.XPHelper;

@Entity(tableName = "users")
public class UserModel {
    @ColumnInfo(name = "userId")
    @PrimaryKey(autoGenerate = true)
    public long userId;

    @ColumnInfo(name = "userName")
    public String userName;

    @ColumnInfo(name = "userProfileImagePath")
    public String userProfileImagePath;

    @ColumnInfo(name = "userBalance")
    public MoneyHelper userBalance;

    @ColumnInfo(name = "userInventoryValue")
    public MoneyHelper inventoryValue = new MoneyHelper(CurrencyEnum.USD, 0L);

    @Embedded
    public RankHelper userRank = new RankHelper();

    @Embedded
    public XPHelper userXP = new XPHelper();

    @Ignore
    public UserModel insert() {
        this.userId = Singleton.db.userDao().insert(this);

        return this;
    }

    //TODO Verimlilik tartışılır
    @Ignore
    public UserModel update(){
        Singleton.db.userDao().update(this);

        return this;
    }

    @Ignore
    public UserModel addBalance(MoneyHelper moneyHelper){
        return addBalance(moneyHelper.getBalance());
    }

    @Ignore
    public UserModel addBalance(long amount){
        userBalance.sum(amount);
        this.update();

        return this;
    }

    @Ignore
    public UserModel delBalance(long amount){
        userBalance.minus(amount);
        this.update();

        return this;
    }

    @Ignore
    public UserModel delBalance(MoneyHelper moneyHelper){
        return delBalance(moneyHelper.getBalance());
    }
}

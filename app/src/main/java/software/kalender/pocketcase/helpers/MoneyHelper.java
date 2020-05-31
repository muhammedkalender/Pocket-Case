package software.kalender.pocketcase.helpers;

import software.kalender.pocketcase.enums.CurrencyEnum;

/*
    This class integrated with CurrencyEnum ( Formatter functions )

    Don't user cross currencies like ( usd - eur )
    Exchange functions will be added in future
    TODO Exchange - Currency Convert / Rates

    Etc : USD 0.10 [SUM] EUR 0.15
    This returns 0.25 but its not correct or
          USD 0.10 [SUM] RUB 0.15
    Also this returns 0.25

    Always use integers

    Etc :   0.00 X - 0 √
            0.59 X - 59 √
            2.29 X - 229 √
 */
public class MoneyHelper {
    private CurrencyEnum currency = CurrencyEnum.USD;
    private Long balance = 0L;

    public MoneyHelper(){

    }

    public MoneyHelper(CurrencyEnum currency, Long balance) {
        this.currency = currency;
        this.balance = balance;
    }

    public static MoneyHelper make(CurrencyEnum currency, Long balance) {
        return new MoneyHelper(currency, balance);
    }

    public MoneyHelper sum(Long amount) {
        balance += amount;

        return this;
    }

    public MoneyHelper minus(Long amount) {
        balance -= amount;

        return this;
    }

    //region Calculator functions, Makes new class, you must protect default class if you need

    public MoneyHelper calcMultiplier(Float multiplier) {
        if (balance == 0L && multiplier == 0f) {
            return this;
        }

        balance = (long) (int) (balance * multiplier);

        return this;
    }

    //endregion

    //region Formatter functions, Returns various variable types TODO

    //endregion


    public Long getBalance() {
        return balance;
    }

    public MoneyHelper setBalance(Long balance) {
        this.balance = balance;

        return this;
    }

    public CurrencyEnum getCurrency() {
        return this.currency;
    }

    public MoneyHelper setCurrency(CurrencyEnum currency) {
        this.currency = currency;

        return this;
    }
}

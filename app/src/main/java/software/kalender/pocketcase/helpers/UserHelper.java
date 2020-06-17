package software.kalender.pocketcase.helpers;

import android.widget.TextView;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.models.UserModel;

public class UserHelper {
    private TextView headerTextView;

    public UserModel minusBalance(MoneyHelper moneyHelper) {
        return minusBalance(moneyHelper.getBalance());
    }

    public UserModel minusBalance(long amount) {
        Singleton.user.delBalance(amount);

        updateBalance();

        return Singleton.user;
    }

    public UserModel sumBalance(MoneyHelper moneyHelper) {
        return sumBalance(moneyHelper.getBalance());
    }

    public UserModel sumBalance(long amount) {
        Singleton.user.addBalance(amount);

        updateBalance();

        return Singleton.user;
    }

    public void updateBalance() {
        if (headerTextView != null) {
            headerTextView.setText(Singleton.user.userBalance.getFormattedText());
        }
    }

    public TextView getHeaderTextView() {
        return headerTextView;
    }

    public void setHeaderTextView(TextView headerTextView) {
        this.headerTextView = headerTextView;

        updateBalance();
    }
}

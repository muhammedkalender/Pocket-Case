package software.kalender.pocketcase.helpers;

import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;

import software.kalender.pocketcase.Singleton;

public class ViewHelper {
    //region Disable & Enable Buttons

    public void makeEnable(View view) {
        if (view == null) {
            return;
        }

        view.setClickable(true);
        view.setFocusable(true);
        view.setAlpha(0.7f);
    }

    public void makeEnable(View view, String text) {
        if (view == null) {
            return;
        }

        makeEnable(view);

        ((Button) view).setText(text);
    }

    public void makeEnable(View view, int resId) {
        if (view == null) {
            return;
        }

        makeEnable(view, Singleton.resource.getString(resId));
    }

    public void makeDisable(View view) {
        if (view == null) {
            return;
        }

        view.setClickable(false);
        view.setFocusable(false);
        view.setAlpha(0.8f);
    }

    public void makeDisable(View view, String text) {
        if (view == null) {
            return;
        }

        makeDisable(view);

        ((Button) view).setText(text);
    }

    public void makeDisable(View view, int resId) {
        if (view == null) {
            return;
        }

        makeDisable(view, Singleton.resource.getString(resId));
    }

    //endregion
}

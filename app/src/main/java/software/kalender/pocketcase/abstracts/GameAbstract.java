package software.kalender.pocketcase.abstracts;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.constants.GameConstant;
import software.kalender.pocketcase.interfaces.GameInterface;

public abstract class GameAbstract implements GameInterface {
    protected Context context;
    protected View view;

    public GameAbstract(@NonNull Context context) {
        this.context = context;
    }

    public View getView() {
        if(view != null){
            return view;
        }

        view = this.generateView();

        return view;
    }
}

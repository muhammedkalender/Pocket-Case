package software.kalender.pocketcase.abstracts;

import android.content.Context;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.constants.GameConstant;

public abstract class GameAbstract{
    private Context context;

    public GameAbstract(@NonNull Context context) {
        this.context = context;
    }
}

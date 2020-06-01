package software.kalender.pocketcase;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.database.AppDatabase;
import software.kalender.pocketcase.helpers.LogHelper;

public class Singleton {
    @NonNull
    public static AppDatabase db;

    public static LogHelper log;
}

package software.kalender.pocketcase;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.database.AppDatabase;
import software.kalender.pocketcase.helpers.ConfigHelper;
import software.kalender.pocketcase.helpers.LogHelper;
import software.kalender.pocketcase.helpers.ResourceHelper;

public class Singleton {
    @NonNull
    public static AppDatabase db;

    public static LogHelper log;
    public static ResourceHelper resource;
    public static ConfigHelper configHelper;
}

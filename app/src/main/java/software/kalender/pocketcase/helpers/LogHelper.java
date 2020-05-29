package software.kalender.pocketcase.helpers;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import software.kalender.pocketcase.codes.ErrorCode;
import software.kalender.pocketcase.codes.InfoCode;

public class LogHelper {
    public void error(@NonNull ErrorCode errorCode, @Nullable Exception exception) {
        error(errorCode, null, exception);
    }

    public void error(@NonNull ErrorCode errorCode, @Nullable String message, @Nullable Exception exception) {
        //TODO

        String _message = "NOPE";

        if (message != null && exception != null) {
            _message = String.format("%1$s\n%2$s", message, exception.getMessage());
        } else if (exception != null && exception.getMessage() != null) {
            _message = exception.getMessage();
        }

        Log.e(String.format("ERR_%1$d", errorCode.ordinal()), _message);
    }

    public void info(@NonNull InfoCode infoCode, @NonNull String message) {
        //TODO

        Log.e(String.format("INFO_%1$d", infoCode.ordinal()), message);
    }
}

package software.kalender.pocketcase.helpers;

import android.util.Log;

import androidx.annotation.Nullable;

public class LogHelper {
    public void error(int errorCode, @Nullable Exception exception) {
        error(errorCode, null, exception);
    }

    public void error(int errorCode, @Nullable String message, @Nullable Exception exception) {
        //TODO

        String _message = "NOPE";

        if (message != null && exception != null) {
            _message = String.format("%1$s\n%2$s", message, exception.getMessage());
        } else if (exception != null) {
            _message = exception.getMessage();
        }

        Log.e(String.format("ERR_%1$d", errorCode), _message);
    }
}

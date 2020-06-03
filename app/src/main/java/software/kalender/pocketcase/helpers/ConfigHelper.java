package software.kalender.pocketcase.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.codes.ErrorCode;
import software.kalender.pocketcase.constants.AppConstant;

public class ConfigHelper {
    //region Local variables

    private Context context;

    //endregion

    //region Constructors

    public ConfigHelper(Context context) {
        this.context = context;
    }

    //endregion

    //region Integer

    public int getInteger(String key) {
        return getInteger(key, AppConstant.defaultInteger);
    }

    public int getInteger(String key, int def) {
        try {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(key, Context.MODE_PRIVATE);

            return sharedPreferences.getInt(key, def);
        } catch (Exception e) {
            Singleton.log.error(ErrorCode.CONFIG_GET_INTEGER, e);

            return def;
        }
    }

    public boolean setInteger(String key, int val) {
        try {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(key, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putInt(key, val);

            return editor.commit();
        } catch (Exception e) {
            Singleton.log.error(ErrorCode.CONFIG_SET_INTEGER, e);

            return false;
        }
    }

    //endregion

    //region String

    public String getString(String key) {
        return getString(key, AppConstant.defaultString);
    }

    public String getString(String key, String def) {
        try {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(key, Context.MODE_PRIVATE);

            return sharedPreferences.getString(key, def);
        } catch (Exception e) {
            Singleton.log.error(ErrorCode.CONFIG_GET_STRING, e);

            return def;
        }
    }

    public boolean setString(String key, String val) {
        try {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(key, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(key, val);

            return editor.commit();
        } catch (Exception e) {
            Singleton.log.error(ErrorCode.CONFIG_SET_STRING, e);

            return false;
        }
    }

    //endregion

    //region String

    public Float getFloat(String key) {
        return getFloat(key, AppConstant.defaultFloat);
    }

    public Float getFloat(String key, Float def) {
        try {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(key, Context.MODE_PRIVATE);

            return sharedPreferences.getFloat(key, def);
        } catch (Exception e) {
            Singleton.log.error(ErrorCode.CONFIG_GET_FLOAT, e);

            return def;
        }
    }

    public boolean setFloat(String key, Float val) {
        try {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(key, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putFloat(key, val);

            return editor.commit();
        } catch (Exception e) {
            Singleton.log.error(ErrorCode.CONFIG_SET_FLOAT, e);

            return false;
        }
    }

    //endregion
}

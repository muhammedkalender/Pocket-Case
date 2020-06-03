package software.kalender.pocketcase.helpers;

import android.content.Context;
import android.util.Log;

import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.codes.ErrorCode;
import software.kalender.pocketcase.constants.AppConstant;

public class ResourceHelper {
    private Context context;

    public ResourceHelper(Context context) {
        this.context = context;
    }

    public String getString(int resId, String... args){
        try{
            Log.e("asda", "geldi" + resId);
            Log.e("örn", context.getString(resId));
            return context.getString(resId, (Object[]) args);
        }catch (Exception e){
            Singleton.log.error(ErrorCode.RESOURCE_GET_STRING, e);

            return AppConstant.defaultString;
        }
    }
}

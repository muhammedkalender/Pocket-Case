package software.kalender.pocketcase.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
            return context.getString(resId, (Object[]) args);
        }catch (Exception e){
            Singleton.log.error(ErrorCode.RESOURCE_GET_STRING, e);

            return AppConstant.defaultString;
        }
    }

    public Drawable getDrawable(int resId){
        try{
            return context.getDrawable(resId);
        }catch (Exception e){
            //TODO
            Singleton.log.error(ErrorCode.RESOURCE_GET_DRAWABLE, e);

            return null;
        }
    }

    public int getColor(int resId){
        try{
            return context.getColor(resId);
        }catch (Exception e){
            Singleton.log.error(ErrorCode.RESOURCE_GET_COLOR, e);

            return AppConstant.defaultColor;
        }
    }
}

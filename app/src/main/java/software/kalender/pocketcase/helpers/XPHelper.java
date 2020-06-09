package software.kalender.pocketcase.helpers;

import android.util.Log;

import androidx.room.Ignore;

public class XPHelper {
    @Ignore
    private long xp = 0;

    @Ignore
    private int level = 0;


    public XPHelper(){

    }

    public XPHelper(long xp){
        this.xp = xp;

        if(xp > 1000){
           level = (int) ((xp - 1000) / 5000);
        }else if(xp == 1000){
            level = 1;
        }
    }

    @Ignore
    public long getXP() {
        return xp;
    }

    @Ignore
    public void setXP(long xp) {
        this.xp = xp;
    }

    @Ignore
    public boolean addXP(long xp){
        this.xp += xp;

        int _level = 0;

        if(this.xp > 1000){
            _level = (int) ((this.xp - 1000) / 5000);
        }else if(this.xp == 1000){
            _level = 1;
        }

        if(_level > level){
            //TODO LEVEL UP

            Log.e("adas", "Level Up");

            return true;
        }

        return false;
    }
}

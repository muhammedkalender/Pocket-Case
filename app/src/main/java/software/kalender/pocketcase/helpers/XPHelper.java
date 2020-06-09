package software.kalender.pocketcase.helpers;

import android.util.Log;

public class XPHelper {
    private long xp = 0;
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

    public long getXP() {
        return xp;
    }

    public void setXP(long xp) {
        this.xp = xp;
    }

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

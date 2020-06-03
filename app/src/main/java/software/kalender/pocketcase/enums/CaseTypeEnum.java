package software.kalender.pocketcase.enums;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;

public enum CaseTypeEnum {
    WEAPON_CASE{
        @Override
        public int getNameResource() {
            return R.string.case_type_weapon;
        }
    },
    NULL_CASE {
        @Override
        public int getNameResource() {
            return R.string.example;
        }
    };

    public abstract int getNameResource();

    public String getName(){
        return Singleton.resource.getString(getNameResource());
    }
}

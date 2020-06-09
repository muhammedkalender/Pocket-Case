package software.kalender.pocketcase.enums;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;

public enum ItemQualityEnum {
    FACTORY_NEW{
        @Override
        public boolean isStattrak() {
            return false;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_factory_new);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    MINIMAL_WEAR{
        @Override
        public boolean isStattrak() {
            return false;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_minimal_wear);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    FIELD_TESTED{
        @Override
        public boolean isStattrak() {
            return false;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_field_tested);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    WELL_WORN{
        @Override
        public boolean isStattrak() {
            return false;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_well_worn);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    BATTLE_SCARRED{
        @Override
        public boolean isStattrak() {
            return false;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_battle_scarred);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    STATTRAK_FACTORY_NEW{
        @Override
        public boolean isStattrak() {
            return true;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_stattrak_factory_new);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    STATTRAK_MINIMAL_WEAR{
        @Override
        public boolean isStattrak() {
            return true;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_stattrak_minimal_wear);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    STATTRAK_FIELD_TESTED{
        @Override
        public boolean isStattrak() {
            return true;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_stattrak_field_tested);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    STATTRAK_WELL_WORN{
        @Override
        public boolean isStattrak() {
            return true;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_stattrak_well_worn);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    },
    STATTRAK_BATTLE_SCARRED{
        @Override
        public boolean isStattrak() {
            return true;
        }

        @Override
        public String getName() {
            return Singleton.resource.getString(R.string.quality_stattrak_battle_scarred);
        }

        @Override
        public int getChance() {
            return 1000; //TODO
        }
    };

    abstract public boolean isStattrak();
    abstract public String getName();
    abstract public int getChance();
}

package software.kalender.pocketcase.enums;

import android.graphics.Color;

/*
    Chance percent in 10.000
    Default chances start from Rare ( Blue )
 */
public enum ColorEnum {
    COMMON {
        @Override
        public int color() {
            return Color.parseColor("#C1B4AF");

        }
    }, UNCOMMON {
        @Override
        public int color() {
            return Color.parseColor("#8C96E1");

        }
    }, RARE {
        @Override
        public int color() {
            return Color.parseColor("#4b69cd");
        }

        @Override
        public int chance(){
            return 5000;
        }
    },
    MYTHICAL {
        @Override
        public int color() {
            return Color.parseColor("#8847ff");
        }

        @Override
        public int chance() {
            return 4000; //todo
        }
    },
    LEGENDARY {
        @Override
        public int color() {
            return Color.parseColor("#d32ce6");
        }

        @Override
        public int chance() {
            return 850; //TODO
        }
    },
    ANCIENT {
        @Override
        public int color() {
            return Color.parseColor("#eb4b4b");
        }

        @Override
        public int chance() {
            return 100; //TODO
        }
    },
    UNIQUE {
        @Override
        public int color() {
            return Color.parseColor("#caab05");
        }

        @Override
        public int chance() {
            return 50; //TODO
        }
    };

    abstract public int color();

    public int chance() {
        return 0;
    }

    ColorEnum() {
    }
}

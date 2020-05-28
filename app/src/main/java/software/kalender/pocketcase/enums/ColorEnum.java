package software.kalender.pocketcase.enums;

import android.graphics.Color;

public enum ColorEnum {
    COMMON {
        @Override
        int color() {
            return Color.parseColor("#C1B4AF");

        }
    }, UNCOMMON {
        @Override
        int color() {
            return Color.parseColor("#8C96E1");

        }
    }, RARE {
        @Override
        int color() {
            return Color.parseColor("#4b69cd");
        }
    },
    MYTHICAL {
        @Override
        int color() {
            return Color.parseColor("#8847ff");
        }
    },
    LEGENDARY {
        @Override
        int color() {
            return Color.parseColor("#d32ce6");
        }
    },
    ANCIENT {
        @Override
        int color() {
            return Color.parseColor("#eb4b4b");
        }
    },
    UNIQUE {
        @Override
        int color() {
            return Color.parseColor("#caab05");
        }
    };


    abstract int color();
}

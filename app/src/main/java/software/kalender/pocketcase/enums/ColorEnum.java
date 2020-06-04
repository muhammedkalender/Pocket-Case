package software.kalender.pocketcase.enums;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;

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

        @Override
        public int drawableId() {
            return R.drawable.common;
        }

        @Override
        public Drawable drawable() {
            return Singleton.resource.getDrawable(R.drawable.common);
        }
    }, UNCOMMON {
        @Override
        public int color() {
            return Color.parseColor("#8C96E1");

        }

        @Override
        public int drawableId() {
            return R.drawable.uncommon;
        }

        @Override
        public Drawable drawable() {
            return Singleton.resource.getDrawable(R.drawable.uncommon);
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

        @Override
        public int drawableId() {
            return R.drawable.rare;
        }

        @Override
        public Drawable drawable() {
            return Singleton.resource.getDrawable(R.drawable.rare);
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

        @Override
        public int drawableId() {
            return R.drawable.mythical;
        }

        @Override
        public Drawable drawable() {
            return Singleton.resource.getDrawable(R.drawable.mythical);
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

        @Override
        public int drawableId() {
            return R.drawable.legendary;
        }

        @Override
        public Drawable drawable() {
            return Singleton.resource.getDrawable(R.drawable.legendary);
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

        @Override
        public int drawableId() {
            return R.drawable.ancient;
        }

        @Override
        public Drawable drawable() {
            return Singleton.resource.getDrawable(R.drawable.ancient);
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

        @Override
        public int drawableId() {
            return R.drawable.unique;
        }

        @Override
        public Drawable drawable() {
            return Singleton.resource.getDrawable(R.drawable.unique);
        }
    };

    abstract public int color();

    public int chance() {
        return 0;
    }

    abstract public int drawableId();

    abstract public Drawable drawable();

    ColorEnum() {
    }
}

package software.kalender.pocketcase.enums;

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
            return Singleton.resource.getColor(R.color.colorCommon);
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
            return Singleton.resource.getColor(R.color.colorUncommon);
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
            return Singleton.resource.getColor(R.color.colorRare);
        }

        @Override
        public int chance() {
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
            return Singleton.resource.getColor(R.color.colorMythical);
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
            return Singleton.resource.getColor(R.color.colorLegendary);
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
            return Singleton.resource.getColor(R.color.colorAncient);
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
            return Singleton.resource.getColor(R.color.colorUnique);
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

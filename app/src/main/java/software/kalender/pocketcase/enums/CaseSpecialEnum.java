package software.kalender.pocketcase.enums;

public enum CaseSpecialEnum {
    KNIFE{
        @Override
        String getImage() {
            //TODO

            return "";
        }
    },
    GLOVE {
        @Override
        String getImage() {
            //TODO

            return "";
        }
    };

    abstract String getImage();

    //TODO
}

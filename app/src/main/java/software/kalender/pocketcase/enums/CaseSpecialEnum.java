package software.kalender.pocketcase.enums;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.constants.AppConstant;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.ItemModel;
import software.kalender.pocketcase.models.ItemSkinModel;

public enum CaseSpecialEnum {
    KNIFE {
        @Override
        public String getImage() {
            //TODO

            return "";
        }

        @Override
        public ItemSkinModel toItemSkinModel(CaseModel caseModel) {
            ItemModel itemModel = new ItemModel();
            itemModel.name = "";//TODO

            ItemSkinModel itemSkinModel = new ItemSkinModel();
            itemSkinModel.item = itemModel;
            itemSkinModel.color = ColorEnum.UNIQUE;
            itemSkinModel.itemSkinId = AppConstant.defaultInteger;
            itemSkinModel.skinCase = caseModel;
            itemSkinModel.name = caseModel.caseSpecialName != null ? caseModel.caseSpecialName : Singleton.resource.getString(R.string.case_special_default);
            itemSkinModel.itemSkinImagePath = caseModel.caseSpecialImagePath != null ? caseModel.caseSpecialImagePath : getImage();

            return itemSkinModel;
        }
    },
    GLOVE {
        @Override
        public String getImage() {
            //TODO

            return "";
        }

        @Override
        public ItemSkinModel toItemSkinModel(CaseModel caseModel) {
            ItemModel itemModel = new ItemModel();
            itemModel.name = ""; //TODO

            ItemSkinModel itemSkinModel = new ItemSkinModel();
            itemSkinModel.item = itemModel;
            itemSkinModel.color = ColorEnum.ANCIENT; //TODO
            itemSkinModel.itemSkinId = AppConstant.defaultInteger;
            itemSkinModel.skinCase = caseModel;
            itemSkinModel.name = caseModel.caseSpecialName != null ? caseModel.caseSpecialName : Singleton.resource.getString(R.string.case_special_default);
            itemSkinModel.itemSkinImagePath = caseModel.caseSpecialImagePath != null ? caseModel.caseSpecialImagePath : getImage();

            return itemSkinModel;
        }
    };

    abstract public String getImage();

    abstract public ItemSkinModel toItemSkinModel(CaseModel caseModel);

    //TODO
}

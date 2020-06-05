package software.kalender.pocketcase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

import software.kalender.pocketcase.components.CaseSelectingComponent;
import software.kalender.pocketcase.database.AppDatabase;
import software.kalender.pocketcase.enums.CaseTypeEnum;
import software.kalender.pocketcase.enums.ColorEnum;
import software.kalender.pocketcase.enums.CurrencyEnum;
import software.kalender.pocketcase.games.CaseOpeningGame;
import software.kalender.pocketcase.helpers.LogHelper;
import software.kalender.pocketcase.helpers.MoneyHelper;
import software.kalender.pocketcase.helpers.ResourceHelper;
import software.kalender.pocketcase.models.CaseChanceModel;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.ItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.ItemSkinModel;
import software.kalender.pocketcase.models.ItemTypeModel;
import software.kalender.pocketcase.models.KeyModel;
import software.kalender.pocketcase.views.CaseSelectItemCaseView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Singleton.log = new LogHelper();

        Singleton.db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pocket-case-csgo")
                .allowMainThreadQueries()
                .build();

        Singleton.resource = new ResourceHelper(this);

        ItemTypeModel itemTypeModel = new ItemTypeModel();
        itemTypeModel.name = "Weapon";
        itemTypeModel.insert();

        ItemModel itemModel = new ItemModel();
        itemModel.type = itemTypeModel;
        itemModel.name = "test item ";
        itemModel.insert();

        KeyModel keyModel = new KeyModel();
        keyModel.name = "Key 1";
        keyModel.price = MoneyHelper.make(CurrencyEnum.USD, 15L);
        keyModel.insert();

        CaseModel caseModel = new CaseModel();
        caseModel.name = "Case 1";
        caseModel.caseKey = keyModel;
        caseModel.caseChance = new CaseChanceModel();
        caseModel.price = MoneyHelper.make(CurrencyEnum.USD, 20L);
        caseModel.caseType = CaseTypeEnum.WEAPON_CASE;
        caseModel.insert();

        ItemSkinModel itemSkinModel222 = new ItemSkinModel();
        itemSkinModel222.name = "test RARE";
        itemSkinModel222.color = ColorEnum.RARE;
        itemSkinModel222.item = itemModel;
        itemSkinModel222.skinCase = caseModel;
        itemSkinModel222.insert();


        ItemSkinModel itemSkinModel = new ItemSkinModel();
        itemSkinModel.name = "test MYT";
        itemSkinModel.color = ColorEnum.MYTHICAL;
        itemSkinModel.item = itemModel;
        itemSkinModel.skinCase = caseModel;
        itemSkinModel.insert();

        ItemSkinModel itemSkinModel1 = new ItemSkinModel();
        itemSkinModel1.name = "test LEGE";
        itemSkinModel1.color = ColorEnum.LEGENDARY;
        itemSkinModel1.item = itemModel;
        itemSkinModel1.skinCase = caseModel;
        itemSkinModel1.insert();

        ItemSkinModel itemSkinModel2 = new ItemSkinModel();
        itemSkinModel2.name = "test ANCI";
        itemSkinModel2.color = ColorEnum.ANCIENT;
        itemSkinModel2.item = itemModel;
        itemSkinModel2.skinCase = caseModel;
        itemSkinModel2.insert();

        ItemSkinModel itemSkinModel3 = new ItemSkinModel();
        itemSkinModel3.name = "test COMM";
        itemSkinModel3.color = ColorEnum.COMMON;
        itemSkinModel3.item = itemModel;
        itemSkinModel3.skinCase = caseModel;
        itemSkinModel3.insert();

        ItemSkinModel itemSkinModel4 = new ItemSkinModel();
        itemSkinModel4.name = "test UNCOMM";
        itemSkinModel4.color = ColorEnum.UNCOMMON;
        itemSkinModel4.item = itemModel;
        itemSkinModel4.skinCase = caseModel;
        itemSkinModel4.insert();

        ItemSkinModel itemSkinModel5 = new ItemSkinModel();
        itemSkinModel5.name = "test UNIQ";
        itemSkinModel5.color = ColorEnum.UNIQUE;
        itemSkinModel5.item = itemModel;
        itemSkinModel5.skinCase = caseModel;
        itemSkinModel5.insert();

        ItemQualityModel itemQualityModel = new ItemQualityModel();
        itemQualityModel.statTrak = false;
        itemQualityModel.price = MoneyHelper.make(CurrencyEnum.USD, 25L);
        itemQualityModel.quality = "TEST";
        itemQualityModel.skin = itemSkinModel;
        itemQualityModel.insert();

        for (int i = 0; i < 36; i++) {
            ItemSkinModel itemSkinModel22 = Singleton.db.caseDao().getRandomItemFromColor(caseModel.caseId, ColorEnum.MYTHICAL);

            Log.e("ada", "aaa");
        }


        CaseOpeningGame caseOpeningGame = new CaseOpeningGame(this);

    new Runnable() {
        @Override
        public void run() {

        }
    }.run();


        // CaseSelectingComponent caseSelectingComponent = new CaseSelectingComponent(this);


        //((LinearLayout)findViewById(R.id.zest)).addView(caseSelectingComponent.getView());
        ((LinearLayout) findViewById(R.id.zest)).addView(caseOpeningGame.getView());
//
//        for (CaseModel caseModel : caseModelList) {
//            Log.e("aaa", caseModel.name);
//        }
        // Log.e("ada", room.caseDAO.get(1).name);
    }

}


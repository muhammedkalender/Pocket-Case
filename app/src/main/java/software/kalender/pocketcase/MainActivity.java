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
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import software.kalender.pocketcase.chances.ItemQualityChance;
import software.kalender.pocketcase.components.CaseSelectingComponent;
import software.kalender.pocketcase.database.AppDatabase;
import software.kalender.pocketcase.enums.CaseSpecialEnum;
import software.kalender.pocketcase.enums.CaseTypeEnum;
import software.kalender.pocketcase.enums.ColorEnum;
import software.kalender.pocketcase.enums.CurrencyEnum;
import software.kalender.pocketcase.enums.ItemQualityEnum;
import software.kalender.pocketcase.games.CaseOpeningGame;
import software.kalender.pocketcase.games.InventoryGame;
import software.kalender.pocketcase.helpers.ConfigHelper;
import software.kalender.pocketcase.helpers.LogHelper;
import software.kalender.pocketcase.helpers.MoneyHelper;
import software.kalender.pocketcase.helpers.ResourceHelper;
import software.kalender.pocketcase.helpers.UserHelper;
import software.kalender.pocketcase.helpers.XPHelper;
import software.kalender.pocketcase.models.CaseChanceModel;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.InventoryItemModel;
import software.kalender.pocketcase.models.ItemModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.ItemSkinModel;
import software.kalender.pocketcase.models.ItemTypeModel;
import software.kalender.pocketcase.models.KeyModel;
import software.kalender.pocketcase.models.UserModel;
import software.kalender.pocketcase.views.CaseSelectItemCaseView;
import software.kalender.pocketcase.views.InventoryItemView;

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

        Singleton.configHelper = new ConfigHelper(this);

        if (Singleton.configHelper.getBoolean("first_open", true)) {
            generateDefaultData(); //TODO

            Singleton.configHelper.setBoolean("first_open", false);
        }

        //TODO CaseOpeningGame caseOpeningGame = new CaseOpeningGame(this);
        InventoryGame inventoryGame = new InventoryGame(this);


        new Runnable() {
            @Override
            public void run() {

            }
        }.run();


        // CaseSelectingComponent caseSelectingComponent = new CaseSelectingComponent(this);


        //((LinearLayout)findViewById(R.id.zest)).addView(caseSelectingComponent.getView());
        //TODO ((LinearLayout) findViewById(R.id.zest)).addView(caseOpeningGame.getView());
        ((LinearLayout) findViewById(R.id.zest)).addView(inventoryGame.getView());


        InventoryItemModel inventoryItemModel = Singleton.db.inventoryItemDao().get(1);

        final InventoryItemView inventoryItemView = new InventoryItemView(this, inventoryItemModel);

        ((LinearLayout)findViewById(R.id.sceneMain)).addView(inventoryItemView.getView());

        inventoryItemView.setOnItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("item", "clicked");
            }
        });

        inventoryItemView.setOnItemSelected(new Runnable() {
            @Override
            public void run() {
                Log.e("item", "onselect");

                inventoryItemView.revertSelection();
            }
        });

        inventoryItemView.setOnItemUnSelected(new Runnable() {
            @Override
            public void run() {
                Log.e("item", "on unselect");
            }
        });

        //inventoryItemView.revertSelection();


        Singleton.user = Singleton.db.userDao().defaultUser();
        Singleton.userHelper = new UserHelper();
//
//        for (CaseModel caseModel : caseModelList) {
//            Log.e("aaa", caseModel.name);
//        }
        // Log.e("ada", room.caseDAO.get(1).name);
    }

    private boolean generateDefaultData() {
        //TODO

        Random random = new Random();

        UserModel userModel = new UserModel();
        userModel.userName = "Player";
        userModel.userBalance = MoneyHelper.make(CurrencyEnum.USD, CurrencyEnum.USD.awardedVideoAmount() * 10);
        userModel.userProfileImagePath = ""; //TODO
        userModel.userXP = new XPHelper();
        userModel.insert();

        ItemTypeModel itemTypeModel = new ItemTypeModel();
        itemTypeModel.name = "Weapon";
        itemTypeModel.insert();

        for (int iCase = 0; iCase < 6; iCase++) {
            KeyModel keyModel = new KeyModel();
            keyModel.name = "TEST_KEY #" + random.nextInt(10);
            keyModel.price = MoneyHelper.make(CurrencyEnum.USD, (long) random.nextInt(10000));
            keyModel.insert();

            CaseModel caseModel = new CaseModel();
            caseModel.name = "TEST_CASE #" + random.nextInt(100);
            caseModel.caseKey = keyModel;
            caseModel.caseChance = new CaseChanceModel();
            caseModel.price = MoneyHelper.make(CurrencyEnum.USD, (long) random.nextInt(10000));
            caseModel.caseType = iCase % 2 == 0 ? CaseTypeEnum.WEAPON_CASE : CaseTypeEnum.NULL_CASE;
            caseModel.caseSpecial = CaseSpecialEnum.KNIFE;
            caseModel.insert();

            for (int iItem = 0; iItem < 12; iItem++) {
                ItemModel itemModel = new ItemModel();
                itemModel.type = itemTypeModel;
                itemModel.name = "TEST_ITEM #" + random.nextInt(150);
                itemModel.insert();

                ItemSkinModel itemSkinModel = new ItemSkinModel();
                itemSkinModel.name = "TEST_SKIN #" + iItem;
                itemSkinModel.color = ColorEnum.values()[iItem % ColorEnum.values().length];
                itemSkinModel.item = itemModel;
                itemSkinModel.skinCase = caseModel;
                itemSkinModel.itemQualityChance = new ItemQualityChance();
                itemSkinModel.insert();

                for (int iItemQuality = 0; iItemQuality < ItemQualityEnum.values().length; iItemQuality++) {
                    ItemQualityModel itemQualityModel = new ItemQualityModel();
                    itemQualityModel.statTrak = iItemQuality > 4;
                    itemQualityModel.itemQualityEnum = ItemQualityEnum.values()[iItemQuality];
                    itemQualityModel.price = MoneyHelper.make(CurrencyEnum.USD, (long) random.nextInt(15000));
                    itemQualityModel.quality = "TEST_QUALITY #" + iItemQuality;
                    itemQualityModel.skin = itemSkinModel;
                    itemQualityModel.insert();
                }
            }
        }

        return true;
    }

}


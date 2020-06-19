package software.kalender.pocketcase.games;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.abstracts.GameAbstract;
import software.kalender.pocketcase.components.InventoryComponent;
import software.kalender.pocketcase.enums.AchievementEnum;

public class InventoryGame extends GameAbstract {
    public InventoryGame(@NonNull Context context, @NonNull AchievementEnum[] achievementEnums) {
        super(context, achievementEnums);
    }

    @Override
    public Object reset() {
        return null;
    }

    @Override
    public View generateView() {
        this.view = ((Activity) this.context).getLayoutInflater().inflate(R.layout.game_inventory, null);

        InventoryComponent inventoryComponent = new InventoryComponent(this.context);
        inventoryComponent.setSelectedItemEnable(true, 2);
        inventoryComponent.setOnValidated(() -> Log.e("aaa", "artık okey"));
        inventoryComponent.setOnCancelValidation(() -> Log.e("aaa", "okeydi ama artık değil"));
        inventoryComponent.setSelectedBalanceLowerLimit(100L);
        inventoryComponent.setSelectedBalanceUpperLimit(40000L);
        inventoryComponent.setFilterEnable(true);
        inventoryComponent.setFilterPaginationEnable(true);
        //inventoryComponent.setShowItemEnable((RelativeLayout)this.view);
        inventoryComponent.setSelectedItemEnable(true, 5);

        ((RelativeLayout) this.view).addView(inventoryComponent.getView());

        return this.view;
    }
}

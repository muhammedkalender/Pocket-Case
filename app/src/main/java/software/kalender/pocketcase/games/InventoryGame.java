package software.kalender.pocketcase.games;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.abstracts.GameAbstract;
import software.kalender.pocketcase.components.InventoryComponent;

public class InventoryGame extends GameAbstract {
    public InventoryGame(@NonNull Context context) {
        super(context);
    }

    @Override
    public Object reset() {
        return null;
    }

    @Override
    public View generateView() {
        this.view = ((Activity) this.context).getLayoutInflater().inflate(R.layout.game_inventory, null);

        InventoryComponent inventoryView = new InventoryComponent(this.context);

        ((RelativeLayout)this.view).addView(inventoryView.getView());

        return this.view;
    }
}

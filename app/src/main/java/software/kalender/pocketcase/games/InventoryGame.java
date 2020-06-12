package software.kalender.pocketcase.games;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.abstracts.GameAbstract;

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
        this.view = ((Activity)this.context).getLayoutInflater().inflate(R.layout.game_inventory, null);



        return this.view;
    }
}

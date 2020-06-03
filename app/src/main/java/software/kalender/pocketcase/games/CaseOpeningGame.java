package software.kalender.pocketcase.games;

import android.content.Context;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.abstracts.GameAbstract;
import software.kalender.pocketcase.interfaces.GameInterface;

public class CaseOpeningGame extends GameAbstract implements GameInterface<CaseOpeningGame> {
    //TODO

    public CaseOpeningGame(@NonNull Context context) {
        super(context);
    }

    @Override
    public CaseOpeningGame reset() {
        return null;
    }
}

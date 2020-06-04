package software.kalender.pocketcase.abstracts;

import android.content.Context;
import android.view.View;

import software.kalender.pocketcase.interfaces.ComponentInterface;

/*
    View, fonksiyonla birlikte gelebilir - Yoksa ilgili view oluşturuur ( inflate edilir )
    Scene son çıktı, ekrana eklenmek isiterse eklenebilir vs..
 */

public abstract class ComponentAbstract implements ComponentInterface {
    protected Context context;
    protected View view;

    public ComponentAbstract(Context context) {
        this.context = context;
    }

    public ComponentAbstract(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public View getView() {
        if (view != null) {
            return view;
        }

        return generateView();
    }
}

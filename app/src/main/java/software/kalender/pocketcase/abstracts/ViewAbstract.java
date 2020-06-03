package software.kalender.pocketcase.abstracts;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.interfaces.ViewInterface;

public abstract class ViewAbstract<T> implements ViewInterface {
    protected Context context;
    protected View view;
    public T model;

    public ViewAbstract(@NonNull Context context, T model) {
        this.context = context;
        this.model = model;
    }

    public View getView() {
        if (view != null) {
            return view;
        }

        return generateView();
    }

    public View getViewWithClick(View.OnClickListener listener, long id) {
        if (view != null) {
            return view;
        }

        return generateViewWithClick(listener, id);
    }

    public View generateViewWithClick(View.OnClickListener listener, long id) {
        View _view = getView();
        _view.setOnClickListener(listener);
        _view.setTag(id);

        return _view;
    }
}

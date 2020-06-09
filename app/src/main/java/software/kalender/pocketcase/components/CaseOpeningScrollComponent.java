package software.kalender.pocketcase.components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.logging.Handler;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.abstracts.ComponentAbstract;
import software.kalender.pocketcase.enums.ItemQualityEnum;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.ItemQualityModel;
import software.kalender.pocketcase.models.ItemSkinModel;
import software.kalender.pocketcase.views.OpeningScrollItemView;

public class CaseOpeningScrollComponent extends ComponentAbstract {
    private Runnable onStart, onFinish;
    private HorizontalScrollView scrollView;
    public boolean isRunning = false;

    public CaseOpeningScrollComponent(Context context) {
        super(context);
    }

    public CaseOpeningScrollComponent(Context context, View view) {
        super(context, view);
    }

    @Override
    public View generateView() {
        if(view == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();

            view = inflater.inflate(R.layout.component_case_scroll, null);
        }

      scrollView = view.findViewById(R.id.componentCaseScrollScroll);

        scrollView.setSmoothScrollingEnabled(true);

        view.findViewById(R.id.componentCaseSelectScrollParent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("asda", "111");


            }
        });

        return view;
    }

    public boolean addToScroll(ItemSkinModel[] itemSkinModels){
        for(ItemSkinModel itemSkinModel : itemSkinModels){
            OpeningScrollItemView openingScrollItemView = new OpeningScrollItemView(this.context, itemSkinModel);

            ((LinearLayout)view.findViewById(R.id.componentCaseScrollScrollList)).addView(openingScrollItemView.getView());
        }

        return true; //TODO
    }

    public boolean play(){
        scrollView.setScrollX(0);

        //TODO Ayar çekilecek
        ObjectAnimator objectAnimator = ObjectAnimator
                .ofInt(scrollView, "scrollX", 5500)
                .setDuration(5000);

        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() > 0.5f) {
                    if (valueAnimator.getDuration() == 5000) {
                        valueAnimator.setDuration(5500);
                    } else if (valueAnimator.getAnimatedFraction() < 0.55f && valueAnimator.getDuration() == 5500) {
                        valueAnimator.setDuration(6000);
                    } else if (valueAnimator.getAnimatedFraction() < 0.6f && valueAnimator.getDuration() == 6000) {
                        valueAnimator.setDuration(7000);
                    } else if (valueAnimator.getAnimatedFraction() < 0.6f && valueAnimator.getDuration() == 6000) {
                        valueAnimator.setDuration(8000);
                    } else if (valueAnimator.getAnimatedFraction() < 0.7f && valueAnimator.getDuration() == 8000) {
                        valueAnimator.setDuration(9000);
                    } else if (valueAnimator.getAnimatedFraction() < 0.9f && valueAnimator.getDuration() == 9000) {
                        valueAnimator.setDuration(10000);
                    } else if (valueAnimator.getDuration() == 10000) {
                        valueAnimator.setDuration(12000); //TODO UNIQSES +1 SN OLABİLİR
                    }
                    Log.e("FRAC", String.valueOf(valueAnimator.getAnimatedFraction()));
                    Log.e("VALUE", valueAnimator.getAnimatedValue().toString());
                    Log.e("DURA", String.valueOf(valueAnimator.getDuration()));
                }
            }
        });

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);

                isRunning = true;

                showViewsOfComponent();

                if(onStart != null){
                    onStart.run();
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                isRunning = false;

                if(onFinish != null){
                    onFinish.run();
                }
            }
        });


        objectAnimator.start();

        return true;//TODO
    }

    public Runnable getOnStart() {
        return onStart;
    }

    public void setOnStart(Runnable onStart) {
        this.onStart = onStart;
    }

    public Runnable getOnFinish() {
        return onFinish;
    }

    public void setOnFinish(Runnable onFinish) {
        this.onFinish = onFinish;
    }

    public boolean loadCaseDetail(@NonNull CaseModel caseModel){
        //TODO

        ((ImageView)view.findViewById(R.id.imageSelectCase)).setImageResource(R.mipmap.test); //TODO, GLIDE
        ((TextView)view.findViewById(R.id.nameSelectCase)).setText(caseModel.name);
        ((TextView)view.findViewById(R.id.priceSelectCase)).setText(caseModel.price.getFormattedText());

        if(caseModel.caseKey != null){
            ((ImageView)view.findViewById(R.id.imageSelectKey)).setImageResource(R.mipmap.test); //TODO, GLIDE
            ((TextView)view.findViewById(R.id.nameSelectKey)).setText(caseModel.caseKey.name);
            ((TextView)view.findViewById(R.id.priceSelectKey)).setText(caseModel.caseKey.price.getFormattedText());
        }


        return true;
    }

    public boolean showViewsOfComponent(){
        //TODO

        view.findViewById(R.id.componentCaseSelectSelectedParent).setVisibility(View.INVISIBLE);
        view.findViewById(R.id.componentCaseScrollScroll).setVisibility(View.VISIBLE);
        view.findViewById(R.id.componentCaseScrollRouletteUp).setVisibility(View.VISIBLE);

        return true;
    }

    public boolean hideViewsOfComponent(){
        //TODO

        if(isRunning){
           return true;
        }

        view.findViewById(R.id.componentCaseSelectSelectedParent).setVisibility(View.VISIBLE);
        view.findViewById(R.id.componentCaseScrollScroll).setVisibility(View.INVISIBLE);
        view.findViewById(R.id.componentCaseScrollRouletteUp).setVisibility(View.INVISIBLE);

        return true;
    }

    //TODO
}

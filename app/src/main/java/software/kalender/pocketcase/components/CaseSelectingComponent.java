package software.kalender.pocketcase.components;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import software.kalender.pocketcase.R;
import software.kalender.pocketcase.Singleton;
import software.kalender.pocketcase.abstracts.ComponentAbstract;
import software.kalender.pocketcase.enums.CaseSpecialEnum;
import software.kalender.pocketcase.enums.CaseTypeEnum;
import software.kalender.pocketcase.enums.ColorEnum;
import software.kalender.pocketcase.models.CaseModel;
import software.kalender.pocketcase.models.ItemSkinModel;
import software.kalender.pocketcase.views.CaseSelectItemCaseView;
import software.kalender.pocketcase.views.CaseSelectItemSkinView;

public class CaseSelectingComponent extends ComponentAbstract {
    private GridLayout gridLayout;
    private View.OnClickListener clickListenerCase;
    private Runnable onCaseChanged;

    private CaseModel selectedCase;
    public CaseModel getSelectedCase() {
        return selectedCase;
    }

    public void setSelectedCase(CaseModel selectedCase) {
        this.selectedCase = selectedCase;
    }
    public CaseSelectingComponent(Context context) {
        super(context);
    }

    public Runnable getOnCaseChanged() {
        return onCaseChanged;
    }

    public void setOnCaseChanged(Runnable onCaseChanged) {
        this.onCaseChanged = onCaseChanged;
    }

    public CaseSelectingComponent(Context context, View view){
        super(context, view);
    }

    @Override
    public View generateView() {
        if(view == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();

            view = inflater.inflate(R.layout.component_case_select, null);
        }

        TabLayout _tabLayout = view.findViewById(R.id.componentCaseSelectTab);

        //Building tabs
        CaseTypeEnum[] caseTypes = CaseTypeEnum.values();

        for (CaseTypeEnum caseType : caseTypes) {
            TabLayout.Tab tab = _tabLayout.newTab();
            tab.setText(caseType.getName());

            _tabLayout.addTab(tab);
        }

        _tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                this.onTabReselected(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                loadCases(CaseTypeEnum.values()[tab.getPosition()]);
            }
        });

        gridLayout = view.findViewById(R.id.componentCaseSelectScrollGrid);

        clickListenerCase = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                Log.e("TODO", view.getTag().toString());

                loadItems((Long) view.getTag());

                selectedCase = Singleton.db.caseDao().get((Long) view.getTag());

                if(onCaseChanged != null){
                    onCaseChanged.run();
                }
            }
        };

        _tabLayout.selectTab(_tabLayout.getTabAt(0));

        return view;
    }

    public boolean loadCases(CaseTypeEnum caseType) {
        gridLayout.removeAllViews();

        List<CaseModel> caseModels = Singleton.db.caseDao().listFromType(caseType);

        for (CaseModel caseModel : caseModels) {
            CaseSelectItemCaseView caseSelectItemView = new CaseSelectItemCaseView(this.context, caseModel);

            gridLayout.addView(caseSelectItemView.getViewWithClick(clickListenerCase, caseModel.caseId));
        }

        return true; //TODO
    }

    public boolean loadItems(Long id){
        return loadItems(Singleton.db.caseDao().get(id));
    }

    public boolean loadItems(CaseModel caseModel) {
        //todo
        gridLayout.removeAllViews();

        List<ItemSkinModel> itemSkinModels = Singleton.db.itemSkinDao().listFromCaseId(caseModel.caseId);

        for(ItemSkinModel itemSkinModel : itemSkinModels){
            if(itemSkinModel.color == ColorEnum.UNIQUE){
                continue;
            }

            CaseSelectItemSkinView caseSelectItemSkinView = new CaseSelectItemSkinView(this.context, itemSkinModel);

            gridLayout.addView(caseSelectItemSkinView.getView());
        }

        if(caseModel.caseSpecial != null){
            CaseSelectItemSkinView caseSelectItemSkinView = new CaseSelectItemSkinView(this.context, caseModel.caseSpecial.toItemSkinModel(caseModel));

            gridLayout.addView(caseSelectItemSkinView.getView());
        }

        return true;
    }
    //TODO
}

package software.kalender.pocketcase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.List;
import java.util.zip.Inflater;

import software.kalender.pocketcase.database.AppDatabase;
import software.kalender.pocketcase.models.CaseModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pocket-case-csgo")
                .allowMainThreadQueries()
                .build();

//        room.caseDAO.get()

        CaseModel caseModel1 = new CaseModel();
        caseModel1.name = "test 1";
        db.caseDao().insert(caseModel1);
        // room.caseDAO.insert(caseModel1);

        CaseModel caseModel2 = new CaseModel();
        caseModel2.name = "test 2";
        db.caseDao().insert(caseModel2);
        // room.caseDAO.insert(caseModel1);
        List<CaseModel> caseModelList = db.caseDao().list();
Log.e("aaaa", caseModelList.size()+"--");

        final HorizontalScrollView scrollView = findViewById(R.id.svscroll);
LinearLayout linearLayout = findViewById(R.id.test);
        scrollView.setSmoothScrollingEnabled(true);

        LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < 50; i++){
             linearLayout.addView(inflater.inflate(R.layout.case_opening_item, null, false));
        }

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("asda", "111");
                ObjectAnimator.ofInt(scrollView, "scrollX",  10000).setDuration(5000).start();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ObjectAnimator.ofInt(scrollView, "scrollX",  12000).setDuration(5000).start();
                            }
                        });
                    }
                }, 5000);
            }
        });

        for (CaseModel caseModel : caseModelList) {
            Log.e("aaa", caseModel.name);
        }
        // Log.e("ada", room.caseDAO.get(1).name);
    }
}

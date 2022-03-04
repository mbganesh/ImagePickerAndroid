package mb.ganesh.imagepickerapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import mb.ganesh.imagepickerapp.patterns.AllTopPatternsFragment;
import mb.ganesh.imagepickerapp.patterns.BlousePatternFragment;
import mb.ganesh.imagepickerapp.patterns.SalwarPatternFragment;
import mb.ganesh.imagepickerapp.patterns.TopBlousePatternFragment;
import mb.ganesh.imagepickerapp.patterns.TopSalwarPatternFragment;
import mb.ganesh.imagepickerapp.patterns.TopWorkBlousePatternFragment;
import mb.ganesh.imagepickerapp.patterns.WorkBlousePatternFragment;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAINAC";
    BottomNavigationView bottomNavigationView;
    TextView powerBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate() called");
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        powerBy = findViewById(R.id.powerById);

        String text = "<font color=#010101>Powered By </font> <b> <font font color=#519259> Netcom Computers Pvt Ltd </font> </b>";
        powerBy.setText(Html.fromHtml(text));

        powerBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.ncpli.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                Bundle bundle = new Bundle();
                switch (item.getItemId()) {
                    case R.id.b_nav_salwar_pattern:
                        bundle.putString("colorCode", "#B52B65");       // init load color
                        fragment = new SalwarPatternFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_blouse_pattern:
                        bundle.putString("colorCode", "#1572A1");       // init load color
                        fragment = new BlousePatternFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_workblouse_pattern:
                        bundle.putString("colorCode", "#9153F4");       // init load color
                        fragment = new WorkBlousePatternFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_top_salwar_pattern:

//                        bundle.putString("colorCode", "#3E497A");       // init load color
//                        fragment = new TopSalwarPatternFragment();
//                        fragment.setArguments(bundle);

                        bundle.putString("colorCode", "#3E497A");       // init load color
                        fragment = new AllTopPatternsFragment();
                        fragment.setArguments(bundle);

                        break;

//                    case R.id.b_nav_top_blouse_pattern:
//                        bundle.putString("colorCode", "#3E497A");       // init load color
//                        fragment = new TopBlousePatternFragment();
//                        fragment.setArguments(bundle);
//                        break;
//
//                    case R.id.b_nav_top_workblouse_pattern:
//                        bundle.putString("colorCode", "#3E497A");       // init load color
//                        fragment = new TopWorkBlousePatternFragment();
//                        fragment.setArguments(bundle);
//                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                return true; // return true;
            }
        });
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState() called");
    }
}
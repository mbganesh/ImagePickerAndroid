package mb.ganesh.imagepickerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import mb.ganesh.imagepickerapp.patterns.BlouseNeckFragment;
import mb.ganesh.imagepickerapp.patterns.BlouseSleeveFragment;
import mb.ganesh.imagepickerapp.patterns.SalwarNeckFragment;
import mb.ganesh.imagepickerapp.patterns.SalwarSleeveFragment;
import mb.ganesh.imagepickerapp.patterns.WorkBlouseFragment;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                Bundle bundle = new Bundle();
                switch (item.getItemId()) {
                    case R.id.b_nav_salwar_neck:
                        bundle.putString("colorCode", "#0F00FF");       // init load color
                        fragment = new SalwarNeckFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_salwar_sleeve:
                        bundle.putString("colorCode", "#00adb5");       // init load color
                        fragment = new SalwarSleeveFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_blouse_neck:
                        bundle.putString("colorCode", "#FFC900");       // init load color
                        fragment = new BlouseNeckFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_blouse_sleeve:
                        bundle.putString("colorCode", "#EF2F88");       // init load color
                        fragment = new BlouseSleeveFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_work_blouse:
                        bundle.putString("colorCode", "#7900FF");       // init load color
                        fragment = new WorkBlouseFragment();
                        fragment.setArguments(bundle);
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                return true; // return true;
            }
        });
    }
}
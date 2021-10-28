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

import mb.ganesh.imagepickerapp.patterns.WorkBlouseFragment;
import mb.ganesh.imagepickerapp.patterns.SleeveFragment;
import mb.ganesh.imagepickerapp.patterns.NeckFragment;


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
                    case R.id.b_nav_neck:
//                        Bundle bundle3 = new Bundle();
                        bundle.putString("colorCode", "#FF0075");
                        fragment = new NeckFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_work_blouse:

                        bundle.putString("colorCode", "#9C19E0");
                        fragment = new WorkBlouseFragment();
                        fragment.setArguments(bundle);
                        break;
                    case R.id.b_nav_sleeve:
//                        Bundle bundle2 = new Bundle();
                        bundle.putString("colorCode", "#0F00FF");       // init load color
                        fragment = new SleeveFragment();
                        fragment.setArguments(bundle);
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                return true; // return true;
            }
        });
    }
}
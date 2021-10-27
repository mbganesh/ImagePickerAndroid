package mb.ganesh.imagepickerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import mb.ganesh.imagepickerapp.patterns.BlouseFragment;
import mb.ganesh.imagepickerapp.patterns.SleeveFragment;
import mb.ganesh.imagepickerapp.patterns.SalwarFragment;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;


//    New

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
                switch (item.getItemId()) {
                    case R.id.b_nav_blouse:
                        fragment = new BlouseFragment();
                        break;
                    case R.id.b_nav_salwar:
                        fragment = new SalwarFragment();
                        break;
                    case R.id.b_nav_neck:
                        fragment = new SleeveFragment();

                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                return true; // return true;
            }
        });

    }

    private void loadPatterns(String path) {

//        recyclerView = findViewById(R.id.recyclerViewId);
//        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
//
//        loadPatterns("/Patterns/NPatterns/");

//        File folder = new File(Environment.getExternalStorageDirectory().toString() + path);  // SPatterns    WPatterns
//        folder.mkdirs();
//        File[] allFiles = folder.listFiles(new FilenameFilter() {
//            public boolean accept(File dir, String name) {
//                return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
//            }
//        });

//        adapter = new MyRecyclerViewAdapter(this, allFiles);
//        recyclerView.setAdapter(adapter);

    }


}
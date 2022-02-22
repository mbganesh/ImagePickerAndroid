package mb.ganesh.imagepickerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import mb.ganesh.imagepickerapp.patterns.BlouseNeckFragment;
import mb.ganesh.imagepickerapp.patterns.BlouseSleeveFragment;
import mb.ganesh.imagepickerapp.patterns.SalwarNeckFragment;
import mb.ganesh.imagepickerapp.patterns.SalwarSleeveFragment;
import mb.ganesh.imagepickerapp.patterns.WorkBlouseFragment;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView powerBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

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

//                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
//                CustomTabsIntent customTabsIntent = builder.build();
//                customTabsIntent.launchUrl(MainActivity.this, Uri.parse("http://ncpli.com/"));
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                Bundle bundle = new Bundle();
                switch (item.getItemId()) {
                    case R.id.b_nav_salwar_neck:
                        bundle.putString("colorCode", "#B52B65");       // init load color
                        fragment = new SalwarNeckFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_salwar_sleeve:
                        bundle.putString("colorCode", "#3E497A");       // init load color
                        fragment = new SalwarSleeveFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_blouse_neck:
                        bundle.putString("colorCode", "#1572A1");       // init load color
                        fragment = new BlouseNeckFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_blouse_sleeve:
                        bundle.putString("colorCode", "#DD4A48");       // init load color
                        fragment = new BlouseSleeveFragment();
                        fragment.setArguments(bundle);
                        break;

                    case R.id.b_nav_work_blouse:
                        bundle.putString("colorCode", "#9153F4");       // init load color
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
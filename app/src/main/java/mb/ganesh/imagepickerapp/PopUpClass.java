package mb.ganesh.imagepickerapp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.button.MaterialButton;
public class PopUpClass {

    Bitmap bitmap;
    String title;
    String crl;

    public PopUpClass(Bitmap bitmap, String title, String crl) {
        this.bitmap = bitmap;
        this.title = title;
        this.crl = crl;
    }

    public void showPopupWindow(final View view) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_up_layout, null);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Log.e("PopUp"  , crl);

        int width = 700;
        int height = 850;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        popupWindow.setOutsideTouchable(true);

        ImageView btn = popupView.findViewById(R.id.closeBtnPop);

        ImageView img = popupView.findViewById(R.id.popUpImage);
        img.setImageBitmap(bitmap);

        String[] titles = title.split("-");

//        ID
        TextView patternIdPop = popupView.findViewById(R.id.patternIdPop);
        patternIdPop.setText("pattern ID : "+titles[0]);
        patternIdPop.setBackgroundColor(Color.parseColor(crl));

//        Price
        TextView patternPricePop = popupView.findViewById(R.id.patternIdPricePop);
        patternPricePop.setText("Price : ₹ "+titles[1]);
        patternPricePop.setBackgroundColor(Color.parseColor(crl));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                popupWindow.dismiss();
                return true;
            }
        });
    }
}
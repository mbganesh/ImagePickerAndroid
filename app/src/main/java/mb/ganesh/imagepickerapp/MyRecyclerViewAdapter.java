package mb.ganesh.imagepickerapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    Context context;
    File[] allFiles;
    String crl;

    public MyRecyclerViewAdapter(Context context, File[] allFiles, String crl) {
        this.context = context;
        this.allFiles = allFiles;
        this.crl = crl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.image_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if(crl != null){
            Log.e("RecCode" , crl+"");

        }else {
            crl = "#FF0075";
        }



        String string = allFiles[position].toString();
        String[] parts = string.split("/");
        String titleWithExt = parts[6];
        String[] titleTemp = titleWithExt.split("\\.");
        String[] title = titleTemp[0].split("-");


        holder.myId.setText(title[0]);
        holder.myPrice.setText("₹ "+title[1]);

        Bitmap bmImg = BitmapFactory.decodeFile(allFiles[position].toString());
        holder.myImage.setImageBitmap(bmImg);

        holder.myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmImgTemp = BitmapFactory.decodeFile(allFiles[position].toString());
                String string = allFiles[position].toString();
                String[] parts = string.split("/");
                String titleWithExt = parts[6];
                String[] title = titleWithExt.split("\\.");

                PopUpClass popUpClass = new PopUpClass(bmImgTemp , title[0] ,  crl);
                popUpClass.showPopupWindow(view);
            }
        });



        holder.myId.setBackgroundColor(Color.parseColor(crl));
        holder.myPrice.setBackgroundColor(Color.parseColor(crl));
        holder.myCard.setStrokeColor(Color.parseColor(crl));

    }

    @Override
    public int getItemCount() {
        return allFiles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView myImage;
        TextView myId , myPrice;
        MaterialCardView myCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.myImage);
            myId = itemView.findViewById(R.id.myId);
            myPrice = itemView.findViewById(R.id.myPrice);
            myCard = itemView.findViewById(R.id.myCard);
        }
    }
}

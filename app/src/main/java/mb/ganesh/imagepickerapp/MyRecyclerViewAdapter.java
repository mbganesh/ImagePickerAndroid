package mb.ganesh.imagepickerapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    Context context;

    File[] allFiles;

    public MyRecyclerViewAdapter(Context context, File[] allFiles) {
        this.context = context;
        this.allFiles = allFiles;
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

        String string = allFiles[position].toString();
        String[] parts = string.split("/");
        String titleWithExt = parts[6];
        String[] titleTemp = titleWithExt.split("\\.");


        String[] title = titleTemp[0].split("-");
//
//        for (int i = 0; i < title.length; i++) {
//            Log.e("Temp : " + i , title[i]);
//        }


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

                PopUpClass popUpClass = new PopUpClass(bmImgTemp , title[0] );
                popUpClass.showPopupWindow(view);
            }
        });


    }

    @Override
    public int getItemCount() {
        return allFiles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView myImage;
        TextView myId , myPrice;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.myImage);
            myId = itemView.findViewById(R.id.myId);
            myPrice = itemView.findViewById(R.id.myPrice);
        }
    }
}

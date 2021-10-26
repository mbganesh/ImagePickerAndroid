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

        Bitmap bmImg = BitmapFactory.decodeFile(allFiles[position].toString());
        holder.myImage.setImageBitmap(bmImg);

        String string = allFiles[position].toString();
        String[] parts = string.split("/");

        String titleWithExt = parts[6];

        String[] title = titleWithExt.split("\\.");

        holder.myTitle.setText(title[0]);

    }

    @Override
    public int getItemCount() {
        return allFiles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView myImage;
        TextView myTitle;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.myImage);
            myTitle = itemView.findViewById(R.id.myTitle);
        }
    }
}

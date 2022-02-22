package mb.ganesh.imagepickerapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Handler;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    Context context;
    File[] allFiles;
    String crl;

    ImageLoader imageLoader = ImageLoader.getInstance(); // Get singleton instance

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

        try{
            imageLoader.init(ImageLoaderConfiguration.createDefault(context));

            if (crl == null) {
                crl = "#FF0075";
            }

            String string = allFiles[position].toString();
            Log.e("XXAdapter" , string);
            String[] parts = string.split("/");
            String titleWithExt = parts[7];                     //  extra path add one*
            String[] titleTemp = titleWithExt.split("\\.");
            String[] title = titleTemp[0].split("-");

            holder.myId.setText(title[0]);
            holder.myPrice.setText("₹ " + title[1]);
        }catch (Exception e){
            e.printStackTrace();
        }


        try{
            imageLoader.displayImage("file://"+allFiles[position].toString(), holder.myImage,  new ImageLoadingListener() {         // file://
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    Log.e("onLoading", "Loading...");
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    Log.e("onLoadingFailed", "onLoadingFailed...");
                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    Log.e("onLoadingComplete", "onLoadingComplete...");
                    Log.e("imageUri", imageUri);        // file://

                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    Log.e("onLoadingCancelled", "onLoadingCancelled...");
                }
            });
        }catch (Exception e){
            Log.e("ERR-CATCH" , e.getMessage());
            e.printStackTrace();
        }


        try{
            holder.myImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bitmap bmImgTemp = BitmapFactory.decodeFile(allFiles[position].toString());
                    String string = allFiles[position].toString();
                    String[] parts = string.split("/");
                    String titleWithExt = parts[7];
                    String[] title = titleWithExt.split("\\.");

                    PopUpClass popUpClass = new PopUpClass(bmImgTemp, title[0], crl);
                    popUpClass.showPopupWindow(view);
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }

       try{
           holder.myId.setBackgroundColor(Color.parseColor(crl));
           holder.myPrice.setBackgroundColor(Color.parseColor(crl));
           holder.myCard.setStrokeColor(Color.parseColor(crl));
       }catch (Exception e){
           e.printStackTrace();
       }

    }

    @Override
    public int getItemCount() {
        return allFiles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView myImage;
        TextView myId, myPrice;
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

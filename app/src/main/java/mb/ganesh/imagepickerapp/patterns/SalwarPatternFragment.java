package mb.ganesh.imagepickerapp.patterns;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;

import mb.ganesh.imagepickerapp.MyRecyclerViewAdapter;
import mb.ganesh.imagepickerapp.R;


public class SalwarPatternFragment extends Fragment {

    //    Salwar Neck

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    String crl ="";

    MaterialCardView noImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.pattern_fragment_layout, container, false);
        crl = getArguments() != null ? getArguments().getString("colorCode") : null;
        recyclerView = view.findViewById(R.id.recyclerViewBPId);
        // new
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 4));

        noImage = view.findViewById(R.id.noImageId);

        int orientation = getResources().getConfiguration().orientation;

        Log.e("orientation" , orientation+"");

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 4));
        }


        loadPatterns("/Patterns/SALWAR/"); // change path
        return  view;
    }

    private void loadPatterns(String path) {
        LoadPatterns loadPatterns = new LoadPatterns();

        int imageCount = loadPatterns.loadPatternss(path).length;
        Log.e("imageCountSalwar",imageCount+"");
        if(imageCount == 0){
            noImage.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            adapter = new MyRecyclerViewAdapter(getContext(), loadPatterns.loadPatternss(path) , crl);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        } else  {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 4));
        }
    }
}
package mb.ganesh.imagepickerapp.patterns;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FilenameFilter;

import mb.ganesh.imagepickerapp.MyRecyclerViewAdapter;
import mb.ganesh.imagepickerapp.R;

public class SalwarSleeveFragment extends Fragment {

    //    Salwar Sleeve

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    String crl ="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_work_blouse, container, false);
        crl = getArguments() != null ? getArguments().getString("colorCode") : null;
        recyclerView = view.findViewById(R.id.recyclerViewBPId);
        // new
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        loadPatterns("/Patterns/SALWAR/SPatterns/");  // change path
        return  view;
    }
    private void loadPatterns(String path) {
        LoadPatterns loadPatterns = new LoadPatterns();
        adapter = new MyRecyclerViewAdapter(getContext(), loadPatterns.loadPatternss(path) , crl);
        recyclerView.setAdapter(adapter);
    }
}
package mb.ganesh.imagepickerapp.patterns;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mb.ganesh.imagepickerapp.MyRecyclerViewAdapter;
import mb.ganesh.imagepickerapp.R;


public class SalwarPatternFragment extends Fragment {

    //    Salwar Neck

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    String crl ="";

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

        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        loadPatterns("/Patterns/SALWAR/"); // change path
        return  view;
    }

    private void loadPatterns(String path) {
        LoadPatterns loadPatterns = new LoadPatterns();
        adapter = new MyRecyclerViewAdapter(getContext(), loadPatterns.loadPatternss(path) , crl);
        recyclerView.setAdapter(adapter);
    }
}
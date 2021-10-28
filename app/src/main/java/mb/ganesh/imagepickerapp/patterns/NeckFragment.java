package mb.ganesh.imagepickerapp.patterns;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.io.FilenameFilter;

import mb.ganesh.imagepickerapp.MyRecyclerViewAdapter;
import mb.ganesh.imagepickerapp.R;

public class NeckFragment extends Fragment {

//    NECK

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;

    String crl ="";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_neck, container, false);


        crl = getArguments() != null ? getArguments().getString("colorCode") : null;
        Log.e("Color Neck Fragment"  , crl+"");

        recyclerView = view.findViewById(R.id.recyclerViewSPId);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        loadPatterns("/Patterns/NPatterns/");

        return  view;
    }



    private void loadPatterns(String path) {

        File folder = new File(Environment.getExternalStorageDirectory().toString() + path);  // SPatterns    WPatterns
        folder.mkdirs();
        File[] allFiles = folder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
            }
        });

        adapter = new MyRecyclerViewAdapter(getContext(), allFiles , crl);
        recyclerView.setAdapter(adapter);

    }
}
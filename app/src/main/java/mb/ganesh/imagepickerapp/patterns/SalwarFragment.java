package mb.ganesh.imagepickerapp.patterns;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.io.FilenameFilter;

import mb.ganesh.imagepickerapp.MyRecyclerViewAdapter;
import mb.ganesh.imagepickerapp.R;

public class SalwarFragment extends Fragment {

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_salwar, container, false);


        recyclerView = view.findViewById(R.id.recyclerViewSPId);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        loadPatterns("/Patterns/SPatterns/");

        return  view;
    }



    private void loadPatterns(String path) {

//        recyclerView = findViewById(R.id.recyclerViewId);
//        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
//
//        loadPatterns("/Patterns/NPatterns/");

        File folder = new File(Environment.getExternalStorageDirectory().toString() + path);  // SPatterns    WPatterns
        folder.mkdirs();
        File[] allFiles = folder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
            }
        });

        adapter = new MyRecyclerViewAdapter(getContext(), allFiles);
        recyclerView.setAdapter(adapter);

    }
}
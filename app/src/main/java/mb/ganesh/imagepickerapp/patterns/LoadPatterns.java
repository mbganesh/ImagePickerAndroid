package mb.ganesh.imagepickerapp.patterns;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;


public class LoadPatterns {

    public File[] loadPatternss(String path) {
        File[] allFiles;
        File folder = new File(Environment.getExternalStorageDirectory().toString() + path);  // SPatterns    WPatterns ( Work Blouse )
        folder.mkdirs();

        if(folder.exists()){
            allFiles = folder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
                }
            });
        }else{
           allFiles = new File[0];
        }

        return allFiles;
    }

}

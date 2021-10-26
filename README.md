# ImagePickerAndroid


## File

```


    // getImage
        File folder = new File(Environment.getExternalStorageDirectory().toString() + path);  // SPatterns    WPatterns ( Work Blouse )
        folder.mkdirs();
        File[] allFiles = folder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
            }
        });
        
        // setImage
        Bitmap bmImg = BitmapFactory.decodeFile(allFiles[position].toString());
        holder.myImage.setImageBitmap(bmImg);


```

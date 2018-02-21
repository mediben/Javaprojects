package com.callads.loadimages;

import java.io.File;
import java.security.acl.LastOwnerException;

import android.content.Context;
 
public class FileCache {
 
    private File cacheDir;
 
    public FileCache(Context context){
        //Find the dir to save cached images
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            cacheDir=new File(android.os.Environment.getExternalStorageDirectory(),"SMILE");
        else
            cacheDir=context.getCacheDir();
      
            cacheDir.mkdirs();
    }
 
    public File getFile(String url)
    {
    	String filename= url.substring(url.lastIndexOf("/"));
    	//String filename1="1.png";
    	File f1 = new File(cacheDir, filename);
        return f1;
 
    }
    
 
    public void clear()
    {
        File[] files=cacheDir.listFiles();
        if(files==null)
            return;
        for(File f:files)
            f.delete();
    }
 
}
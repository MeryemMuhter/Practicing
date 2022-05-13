package com.codepracticing.uyghurit;

import java.io.File;

public class FileUtility {
    private static String home=System.getProperty("user.home");
    public static String getMostRecentFilePath(String path){
        File dir=new File(path);
        File[] allFiles=dir.listFiles();
        if (allFiles==null || allFiles.length==0){
            return null;
        }
        File lastFile=allFiles[0];
        for (int i=1; i<allFiles.length;i++){
            if (lastFile.lastModified()<allFiles[1].lastModified()){
                lastFile=allFiles[i];
            }
        }
        return lastFile.getAbsolutePath();
    }
    public static boolean delete(String path){
        File file=new File(path);
        return file.delete();
    }

    public static void main(String[] args) {
        String lastModified=getMostRecentFilePath(home+"/Downloads");
        System.out.println(lastModified);
    }

}

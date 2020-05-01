package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryHelper {
    public static List<String> fetchAllFiles(File folder) {
        List<String> listStrings = new ArrayList<>();

        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isFile()){
                listStrings.add(file.getPath());
            }
            else {
                File[] filesSubDir = file.listFiles();
                for (int j = 0; j < filesSubDir.length; j++) {
                    File fileOfSubDir = filesSubDir[j];
                    listStrings.add(fileOfSubDir.getName());
                }
            }
        }
        return listStrings;
    }
}

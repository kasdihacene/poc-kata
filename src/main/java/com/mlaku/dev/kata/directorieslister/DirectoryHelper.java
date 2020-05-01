package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryHelper {
    public static List<String> fetchAllFiles(File folder) {
        List<String> listStrings = new ArrayList<>();

        for (int i = 0; i < folder.listFiles().length; i++) {
            File file = folder.listFiles()[i];
            listStrings.add(file.getPath());
        }
        return listStrings;
    }
}

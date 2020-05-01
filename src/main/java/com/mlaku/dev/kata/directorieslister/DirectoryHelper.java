package com.mlaku.dev.kata.directorieslister;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryHelper {
    public static List<String> fetchAllFiles(File folder) {
        return recursiveSearch(folder);
    }

    private static List<String> recursiveSearch(File folder) {
        List<String> returnPaths = new ArrayList<>();
        if (folder.isFile()) {
            returnPaths.add(folder.getPath());
            return Arrays.asList(folder.getPath());
        } else {
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++) {

                returnPaths.addAll(recursiveSearch(files[i]));
            }
        }

        return returnPaths;
    }


}

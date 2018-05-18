package com.gsmayya.services;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class FileList {

    private final String dirName;
    private final Map<String, Boolean> fileNames;

    public FileList(String dirName) {
        this.dirName = dirName;
        File file = new File(dirName);
        fileNames = Arrays.stream(file.listFiles())
                .collect(Collectors.toMap(File::getName, File::isDirectory));
    }

    public Map<String, Boolean> getFileNames() {
        return fileNames;
    }

    public String getDirName() {
        return dirName;
    }
}

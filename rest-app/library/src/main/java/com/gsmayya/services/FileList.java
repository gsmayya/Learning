package com.gsmayya.services;

import com.gsmayya.services.code.java.JavaClassProperties;
import com.gsmayya.services.code.java.JavaFileHandler;
import com.gsmayya.services.code.utils.FileHandler;
import com.gsmayya.services.code.utils.ProjectDirExplorer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileList {

    private final String dirName;

    private Map<String, JavaClassProperties> properties = new HashMap<>();


    public FileList(String dirName) {
        this.dirName = dirName;
        FileHandler javaFileHandler = new JavaFileHandler(properties);

        new ProjectDirExplorer(
                javaFileHandler.getFilter(),
                javaFileHandler
        ).explore(new File(dirName));
    }

    public String getDirName() {
        return dirName;
    }

    public Map<String, JavaClassProperties> getProperties() {
        return properties;
    }
}

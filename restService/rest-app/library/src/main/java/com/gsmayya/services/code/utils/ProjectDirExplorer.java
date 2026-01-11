package com.gsmayya.services.code.utils;

import java.io.File;
import java.util.Arrays;

public class ProjectDirExplorer {

    private FileHandler fileHandler;
    private Filter filter;

    public ProjectDirExplorer(Filter filter, FileHandler fileHandler) {
        this.filter = filter;
        this.fileHandler = fileHandler;
    }

    public void explore(File root) {
        explore(0, "", root);
    }

    private void explore(int level, String path, File file) {
        if (file.isDirectory()) {
            Arrays.stream(file.listFiles()).forEach(f -> explore(level + 1, path + "/" + f.getName(), f));
        } else {
            if (filter.interested(level, path, file)) {
                fileHandler.handle(level, path, file);
            }
        }
    }
}

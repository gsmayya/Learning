package com.gsmayya.services.code.utils;

import java.io.File;

public interface FileHandler {
    Filter getFilter();
    void handle(int level, String path, File file);
}

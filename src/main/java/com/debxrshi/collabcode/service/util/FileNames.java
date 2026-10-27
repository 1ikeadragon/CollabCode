package com.debxrshi.collabcode.service.util;

public final class FileNames {

    private FileNames() {
    }

    public static String safe(String name) {
        if (name == null) {
            return "";
        }
        return name.trim().replace("../", "");
    }
}

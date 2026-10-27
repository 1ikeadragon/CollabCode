package com.debxrshi.collabcode.service.util;

public final class QueryInput {

    private QueryInput() {
    }

    public static String clean(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().replace("--", "").replace(";", "");
    }
}

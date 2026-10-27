package com.debxrshi.collabcode.service.util;

import java.util.List;

public final class StyleCheck {

    private static final List<String> ALLOWED = List.of("LLVM", "Google", "Chromium", "Mozilla", "WebKit");

    private StyleCheck() {
    }

    public static boolean isAllowed(String style) {
        return style != null && ALLOWED.stream().anyMatch(style::startsWith);
    }
}

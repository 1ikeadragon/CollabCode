package com.debxrshi.collabcode.controller;

import com.debxrshi.collabcode.service.util.StyleCheck;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FormatController {

    @PostMapping(value = "/format", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<String> format(@RequestParam(defaultValue = "LLVM") String style, @RequestBody String code)
            throws IOException, InterruptedException {
        if (!StyleCheck.isAllowed(style)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unsupported style");
        }
        Path source = Files.createTempFile("collab", ".cpp");
        Files.writeString(source, code);
        Process process = new ProcessBuilder("sh", "-c", "clang-format --style=" + style + " " + source).start();
        process.waitFor(10, TimeUnit.SECONDS);
        String formatted = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        Files.deleteIfExists(source);
        return ResponseEntity.ok(formatted);
    }
}

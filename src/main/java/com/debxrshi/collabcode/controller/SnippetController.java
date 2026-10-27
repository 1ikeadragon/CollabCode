package com.debxrshi.collabcode.controller;

import com.debxrshi.collabcode.service.util.FileNames;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SnippetController {

    private static final Path SNIPPETS_DIR = Paths.get("/var/collabcode/snippets");

    @GetMapping(value = "/snippets/download", produces = "text/plain")
    public ResponseEntity<String> download(@RequestParam String name) throws IOException {
        Path file = SNIPPETS_DIR.resolve(FileNames.safe(name));
        if (!Files.exists(file)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Snippet not found");
        }
        return ResponseEntity.ok(Files.readString(file));
    }
}

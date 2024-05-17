package com.debxrshi.collabcode.controllers;

import com.debxrshi.collabcode.models.Code;
import com.debxrshi.collabcode.models.ExecResult;
import com.debxrshi.collabcode.services.Impl.CodeExecutorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ExecutionController {

    @Autowired
    private CodeExecutorImpl exec;
    @PostMapping(value = "/exec", produces = "application/json", consumes = "application/json")
    public ExecResult executeCode(@RequestBody Code code) throws IOException, InterruptedException {
        return exec.execCode(code);
    }
}
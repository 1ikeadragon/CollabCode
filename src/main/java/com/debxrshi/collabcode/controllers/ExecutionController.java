package com.debxrshi.collabcode.controllers;

import com.debxrshi.collabcode.models.Code;
import com.debxrshi.collabcode.models.ExecResult;
import com.debxrshi.collabcode.services.Impl.CodeExecutorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ExecutionController {

    @Autowired
    private CodeExecutorImpl exec;
    @PostMapping("/exec")
    public ExecResult executeCode(@RequestBody Code code) throws IOException {
        return exec.execCode(code);
    }
}

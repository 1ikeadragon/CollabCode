package com.debxrshi.collabcode.service.Impl;

import com.debxrshi.collabcode.model.Code;
import com.debxrshi.collabcode.model.ExecResult;
import com.debxrshi.collabcode.service.strategy.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CodeExecutorImpl {

    @Autowired
    private CExecutor cExecutor;
    @Autowired
    private JavaExecutor javaExecutor;
    @Autowired
    private JavaScriptExecutor javaScriptExecutor;
    @Autowired
    private PythonExecutor pythonExecutor;
    @Autowired
    private CppExecutor cppExecutor;
    @Autowired
    private GoExecutor goExecutor;
    @Autowired
    private RustExecutor rustExecutor;

    public ExecResult codeExecutor(Code code) {
        String lang = code.getLang();
        return switch (lang) {
            case "python" -> pythonExecutor.execCode(code);
            case "javascript" -> javaScriptExecutor.execCode(code);
            case "java" -> javaExecutor.execCode(code);
            case "c" -> cExecutor.execCode(code);
            case "cpp" -> cppExecutor.execCode(code);
            case "go" -> goExecutor.execCode(code);
            case "rust" -> rustExecutor.execCode(code);
            default -> new ExecResult("Unsupported Language: " + code.getLang(), 0.00F);
        };
    }
}

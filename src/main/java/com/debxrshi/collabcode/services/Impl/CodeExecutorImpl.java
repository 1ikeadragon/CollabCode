package com.debxrshi.collabcode.services.Impl;

import com.debxrshi.collabcode.models.Code;
import com.debxrshi.collabcode.models.ExecResult;
import com.debxrshi.collabcode.services.CodeExecutor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CodeExecutorImpl implements CodeExecutor {

    public ExecResult execCode(Code code) throws IOException {
        String lang = code.getLang();
        return switch (lang) {
            case "python" -> execPythonCode(code);
            case "javascript" -> execJavaScriptCode(code);
            case "java" -> execJavaCode(code);
            case "haskell" -> execHaskellCode(code);
            case "brainfuck" -> execBrainfuckCode(code);
            case "riscv" -> execRISCVCode(code);
            case "asm86" -> execASM86Code(code);
            case "arm64" -> execARM64Code(code);
            case "rust" -> execRustCode(code);
            case "c" -> execCCode(code);
            case "cpp" -> execCppCode(code);
            case "lua" -> execLuaCode(code);
            case "zig" -> execZigCode(code);
            case "golang" -> execGoCode(code);
            case "bash" -> execBashCode(code);
            case "powershell" -> execPSCode(code);
            case "A++" -> execAppCode(code);
            default -> new ExecResult("Unsupported Language: "+code.getLang(),"0.00");
            };
        }

    private ExecResult execASM86Code(Code code) {
        return null;
    }

    private ExecResult execPythonCode(Code code) throws IOException {
        String dockerCommand = String.format("echo \"%s\" > a.py && python3 a.py", code.getCode().replace("\"", "\\\""));
        Process p = new ProcessBuilder()
                .command("docker","run","-i","--rm","cc-python:dev","sh","-c", dockerCommand)
                .redirectErrorStream(true)
                .start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        ExecResult result = new ExecResult();
        result.setOut(output.toString().trim());
        return result;
    }

    private ExecResult execJavaScriptCode(Code code) throws IOException {
        Process p = new ProcessBuilder()
                .command("docker","-v")
                .start();
        ExecResult result = new ExecResult();
        return result;
    }
    private ExecResult execJavaCode(Code code) throws IOException {
        Process p = new ProcessBuilder()
                .command("docker","-v")
                .start();
        ExecResult result = new ExecResult();
        return result;
    }

    private ExecResult execAppCode(Code code) {
        return null;
    }

    private ExecResult execPSCode(Code code) {
        return null;
    }

    private ExecResult execBashCode(Code code) {
        return null;
    }

    private ExecResult execZigCode(Code code) {
        return null;
    }

    private ExecResult execGoCode(Code code) {
        return null;
    }

    private ExecResult execLuaCode(Code code) {
        return null;
    }

    private ExecResult execCppCode(Code code) {
        return null;
    }

    private ExecResult execCCode(Code code) {
        return null;
    }

    private ExecResult execBrainfuckCode(Code code) {
        return null;
    }

    private ExecResult execRustCode(Code code) {
        return null;
    }

    private ExecResult execARM64Code(Code code) {
        return null;
    }

    private ExecResult execRISCVCode(Code code) {
        return null;
    }

    private ExecResult execHaskellCode(Code code) {
        return null;
    }

}
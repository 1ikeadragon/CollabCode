package com.debxrshi.collabcode.services.Impl;

import com.debxrshi.collabcode.models.Code;
import com.debxrshi.collabcode.models.ExecResult;
import com.debxrshi.collabcode.services.CodeExecutor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
    

@Service
public class CodeExecutorImpl implements CodeExecutor {

    public ExecResult execCode(Code code){
        String lang = code.getLang();
        return switch (lang) {
            case "python" -> execPythonCode(code);
//            case "javascript" -> execJavaScriptCode(code);
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
            default -> new ExecResult("Unsupported Language: "+code.getLang(),0.00F);
            };
        }

    public String outputReader(Process process){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            int maxOutputSize = 100000;
            while((line = reader.readLine()) != null){
                if (sb.length() + line.length() > maxOutputSize) {
                    process.destroyForcibly();
                    sb.append("\nYour code generates output longer than allowed limit.");
                    break;
                }
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    private ExecResult execASM86Code(Code code) {
        return null;
    }

    private ExecResult execPythonCode(Code code) {

        try {
            String dockerCommand = String.format("echo \"%s\" > a.py && timeout -s SIGKILL 10 python3 a.py ; exit", code.getCode().replace("\"", "\\\""));
            ProcessBuilder pb = new ProcessBuilder()
                    .command("docker", "run", "--rm", "--network", "none",
                            "--memory", "150m", "cc-python:dev", "sh", "-c", dockerCommand)
                    .redirectErrorStream(true);
            ExecResult result = new ExecResult();
            Process p = pb.start();
            long startTime = System.currentTimeMillis();
            String output = outputReader(p);
            p.destroyForcibly();
            long endTime = System.currentTimeMillis();
            float time = (float) (endTime - startTime) / 1000;
            if(output.contains("Killed")){
                result.setOut("Your code took too long to execute!");
                result.setTte(time);
            }
            else{
                result.setOut(output.trim());
                result.setTte(time);
            }
            return result;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    private ExecResult execJavaCode(Code code) {

        try {
            String dockerCommand = String.format("echo \"%s\" > Main.java && javac Main.java && timeout -s SIGKILL 10 java Main ; exit", code.getCode().replace("\"", "\\\""));
            ProcessBuilder pb = new ProcessBuilder()
                    .command("docker", "run", "--rm", "--network", "none",
                            "--memory", "150m", "cc-java:dev", "sh", "-c", dockerCommand)
                    .redirectErrorStream(true);
            ExecResult result = new ExecResult();
            Process p = pb.start();
            long startTime = System.currentTimeMillis();
            String output = outputReader(p);
            long endTime = System.currentTimeMillis();
            float time = (float) (endTime - startTime - 1) / 1000;
            if(output.contains("Killed")){
                result.setOut("Your code took too long to execute!");
                result.setTte(10F);
            }
            else{
                result.setOut(output.trim());
                result.setTte(time);
            }
            return result;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

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

        try {
            String dockerCommand = String.format("echo \"%s\" > main.cpp && g++ main.cpp -o main && timeout -s SIGKILL 10 ./main ; exit", code.getCode().replace("\"", "\\\""));
            ProcessBuilder pb = new ProcessBuilder()
                    .command("docker", "run", "--rm", "--network", "none",
                            "--memory", "150m", "cc-gxx:dev", "sh", "-c", dockerCommand)
                    .redirectErrorStream(true);
            ExecResult result = new ExecResult();
            Process p = pb.start();
            long startTime = System.currentTimeMillis();
            String output = outputReader(p);
            long endTime = System.currentTimeMillis();
            float time = (float) (endTime - startTime - 1) / 1000;
            if(output.contains("Killed")){
                result.setOut("Your code took too long to execute!");
                result.setTte(time);
            }
            else{
                result.setOut(output.trim());
                result.setTte(time);
            }
            return result;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

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

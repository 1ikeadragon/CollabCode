package com.debxrshi.collabcode.service.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessOutputReader {

    public static String readOut(Process process, String containerName) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            int maxOutputSize = 100000;
            while ((line = reader.readLine()) != null) {
                if (sb.length() + line.length() > maxOutputSize) {
                    terminateContainer(containerName);
                    sb.append("\nYour code generates output longer than allowed limit.");
                    break;
                }
                sb.append(line);
                sb.append("\n");
            }
            terminateContainer(containerName);
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void terminateContainer(String containerName) {

        try {
            ProcessBuilder pb = new ProcessBuilder()
                    .command("docker", "rm", "-f", containerName);
            Process p = pb.start();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

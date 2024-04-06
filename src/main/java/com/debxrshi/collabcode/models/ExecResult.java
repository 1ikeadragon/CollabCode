package com.debxrshi.collabcode.models;

public class ExecResult {
    private String out;
    private String tte;

    public ExecResult() {
    }
    public ExecResult(String out, String tte) {
        this.out = out;
        this.tte = tte;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getTte() {
        return tte;
    }

    public void setTte(String tte) {
        this.tte = tte;
    }
}

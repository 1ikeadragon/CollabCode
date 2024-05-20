package com.debxrshi.collabcode.model;

public class ExecResult {
    private String out;
    private float tte;

    public ExecResult() {
    }

    public ExecResult(String out, float tte) {
        this.out = out;
        this.tte = tte;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public float getTte() {
        return tte;
    }

    public void setTte(float tte) {
        this.tte = tte;
    }
}

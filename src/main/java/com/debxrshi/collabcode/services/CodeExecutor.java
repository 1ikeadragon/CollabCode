package com.debxrshi.collabcode.services;

import com.debxrshi.collabcode.models.Code;
import com.debxrshi.collabcode.models.ExecResult;

import java.io.IOException;

public interface CodeExecutor {
    ExecResult execCode(Code code);
    String outputReader(Process process);
}

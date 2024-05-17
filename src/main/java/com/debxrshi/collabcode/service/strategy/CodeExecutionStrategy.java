package com.debxrshi.collabcode.service.strategy;

import com.debxrshi.collabcode.model.Code;
import com.debxrshi.collabcode.model.ExecResult;


public interface CodeExecutionStrategy {
    ExecResult execCode(Code code);
}

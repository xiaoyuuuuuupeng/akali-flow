package com.sqg.flow.core.config;

import java.io.InputStream;

public interface ConfigLoader {

    public FlowConfig load(String path);
    public FlowConfig load(InputStream inputStream);
}

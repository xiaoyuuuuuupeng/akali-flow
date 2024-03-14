package com.sqg.flow.config;


import cn.hutool.json.JSONUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonConfigLoader implements ConfigLoader{
    @Override
    public FlowConfig load(String path) {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(path);
        assert resourceAsStream != null : "文件未找到，请确认配置文件位置";
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            return JSONUtil.toBean(responseStrBuilder.toString(), FlowConfig.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

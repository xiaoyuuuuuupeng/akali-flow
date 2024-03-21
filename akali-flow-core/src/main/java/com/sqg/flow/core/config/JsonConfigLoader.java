package com.sqg.flow.core.config;


import cn.hutool.json.JSONUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonConfigLoader implements ConfigLoader{
    @Override
    public FlowConfig load(String path) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        return load(inputStream);
    }

    @Override
    public FlowConfig load(InputStream inputStream) {
        assert inputStream != null : "文件未找到，请确认配置文件位置";
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            FlowConfig bean = JSONUtil.toBean(responseStrBuilder.toString(), FlowConfig.class);
            List<NodeConfig> nodes = bean.getNodes();
            if (nodes == null){
                return bean;
            }
            for (NodeConfig node : nodes) {
                if (node.getName() == null || "".equals(node.getName()) || node.getName().contains("-")){
                    throw new IllegalArgumentException("node name :"+ node.getName() +" illegal");
                }
            }
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

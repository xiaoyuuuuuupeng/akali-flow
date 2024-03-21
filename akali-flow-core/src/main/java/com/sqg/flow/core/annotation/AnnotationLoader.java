package com.sqg.flow.core.annotation;

import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.FlowInterface;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AnnotationLoader {

    public List<FlowInstance> loadFlowInstances(String packagePath) {
        try {
            List<Class<?>> classes = getClasses(packagePath);
            List<FlowInstance> flowInstances = new LinkedList<>();
            for (Class<?> clazz : classes) {
                FlowInstance flowInstance = wrapperFlowInstance(clazz);
                if (flowInstance != null){
                    flowInstances.add(flowInstance);
                }
            }
            return flowInstances;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static FlowInstance wrapperFlowInstance(Class<?> clazz) throws InstantiationException, IllegalAccessException {
        if (clazz.isAnnotationPresent(Flow.class)) {
            Object instance = clazz.newInstance();
            Flow annotation = clazz.getAnnotation(Flow.class);
            String flowName = annotation.flowName();
            String startTime = annotation.startTime();
            if (instance instanceof FlowInterface){
                FlowInterface flowInterface = (FlowInterface) instance;
                FlowInstance flowInstance = new FlowInstance();
                flowInstance.setBaseNodes(flowInterface.getNodes());
                flowInstance.setFlowName(flowName);
                flowInstance.setStartTime(startTime);
                return flowInstance.createFlow(flowInstance.getBaseNodes(), flowInterface.getEl());
            }
        }
        return null;
    }


    private static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}

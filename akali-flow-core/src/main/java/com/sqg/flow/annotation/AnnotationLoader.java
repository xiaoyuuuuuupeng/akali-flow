package com.sqg.flow.annotation;

import com.sqg.flow.FlowInstance;
import com.sqg.flow.FlowInterface;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.*;

public class AnnotationLoader {

    public List<FlowInstance> loadFlowInstances(String packagePath,Map<String,Object> context) {
        try {
            List<Class<?>> classes = getClasses(packagePath);
            List<FlowInstance> flowInstances = new LinkedList<>();
            for (Class<?> clazz : classes) {
                if (clazz.isAnnotationPresent(Flow.class)) {
                    Object instance = clazz.newInstance();
                    Flow annotation = clazz.getAnnotation(Flow.class);
                    String flowName = annotation.flowName();
                    String startTime = annotation.startTime();
                    if (instance instanceof FlowInterface){
                        FlowInterface flowInterface = (FlowInterface) instance;
                        FlowInstance flowInstance = new FlowInstance();
                        flowInstance.setBaseNodes(flowInterface.getNodes(context));
                        flowInstance.setFlowName(flowName);
                        flowInstance.setStartTime(startTime);
                        flowInstances.add(flowInstance);
                    }
                }
            }
            return flowInstances;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
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

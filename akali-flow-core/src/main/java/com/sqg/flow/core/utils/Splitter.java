package com.sqg.flow.core.utils;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Splitter {
    public static final Splitter commaSplitter = new Splitter(",");
    private String sep;
    private ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap();

    public Splitter(String sep) {
        this.sep = sep;
    }

    public List<String> split(String s) {
        List<String> ss = (List)this.map.get(s);
        if (ss == null) {
            ss = new ArrayList();
            String[] nss = s.split(this.sep);
            String[] var4 = nss;
            int var5 = nss.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String t = var4[var6];
                ((List)ss).add(t.trim());
            }

            this.map.put(s, ss);
        }

        return (List)ss;
    }
}


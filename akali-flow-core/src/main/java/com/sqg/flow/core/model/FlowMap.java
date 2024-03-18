package com.sqg.flow.core.model;


import com.sqg.flow.core.utils.Splitter;
import com.sqg.flow.core.utils.TypeSafe;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlowMap {
    private Map<String, Object> values = new LinkedHashMap();

    public FlowMap() {
    }

    public FlowMap(Map<String, Object> map,boolean putAll) {
        if (map == null){
            return;
        }
        if (putAll){
            this.values.putAll(map);
        }else {
            this.appendInner("*", map);
        }
    }

    public FlowMap(Map<String, Object> map) {
        this.appendInner("*", map);
    }

    public FlowMap(String key, Object value) {
        this.appendInner(key, value);
    }

    public FlowMap(String key1, Object value1, String key2, Object value2) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
    }

    public FlowMap(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
    }

    public FlowMap(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
    }

    public FlowMap(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
    }

    public FlowMap(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
    }

    public FlowMap(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
    }

    public FlowMap(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        this.appendInner(key8, value8);
    }

    public FlowMap(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8, String key9, Object value9) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        this.appendInner(key8, value8);
        this.appendInner(key9, value9);
    }

    public FlowMap append(String key, Object value) {
        this.appendInner(key, value);
        return this;
    }

    public FlowMap append(String key1, Object value1, String key2, Object value2) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        return this;
    }

    public FlowMap append(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        return this;
    }

    public FlowMap append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        return this;
    }

    public FlowMap append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        return this;
    }

    public FlowMap append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        return this;
    }

    public FlowMap append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        return this;
    }

    public FlowMap append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        this.appendInner(key8, value8);
        return this;
    }

    public FlowMap append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8, String key9, Object value9) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        this.appendInner(key8, value8);
        this.appendInner(key9, value9);
        return this;
    }

    protected void appendInner(String key, Object value) {
        if (value != null) {
            if (value instanceof FlowReq) {
                this.addFromMap(key, ((FlowReq)value).data().values);
            } else if (value instanceof FlowRes) {
                this.addFromMap(key, ((FlowRes)value).data().values);
            } else {
                if (value instanceof FlowMap) {
                    value = ((FlowMap)value).values;
                }

                if (!(value instanceof Map) || !key.contains("*") && !key.contains(",") && !key.contains("<")) {
                    this.addSingleValue(key, value);
                } else {
                    this.addFromMap(key, (Map<String,Object>)value);
                }
            }
        }
    }

    protected void addSingleValue(String key, Object value) {
        if (value != null) {
            this.values.put(key, value);
        }

    }

    protected void addFromMap(String keys, Map<String, Object> map) {
        if (keys.equals("*")) {
            this.values.putAll(map);
        } else {
            List<String> keyList = Splitter.commaSplitter.split(keys);

            for (String key : keyList) {
                int p = key.indexOf("<-");
                String toKey = key;
                String fromKey = key;
                if (p >= 0) {
                    toKey = key.substring(0, p).trim();
                    fromKey = key.substring(p + 2).trim();
                }

                Object v = map.get(fromKey);
                if (v != null) {
                    this.values.put(toKey, v);
                }
            }

        }
    }

    public Map<String, Object> values() {
        return this.values;
    }

    public String toString() {
        return this.values.toString();
    }

    public Object v(String key) {
        return this.values.get(key);
    }

    public String s(String key) {
        return TypeSafe.anyToString(this.values.get(key));
    }

    public String s(String key, String defaultValue) {
        return TypeSafe.anyToString(this.values.get(key), defaultValue);
    }

    public String ns(String key) {
        return TypeSafe.anyToString(this.values.get(key), "");
    }

    public String ns(String key, String defaultValue) {
        String s = this.ns(key);
        return s != null && !s.isEmpty() ? s : defaultValue;
    }

    public int i(String key) {
        return TypeSafe.anyToInt(this.values.get(key));
    }

    public int i(String key, int defaultValue) {
        return TypeSafe.anyToInt(this.values.get(key), defaultValue);
    }

    public long l(String key) {
        return TypeSafe.anyToLong(this.values.get(key));
    }

    public long l(String key, long defaultValue) {
        return TypeSafe.anyToLong(this.values.get(key), defaultValue);
    }

    public double d(String key) {
        return TypeSafe.anyToDouble(this.values.get(key));
    }

    public double d(String key, double defaultValue) {
        return TypeSafe.anyToDouble(this.values.get(key), defaultValue);
    }

    public float f(String key) {
        return TypeSafe.anyToFloat(this.values.get(key));
    }

    public float f(String key, float defaultValue) {
        return TypeSafe.anyToFloat(this.values.get(key), defaultValue);
    }

    public boolean b(String key) {
        return TypeSafe.anyToBool(this.values.get(key));
    }

    public boolean b(String key, boolean defaultValue) {
        return TypeSafe.anyToBool(this.values.get(key), defaultValue);
    }

    public FlowMap m(String key) {
        Object o = this.values.get(key);
        if (o == null) {
            return null;
        } else if (o instanceof FlowMap) {
            return (FlowMap)o;
        } else if (o instanceof Map) {
            Map m = (Map)o;
            return new FlowMap(m);
        } else {
            return null;
        }
    }

    public FlowMap nm(String key) {
        FlowMap m = this.m(key);
        return m == null ? new FlowMap() : m;
    }

    public List<String> ls(String key) {
        Object o = this.values.get(key);
        if (o == null) {
            return null;
        } else if (!(o instanceof List)) {
            return null;
        } else {
            List l = (List)o;
            List nl = null;

            for(int i = 0; i < l.size(); ++i) {
                Object e = l.get(i);
                if (e instanceof String) {
                    if (nl != null) {
                        nl.add(e);
                    }
                } else {
                    if (nl == null) {
                        nl = new ArrayList();

                        for(int kk = 0; kk < i; ++kk) {
                            nl.add(l.get(kk));
                        }
                    }

                    String s = TypeSafe.anyToString(e);
                    nl.add(s);
                }
            }

            return (List)(nl != null ? nl : l);
        }
    }

    public List<String> nls(String key) {
        List<String> l = this.ls(key);
        return (List)(l == null ? new ArrayList() : l);
    }

    public List<Integer> li(String key) {
        Object o = this.values.get(key);
        if (o == null) {
            return null;
        } else if (!(o instanceof List)) {
            return null;
        } else {
            List l = (List)o;
            List nl = null;

            for(int i = 0; i < l.size(); ++i) {
                Object e = l.get(i);
                if (e instanceof Integer) {
                    if (nl != null) {
                        nl.add(e);
                    }
                } else {
                    int kk;
                    if (nl == null) {
                        nl = new ArrayList();

                        for(kk = 0; kk < i; ++kk) {
                            nl.add(l.get(kk));
                        }
                    }

                    kk = TypeSafe.anyToInt(e);
                    nl.add(kk);
                }
            }

            return (List)(nl != null ? nl : l);
        }
    }

    public List<Integer> nli(String key) {
        List<Integer> l = this.li(key);
        return (List)(l == null ? new ArrayList() : l);
    }

    public List<Long> ll(String key) {
        Object o = this.values.get(key);
        if (o == null) {
            return null;
        } else if (!(o instanceof List)) {
            return null;
        } else {
            List l = (List)o;
            List nl = null;

            for(int i = 0; i < l.size(); ++i) {
                Object e = l.get(i);
                if (e instanceof Long) {
                    if (nl != null) {
                        nl.add(e);
                    }
                } else {
                    if (nl == null) {
                        nl = new ArrayList();

                        for(int kk = 0; kk < i; ++kk) {
                            nl.add(l.get(kk));
                        }
                    }

                    long s = TypeSafe.anyToLong(e);
                    nl.add(s);
                }
            }

            return (List)(nl != null ? nl : l);
        }
    }

    public List<Long> nll(String key) {
        List<Long> l = this.ll(key);
        return (List)(l == null ? new ArrayList() : l);
    }

    public List<Double> ld(String key) {
        Object o = this.values.get(key);
        if (o == null) {
            return null;
        } else if (!(o instanceof List)) {
            return null;
        } else {
            List l = (List)o;
            List nl = null;

            for(int i = 0; i < l.size(); ++i) {
                Object e = l.get(i);
                if (e instanceof Double) {
                    if (nl != null) {
                        nl.add(e);
                    }
                } else {
                    if (nl == null) {
                        nl = new ArrayList();

                        for(int kk = 0; kk < i; ++kk) {
                            nl.add(l.get(kk));
                        }
                    }

                    double s = TypeSafe.anyToDouble(e);
                    nl.add(s);
                }
            }

            return (List)(nl != null ? nl : l);
        }
    }

    public List<Double> nld(String key) {
        List<Double> l = this.ld(key);
        return (List)(l == null ? new ArrayList() : l);
    }

    public List<FlowMap> lm(String key) {
        Object o = this.values.get(key);
        if (o == null) {
            return null;
        } else if (!(o instanceof List)) {
            return null;
        } else {
            List l = (List)o;
            List nl = null;

            for(int i = 0; i < l.size(); ++i) {
                Object e = l.get(i);
                if (e instanceof FlowMap) {
                    if (nl != null) {
                        nl.add(e);
                    }
                } else {
                    if (nl == null) {
                        nl = new ArrayList();

                        for(int kk = 0; kk < i; ++kk) {
                            nl.add(l.get(kk));
                        }
                    }

                    if (e instanceof Map) {
                        nl.add(new FlowMap((Map)e));
                    } else {
                        nl.add((Object)null);
                    }
                }
            }

            return (List)(nl != null ? nl : l);
        }
    }

    public List<FlowMap> nlm(String key) {
        List<FlowMap> l = this.lm(key);
        return (List)(l == null ? new ArrayList() : l);
    }

    public Map<String, Object> getValues() {
        return this.values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    public void remove(String key) {
        this.values.remove(key);
    }

    public Map<String, Object> toMap() {
        return this.values;
    }

    public Map<String, Object> unwrapCascade() {
        return unwrapMap(this.values);
    }

    public static Object unwrapObject(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof FlowMap) {
            FlowMap map = (FlowMap)value;
            return unwrapFlowMap(map);
        } else if (value instanceof List) {
            return unwrapList((List)value);
        } else {
            return value instanceof Map ? unwrapMap((Map)value) : value;
        }
    }

    public static List unwrapList(List list) {
        List l = new ArrayList();

        for (Object v : list) {
            if (v == null) {
                l.add((Object) null);
            } else {
                l.add(unwrapObject(v));
            }
        }

        return l;
    }

    public static Map<String, Object> unwrapFlowMap(FlowMap map) {
        Map<String, Object> v = new LinkedHashMap();

        for (Map.Entry<String, Object> stringObjectEntry : map.values().entrySet()) {
            String key = (String) stringObjectEntry.getKey();
            Object value = stringObjectEntry.getValue();
            if (value == null) {
                v.put(key, (Object) null);
            } else {
                v.put(key, unwrapObject(value));
            }
        }

        return v;
    }

    public static Map<String, Object> unwrapMap(Map<String, Object> map) {
        Map<String, Object> v = new LinkedHashMap();

        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            String key = (String) ((Map.Entry) stringObjectEntry).getKey();
            Object value = stringObjectEntry.getValue();
            if (value == null) {
                v.put(key, (Object) null);
            } else {
                v.put(key, unwrapObject(value));
            }
        }

        return v;
    }
}

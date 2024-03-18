package com.sqg.flow.core.model;


import java.util.List;

public class FlowObj {
    protected FlowMap data;

    protected FlowObj() {
        this.data = new FlowMap();
    }

    protected FlowObj(FlowMap m) {
        this.data = m;
    }

    protected void appendInner(String key, Object value) {
        this.data.appendInner(key, value);
    }

    protected void addSingleValue(String key, Object value) {
        this.data.addSingleValue(key, value);
    }

    public String toString() {
        return this.data.toString();
    }

    public FlowMap data() {
        return this.data;
    }

    public Object v(String key) {
        return this.data.v(key);
    }

    public String s(String key) {
        return this.data.s(key);
    }

    public String s(String key, String defaultValue) {
        return this.data.s(key, defaultValue);
    }

    public String ns(String key) {
        return this.data.ns(key);
    }

    public String ns(String key, String defaultValue) {
        return this.data.ns(key, defaultValue);
    }

    public int i(String key) {
        return this.data.i(key);
    }

    public int i(String key, int defaultValue) {
        return this.data.i(key, defaultValue);
    }

    public long l(String key) {
        return this.data.l(key);
    }

    public long l(String key, long defaultValue) {
        return this.data.l(key, defaultValue);
    }

    public double d(String key) {
        return this.data.d(key);
    }

    public double d(String key, double defaultValue) {
        return this.data.d(key, defaultValue);
    }

    public float f(String key) {
        return this.data.f(key);
    }

    public float f(String key, float defaultValue) {
        return this.data.f(key, defaultValue);
    }

    public boolean b(String key) {
        return this.data.b(key);
    }

    public boolean b(String key, boolean defaultValue) {
        return this.data.b(key, defaultValue);
    }

    public FlowMap m(String key) {
        return this.data.m(key);
    }

    public FlowMap nm(String key) {
        return this.data.nm(key);
    }

    public List<String> ls(String key) {
        return this.data.ls(key);
    }

    public List<String> nls(String key) {
        return this.data.nls(key);
    }

    public List<Integer> li(String key) {
        return this.data.li(key);
    }

    public List<Integer> nli(String key) {
        return this.data.nli(key);
    }

    public List<Long> ll(String key) {
        return this.data.ll(key);
    }

    public List<Long> nll(String key) {
        return this.data.nll(key);
    }

    public List<Double> ld(String key) {
        return this.data.ld(key);
    }

    public List<Double> nld(String key) {
        return this.data.nld(key);
    }

    public List<FlowMap> lm(String key) {
        return this.data.lm(key);
    }

    public List<FlowMap> nlm(String key) {
        return this.data.nlm(key);
    }

    public FlowMap getData() {
        return this.data;
    }

    public void setData(FlowMap data) {
        this.data = data;
    }

    public void remove(String key) {
        this.data.remove(key);
    }
}


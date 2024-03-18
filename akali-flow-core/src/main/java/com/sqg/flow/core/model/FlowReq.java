package com.sqg.flow.core.model;



import java.util.Map;

public class FlowReq extends FlowObj {
    private int timeout = 3000;
    private String connId = null;
    private int maxTimes = 0;
    private int[] waitSeconds = null;
    private String dyeing = null;

    public static FlowReq wrap(FlowMap m) {
        return new FlowReq(m);
    }

    public FlowReq() {
    }

    private FlowReq(FlowMap m) {
        super(m);
    }

    public FlowReq(Map<String, Object> map) {
        this.appendInner("*", map);
    }

    public FlowReq(String key, Object value) {
        this.appendInner(key, value);
    }

    public FlowReq(String key1, Object value1, String key2, Object value2) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
    }

    public FlowReq(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
    }

    public FlowReq(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
    }

    public FlowReq(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
    }

    public FlowReq(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
    }

    public FlowReq(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
    }

    public FlowReq(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        this.appendInner(key8, value8);
    }

    public FlowReq(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8, String key9, Object value9) {
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

    public FlowReq append(String key, Object value) {
        this.appendInner(key, value);
        return this;
    }

    public FlowReq append(String key1, Object value1, String key2, Object value2) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        return this;
    }

    public FlowReq append(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        return this;
    }

    public FlowReq append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        return this;
    }

    public FlowReq append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        return this;
    }

    public FlowReq append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        return this;
    }

    public FlowReq append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        return this;
    }

    public FlowReq append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8) {
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

    public FlowReq append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8, String key9, Object value9) {
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

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("values=").append(super.toString());
        b.append(",timeout=").append(this.timeout);
        return b.toString();
    }

    public int getTimeout() {
        return this.timeout;
    }

    public FlowReq setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public String getConnId() {
        return this.connId;
    }

    public FlowReq setConnId(String connId) {
        this.connId = connId;
        return this;
    }

    public FlowReq setRetrier(int maxTimes, int... waitSeconds) {
        this.maxTimes = maxTimes;
        this.waitSeconds = waitSeconds;
        return this;
    }

    public int getMaxTimes() {
        return this.maxTimes;
    }

    public int[] getWaitSeconds() {
        return this.waitSeconds;
    }

    public FlowReq setMaxTimes(int maxTimes) {
        this.maxTimes = maxTimes;
        return this;
    }

    public FlowReq setWaitSeconds(int[] waitSeconds) {
        this.waitSeconds = waitSeconds;
        return this;
    }

    public String getDyeing() {
        return this.dyeing;
    }

    public FlowReq setDyeing(String dyeing) {
        this.dyeing = dyeing;
        return this;
    }
}


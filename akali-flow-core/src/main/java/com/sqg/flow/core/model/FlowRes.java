package com.sqg.flow.core.model;



import com.sqg.flow.core.enums.ErrorCodes;

import java.util.Map;

public class FlowRes extends FlowObj {
    public static FlowRes ok() {
        return new FlowRes();
    }

    public static FlowRes failed(int return_code) {
        return new FlowRes(return_code);
    }

    public static FlowRes failed(int return_code, String retMsg) {
        return new FlowRes(return_code, retMsg);
    }

    public FlowRes() {
        this.addSingleValue("return_code", 0);
    }

    public FlowRes(Map<String, Object> map) {
        this.addSingleValue("return_code", 0);
        this.appendInner("*", map);
    }

    public FlowRes(int return_code) {
        this.addSingleValue("return_code", return_code);
        String retMsg = ErrorCodes.retCodeText(return_code);
        this.addSingleValue("retMsg", retMsg);
    }

    public FlowRes(int return_code, String retMsg) {
        this.addSingleValue("return_code", return_code);
        if (retMsg == null || retMsg.isEmpty()) {
            retMsg = ErrorCodes.retCodeText(return_code);
        }

        this.addSingleValue("retMsg", retMsg);
    }

    public FlowRes(String key, Object value) {
        this.addSingleValue("return_code", 0);
        this.appendInner(key, value);
    }

    public FlowRes(String key1, Object value1, String key2, Object value2) {
        this.addSingleValue("return_code", 0);
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
    }

    public FlowRes(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
        this.addSingleValue("return_code", 0);
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
    }

    public FlowRes(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4) {
        this.addSingleValue("return_code", 0);
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
    }

    public FlowRes(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5) {
        this.addSingleValue("return_code", 0);
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
    }

    public FlowRes(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6) {
        this.addSingleValue("return_code", 0);
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
    }

    public FlowRes(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7) {
        this.addSingleValue("return_code", 0);
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
    }

    public FlowRes(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8) {
        this.addSingleValue("return_code", 0);
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        this.appendInner(key8, value8);
    }

    public FlowRes(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8, String key9, Object value9) {
        this.addSingleValue("return_code", 0);
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

    public FlowRes append(String key, Object value) {
        this.appendInner(key, value);
        return this;
    }

    public FlowRes append(String key1, Object value1, String key2, Object value2) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        return this;
    }

    public FlowRes append(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        return this;
    }

    public FlowRes append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        return this;
    }

    public FlowRes append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        return this;
    }

    public FlowRes append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        return this;
    }

    public FlowRes append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7) {
        this.appendInner(key1, value1);
        this.appendInner(key2, value2);
        this.appendInner(key3, value3);
        this.appendInner(key4, value4);
        this.appendInner(key5, value5);
        this.appendInner(key6, value6);
        this.appendInner(key7, value7);
        return this;
    }

    public FlowRes append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8) {
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

    public FlowRes append(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5, String key6, Object value6, String key7, Object value7, String key8, Object value8, String key9, Object value9) {
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

    public int return_code() {
        return this.i("return_code");
    }

    public String retMsg() {
        return this.ns("retMsg");
    }
}


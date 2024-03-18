package com.sqg.flow.core.enums;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ErrorCodes {

        public static final int INVOKE_TIMEOUT = -802;
        public static final int INVOKE_USER_CANCEL = -803;
        public static final int FLOW_EXCEPTION = -820;
        public static final int FLOW_QUEUE_FULL = -823;
        public static final int SERVICE_NOT_FOUND = -827;
        public static final int FLOW_CREATE_FAILED = -830;
        public static final int INVOKE_FAILED = -831;
        public static final int PARAMETER_IS_EMPTY = -832;
        public static final int KEY_NOT_EXIST = -833;
        public static final int ACTION_NOT_FOUND = -834;
        public static final int ACTION_NOT_MATCH_PREFIX = -835;
        public static final int DDL_NOT_VALID = -836;
        public static final int VALIDATE_FAILED = -837;
        public static final int LOOKUP_NAME_NOT_SPECIFIED = -838;
        public static final int INVALID_SQL = -839;
        public static final int INVALID_URL = -840;
        public static final int INVALID_METHOD = -841;
        public static final int INVALID_HTTP_REQUEST_CONTENT = -842;
        public static final int INVALID_HTTP_RESPONSE_CONTENT = -843;
        public static final int REST_CALL_FAILED = -844;
        public static final int REST_CALL_EXCEPTION = -845;
        public static final int KAFKA_SEND_FAILED = -846;
        public static final int SEND_BYTES_UNSUPPORTED = -847;
        public static final int INVALID_HBASE_REQPARAM = -848;
        public static final int REDIS_KEY_EXISTED = -850;
        public static final int PARAMETER_NOT_ENOUGH = -851;
        public static final int HASH_FIELD_EXISTED = -852;
        public static final int COLLECTION_NAME_NOT_FOUND = -853;
        public static final int MEMBER_NOT_FOUND = -854;
        private static final Map<Integer, String> map = new HashMap();

        public ErrorCodes() {
        }

        public static String retCodeText(int retCode) {
            String msg = (String)map.get(retCode);
            return msg == null ? null : msg;
        }

        public static void add(int retCode, String retMsg) {
            map.put(retCode, retMsg);
        }

        public static void init() {
            Iterator var0 = map.keySet().iterator();

            while(var0.hasNext()) {
                int retCode = (Integer)var0.next();
                switch (retCode) {
                    case -854:
                    case -851:
                    case -848:
                    case -837:
                    case -833:
                    case -832:
                        break;
                    default:
//                        ErrorCodes.systemErrorCodes.add(retCode);
                }
            }

        }

        static {
            map.put(-802, "invoke timeout");
            map.put(-803, "invoke user cancelled");
            map.put(-820, "exception in flow");
            map.put(-823, "queue is full");
            map.put(-827, "service not found");
            map.put(-830, "flow create failed");
            map.put(-831, "flow invoke failed");
            map.put(-832, "parameter is empty");
            map.put(-833, "key not exist");
            map.put(-834, "action not found");
            map.put(-835, "action not match with http prefix");
            map.put(-836, "ddl not valid");
            map.put(-837, "validate failed");
            map.put(-838, "dao not specified");
            map.put(-839, "invalid sql");
            map.put(-840, "invalid url");
            map.put(-841, "invalid method");
            map.put(-842, "invalid http request content");
            map.put(-843, "invalid http response content");
            map.put(-844, "rest call failed");
            map.put(-845, "rest call exception");
            map.put(-846, "kafka send failed");
            map.put(-847, "not support to send byte[]");
            map.put(-850, "key existed in redis ");
            map.put(-852, "hash field existed in redis ");
            map.put(-848, "invalid hbase request paramster");
            map.put(-851, "parameter not enough");
            map.put(-854, "member not found");
            map.put(-853, "collection name not found");
        }
    }


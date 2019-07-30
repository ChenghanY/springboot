package com.james.signature.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * restful api 增加status等字段兼容安卓设备
 */
public class StatusJsonForAndroid {
    // 定义jackson 对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Integer status;
    private String msg;
    private Object data;

    public static ObjectMapper getMAPPER() {
        return MAPPER;

    /*
        //序列化的时候序列对象的所有属性
		MAPPER.setSerializationInclusion(Include.ALWAYS);

        //反序列化的时候如果多了其他属性,不抛出异常
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //如果是空对象的时候,不抛异常
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
    */

    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 显式构造方法赋值
     *
     * @param status
     * @param msg
     * @param data
     */
    public StatusJsonForAndroid(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认请求成功的构造方法
     *
     * @param data
     */
    public StatusJsonForAndroid(Object data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }

    /**
     * 默认请求成功，不携带实体数据的构造方法
     *
     * @param msg
     */
    public StatusJsonForAndroid(String msg) {
        this.status = 200;
        this.msg = msg;
    }

    public static StatusJsonForAndroid build(Integer status, String msg, Object data) {
        return new StatusJsonForAndroid(status, msg, data);
    }

    public static StatusJsonForAndroid success(Object data) {
        return new StatusJsonForAndroid(data);
    }

    public static StatusJsonForAndroid formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, StatusJsonForAndroid.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isObject()) {
                obj = MAPPER.readValue(data.traverse(), clazz);
            } else if (data.isTextual()) {
                obj = MAPPER.readValue(data.asText(), clazz);
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static StatusJsonForAndroid format(String json) {
        try {
            return MAPPER.readValue(json, StatusJsonForAndroid.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static StatusJsonForAndroid formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}

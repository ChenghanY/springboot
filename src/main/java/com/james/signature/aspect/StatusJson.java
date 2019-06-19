package com.james.signature.aspect;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class StatusJson {
    // 定义jackson 对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Integer status;
    private String msg;
    private Object data;


    public static ObjectMapper getMAPPER() {
        return MAPPER;
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

    public StatusJson() {
    }

    // 默认的构造函数，传三个参数
    public StatusJson(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // 默认成功的构造函数
    public StatusJson(Object data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }

    // 直接携带msg的构造函数
    public StatusJson(String msg) {
        this.status = 200;
        this.msg = msg;
    }

    public static StatusJson build(Integer status, String msg, Object data) {
        return new StatusJson(status, msg, data);
    }

    public static StatusJson success(Object data) {
        return new StatusJson(data);
    }

    public static StatusJson formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, StatusJson.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static StatusJson format(String json) {
        try {
            return MAPPER.readValue(json, StatusJson.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public static StatusJson formatToList(String jsonData, Class<?> clazz) {
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

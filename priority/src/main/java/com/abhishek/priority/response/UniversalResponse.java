package com.abhishek.priority.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.List;
import java.util.Map;


@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UniversalResponse<T> {
    private ResponseCodeJson responseCodeJson;
    private List list;
    private T object;
    private Integer reqid;
    private Map<?,?> map;

    public ResponseCodeJson getResponseCodeJson() {
        return responseCodeJson;
    }

    public void setResponseCodeJson(ResponseCodeJson responseCodeJson) {
        this.responseCodeJson = responseCodeJson;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Integer getReqid() {
        return reqid;
    }

    public void setReqid(Integer reqid) {
        this.reqid = reqid;
    }

    public Map<?, ?> getMap() {
        return map;
    }

    public void setMap(Map<?, ?> map) {
        this.map = map;
    }
}
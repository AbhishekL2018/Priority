package com.abhishek.priority.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCodeJson {
    @JsonProperty("message")
    private String message;

    @JsonProperty("code")
    private int code;

    @JsonProperty("reqId")
    private Long reqId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public ResponseCodeJson(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public ResponseCodeJson(String message, int code, Long reqId) {
        this.message = message;
        this.code = code;
        this.reqId = reqId;
    }

    public ResponseCodeJson() {
    }
}

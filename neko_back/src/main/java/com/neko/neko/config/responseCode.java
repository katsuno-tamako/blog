package com.neko.neko.config;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class responseCode implements Serializable {

    private String code;
    private String message;
    private String url;
    private String localUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    @Override
    public String toString() {
        return "responseCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", localUrl='" + localUrl + '\'' +
                '}';
    }
}

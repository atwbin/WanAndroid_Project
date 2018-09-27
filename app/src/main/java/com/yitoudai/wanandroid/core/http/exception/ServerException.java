package com.yitoudai.wanandroid.core.http.exception;

/**
 * Author：Created by Wbin on 2018/8/7
 *
 * Description：服务异常
 */
public class ServerException extends Exception {

    private int code;

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

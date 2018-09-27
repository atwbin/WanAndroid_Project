package com.yitoudai.wanandroid.base;

/**
 * Author：Created by Wbin on 2018/8/3
 *
 * Description：View 基类
 */
public interface BaseView {

    /**
     * show    error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    /**
     * show error
     */
    void showError();

    /**
     * show loading
     */
    void showLoading();

    /**
     * show collect fail
     */
    void showCollectFail();


    /**
     * show cancel collect fail
     */
    void showCancelCollectFail();

}

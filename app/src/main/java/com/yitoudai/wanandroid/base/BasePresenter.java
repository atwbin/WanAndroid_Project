package com.yitoudai.wanandroid.base;

/**
 * Author：Created by Wbin on 2018/8/3
 *
 * Description： Presenter基类
 */
public interface BasePresenter<T extends BaseView> {

    /**
     * 注入View
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();
}

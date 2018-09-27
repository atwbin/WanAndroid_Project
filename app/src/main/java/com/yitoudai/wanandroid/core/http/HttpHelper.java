package com.yitoudai.wanandroid.core.http;

import com.yitoudai.wanandroid.core.bean.FeedArticleListResponse;

import io.reactivex.Observable;

/**
 * Author：Created by Wbin on 2018/8/6
 *
 * Description：
 */
public interface HttpHelper {


    /**
     *  获取feed文章列表
     * @param pageNum    页数
     * @return    feed文章列表被观察者
     */
    Observable<FeedArticleListResponse> getFeedArticleList(int pageNum);

}

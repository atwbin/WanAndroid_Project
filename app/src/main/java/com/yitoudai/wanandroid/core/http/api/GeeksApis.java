package com.yitoudai.wanandroid.core.http.api;

import com.yitoudai.wanandroid.core.bean.FeedArticleListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Author：Created by Wbin on 2018/8/6
 *
 * Description：
 */
public interface GeeksApis {

    String HOST = "http://www.wanandroid.com/";

    /**
     * @param num 获取feed文章列表
     * @return 页数
     */
    @GET("article/list/{num}/json")
    Observable<FeedArticleListResponse> getFeedArticleList(@Path("num") int num);
}

package com.yitoudai.wanandroid.core.http;

import com.yitoudai.wanandroid.core.bean.FeedArticleListResponse;
import com.yitoudai.wanandroid.core.http.api.GeeksApis;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Author：Created by Wbin on 2018/8/6
 *
 * Description：
 */
public class RetrofitHelper implements HttpHelper {

    private GeeksApis mGeeksApis;

    @Inject
    public RetrofitHelper(GeeksApis geeksApis) {
        this.mGeeksApis = geeksApis;

    }

    @Override
    public Observable<FeedArticleListResponse> getFeedArticleList(int pageNum) {
        return mGeeksApis.getFeedArticleList(pageNum);
    }
}

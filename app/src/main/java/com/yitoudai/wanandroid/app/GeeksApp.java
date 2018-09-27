package com.yitoudai.wanandroid.app;

import android.app.Application;
import android.support.v4.content.ContextCompat;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.yitoudai.wanandroid.BuildConfig;
import com.yitoudai.wanandroid.R;
import com.yitoudai.wanandroid.utils.logger.TxtFormatStrategy;


/**
 * Author：Created by Wbin on 2018/8/6
 *
 * Description：
 */
public class GeeksApp extends Application {

    private static GeeksApp instance;
//    private static volatile AppComponent appComponent;


    //static 代码段可以防止内存泄露, 全局设置刷新头部及尾部，优先级最低
   /* static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreater((context, refreshLayout) -> {
            //全局设置主题颜色
            refreshLayout.setPrimaryColorsId(R.color.yellow, android.R.color.white);
            //指定为Delivery Header，默认是贝塞尔雷达Header
            return new DeliveryHeader(context);
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreater((context, layout) -> {
            //默认是 BallPulseFooter
            return new BallPulseFooter(context).setAnimatingColor(ContextCompat.getColor(context, R.color.colorAccent));
        });
    }
*/
    public static synchronized GeeksApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initLogger();
    }

    /**
     * 初始化logger
     */
    private void initLogger() {
        //debug才打控制台log
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().tag(getString(R.string.app_name)).build()));
        }

        //吧LOG存在本地
        Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy.newBuilder().tag(getString(R.string.app_name)).build(getPackageName(), getString(R.string.app_name))));
    }

//    public static synchronized AppComponent getAppComponent(){}
}

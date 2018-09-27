package com.yitoudai.wanandroid.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.orhanobut.logger.LogStrategy;


/**
 * Author：Created by Wbin on 2018/8/2
 *
 * Description：
 */
public class LogCatStrategy implements LogStrategy {

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        Log.println(priority, randomKey() + tag, message);
    }

    private int last;

    private String randomKey() {
        int random = (int) (10 * Math.random());
        if (last == random) {
            random = (random + 1) % 10;
        }
        last = random;
        return String.valueOf(random);
    }


}

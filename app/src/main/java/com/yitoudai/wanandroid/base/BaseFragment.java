package com.yitoudai.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yitoudai.wanandroid.R;
import com.yitoudai.wanandroid.utils.CommonUtils;

import javax.inject.Inject;

/**
 * Author：Created by Wbin on 2018/8/28
 *
 * Description： mvp模式的Fragment
 */
public abstract class BaseFragment<T extends BasePresenter> extends AbstractSimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }


   /* public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(GeeksApp.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }*/

    @Override
    public void showErrorMsg(String errorMsg) {
        if (isAdded()) {
            CommonUtils.showMessage(_mActivity, errorMsg);
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();

    }

    @Override
    public void showCancelCollectFail() {
        CommonUtils.showMessage(_mActivity, getString(R.string.cancel_collect_fail));
    }

    @Override
    public void showCollectFail() {
        CommonUtils.showMessage(_mActivity, getString(R.string.collect_fail));
    }

    /**
     * 注入当前Fragment所需的依赖
     */
    protected abstract void initInject();
}

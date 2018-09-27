package com.yitoudai.wanandroid.base;

import com.yitoudai.wanandroid.R;
import com.yitoudai.wanandroid.utils.CommonUtils;

import javax.inject.Inject;

/**
 * Author：Created by Wbin on 2018/8/3
 *
 * Description：mvp模式的Activity
 */
public abstract class BaseActivity<T extends BasePresenter> extends AbstractSimpleActivity implements BaseView{

    @Inject
    protected T mPresenter;

    @Override
    protected void onDestroy() {

        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

   /* protected ActivityCompat getActivityCompat(){
        return DaggerActivityComponent.builder()
                .appComponent(GeeksApp.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }
*/
   @Override
   public void showError() {

   }

    @Override
    public void showLoading() {

    }

    @Override
    public void showErrorMsg(String errorMsg) {
        CommonUtils.showMessage(this,errorMsg);
    }

    @Override
    public void showCollectFail() {
        CommonUtils.showMessage(this, getString(R.string.collect_fail));
    }

    @Override
    public void showCancelCollectFail() {
        CommonUtils.showMessage(this, getString(R.string.cancel_collect_fail));
    }

    /**
     * 注入当前Activty所需的依赖
     */
    protected abstract void initInject();
}

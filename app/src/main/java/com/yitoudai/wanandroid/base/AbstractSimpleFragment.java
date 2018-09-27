package com.yitoudai.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author：Created by Wbin on 2018/8/3
 *
 * Description：
 */
public abstract class AbstractSimpleFragment extends SupportFragment {

    private Unbinder unbinder;
    // CompositeDisposable是fragment的全局变量，我在切换fragment的时候，解除了订阅关系。但是又切回去的时候 compositeDisposable还是原来的。但是已经被dispose了。当我在重新订阅的时候，compositeDisposable还保存在刚刚的Disposable对象。导致接受不到事件。
    //而且在订阅的时候，就算你CompositeDisposable重新添加新的水管(disposable),也会发现不行的。因为add的源码
    private CompositeDisposable mCompositeDisposable;
    private boolean isInnerFragment;
    private long clickTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        mCompositeDisposable = new CompositeDisposable();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
        unbinder.unbind();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEventAndData();
    }

    @Override
    public boolean onBackPressedSupport() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
            if (isInnerFragment) {
                _mActivity.finish();
                return true;
            }

            long currentTime = System.currentTimeMillis();
            long time = 2000;
            if ((currentTime - clickTime) > time) {
                clickTime = System.currentTimeMillis();
            } else {
                _mActivity.finish();
            }
        }
        return true;
    }

    /**
     * 得到当前的布局
     */
    protected abstract int getLayout();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();
}

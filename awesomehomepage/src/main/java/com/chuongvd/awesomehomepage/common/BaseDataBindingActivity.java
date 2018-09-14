package com.chuongvd.awesomehomepage.common;

import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseDataBindingActivity<B extends ViewDataBinding, V extends AndroidViewModel>
        extends AppCompatActivity {

    protected B mBinding;

    protected V mViewModel;

    public abstract Context context();

    public abstract int getContentViewLayoutId();

    public abstract void initData();

    protected abstract void subscribeToViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getContentViewLayoutId());
        initData();
        subscribeToViewModel();
    }
}

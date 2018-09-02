package com.chuongvd.awesomehomepage;

import com.chuongvd.awesomehomepage.common.BaseDataBindingActivity;
import com.chuongvd.awesomehomepage.databinding.ActivityHomeBinding;
import com.chuongvd.awesomehomepage.viewmodel.HomeActivityViewModel;

/**
 * Created on 9/2/18
 *
 * @author Chuongvd
 */
public class HomeActivity extends BaseDataBindingActivity<ActivityHomeBinding, HomeActivityViewModel> {

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {

    }
}

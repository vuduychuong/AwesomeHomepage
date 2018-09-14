package com.chuongvd.awesomehomepage.ui;

import android.content.Context;
import com.chuongvd.awesomehomepage.widget.viewpager.NavigationSupportPagerAdapter;

/**
 * Created on 9/2/18
 *
 * @author Chuongvd
 */
public class AwesomeHomepageFragment extends BaseAwesomeHomepageFragment {

    @Override
    public void initAdapter(NavigationSupportPagerAdapter adapter) {

    }

    @Override
    public Context context() {
        return getContext();
    }
}

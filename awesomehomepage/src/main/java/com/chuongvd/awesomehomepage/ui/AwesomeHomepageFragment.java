package com.chuongvd.awesomehomepage.ui;

import com.chuongvd.awesomehomepage.widget.viewpager.ItemNavigationFragment;
import com.chuongvd.awesomehomepage.widget.viewpager.NavigationSupportPagerAdapter;

/**
 * Created on 9/2/18
 *
 * @author Chuongvd
 */
public class AwesomeHomepageFragment<ITEM_FRAGMENT extends ItemNavigationFragment>
        extends BaseAwesomeHomepageFragment<ITEM_FRAGMENT> {

    @Override
    public void initAdapter(NavigationSupportPagerAdapter<ITEM_FRAGMENT> adapter) {

    }
}

package com.chuongvd.sample;

import com.chuongvd.awesomehomepage.ui.BaseAwesomeHomepageFragment;
import com.chuongvd.awesomehomepage.widget.viewpager.CustomBottomNavigation;
import com.chuongvd.awesomehomepage.widget.viewpager.ItemNavigationFragment;
import com.chuongvd.awesomehomepage.widget.viewpager.NavigationSupportPagerAdapter;

/**
 * Created on 9/2/18
 *
 * @author Chuongvd
 */
public class MainFragment extends BaseAwesomeHomepageFragment<ItemNavigationFragment> {

    @Override
    public void initAdapter(NavigationSupportPagerAdapter<ItemNavigationFragment> adapter) {
        adapter.addFragment(new ItemNavigationFragment("Item 1", R.mipmap.ic_launcher_round,
                SampleFragment.newInstance("Item 1")));

        adapter.addFragment(new ItemNavigationFragment("Item 2", R.mipmap.ic_launcher_round,
                SampleFragment.newInstance("Item 2")));

        adapter.addFragment(new ItemNavigationFragment("Item 3", R.mipmap.ic_launcher_round,
                SampleFragment.newInstance("Item 3")));

        adapter.addFragment(new ItemNavigationFragment("Item 4", R.mipmap.ic_launcher_round,
                SampleFragment.newInstance("Item 4")));
    }

    @Override
    protected void stylingBottomNavigation(CustomBottomNavigation bottomNavigation) {
        super.stylingBottomNavigation(bottomNavigation);
        bottomNavigation.setNotification("5", 2);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        mCustomBottomNavigation.setNotification("", position);
        return super.onTabSelected(position, wasSelected);
    }
}

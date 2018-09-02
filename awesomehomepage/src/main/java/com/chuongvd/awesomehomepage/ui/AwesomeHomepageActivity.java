package com.chuongvd.awesomehomepage.ui;

import android.content.res.Resources;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import com.chuongvd.awesomehomepage.R;
import com.chuongvd.awesomehomepage.common.BaseDataBindingActivity;
import com.chuongvd.awesomehomepage.databinding.ActivityHomeBinding;
import com.chuongvd.awesomehomepage.listener.DrawerSupport;
import com.chuongvd.awesomehomepage.viewmodel.HomeActivityViewModel;

/**
 * Created on 9/2/18
 *
 * @author Chuongvd
 */
public abstract class AwesomeHomepageActivity
        extends BaseDataBindingActivity<ViewDataBinding, HomeActivityViewModel>
        implements DrawerSupport, NavigationView.OnNavigationItemSelectedListener {
    protected ActivityHomeBinding binding;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        binding = (ActivityHomeBinding) mBinding;
        setEnableDrawer(isEnableDrawer());
        //
        //        AwesomeHomepageFragment fragment = new AwesomeHomepageFragment();
        //        getSupportFragmentManager().beginTransaction()
        //                .add(R.id.container, fragment, AwesomeHomepageFragment.class.getName())
        //                .commit();
        //        binding.drawerNavigation
    }

    protected abstract int getNavigationMenu();

    protected abstract int getNavigationHeader();

    protected abstract boolean isEnableDrawer();

    protected void stylingHeaderView(View headerView) {
        // TODO: 9/2/18
    }

    protected void stylingNavigationView(NavigationView drawerNavigation) {
        // TODO: 9/2/18
    }

    protected void setEnableDrawer(boolean enable) {
        binding.drawer.setDrawerLockMode(
                enable ? DrawerLayout.LOCK_MODE_UNLOCKED : DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        if (enable) {
            inflateNavigationMenu();
        } else {
            removeNavigationMenu();
        }
    }

    private void removeNavigationMenu() {
        binding.drawerNavigation.removeAllViews();
    }

    private void inflateNavigationMenu() {
        try {
            binding.drawerNavigation.inflateHeaderView(getNavigationHeader());
            stylingHeaderView(binding.drawerNavigation.getHeaderView(0));
        } catch (Resources.NotFoundException e) {
            Log.w("", e);
        }
        try {
            binding.drawerNavigation.inflateMenu(getNavigationMenu());
            binding.drawerNavigation.setNavigationItemSelectedListener(this);
            stylingNavigationView(binding.drawerNavigation);
        } catch (Resources.NotFoundException e) {
            if (isEnableDrawer()) {
                throw e;
            }
        }
    }

    @Override
    public void toggleDrawer() {
        if (binding.drawer.isDrawerOpen(Gravity.START)) {
            binding.drawer.closeDrawers();
        } else {
            binding.drawer.openDrawer(Gravity.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}

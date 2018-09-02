package com.chuongvd.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.chuongvd.awesomehomepage.ui.AwesomeHomepageActivity;
import com.chuongvd.awesomehomepage.ui.BaseAwesomeHomepageFragment;

public class MainActivity extends AwesomeHomepageActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment, MainFragment.class.getName())
                .commit();
    }

    @Override
    protected int getNavigationMenu() {
        return R.menu.nav_menu;
    }

    @Override
    protected int getNavigationHeader() {
        return R.layout.nav_header;
    }

    @Override
    protected boolean isEnableDrawer() {
        return false;
    }

    @Override
    protected void stylingNavigationView(NavigationView drawerNavigation) {
        super.stylingNavigationView(drawerNavigation);
    }

    @Override
    protected void stylingHeaderView(View headerView) {
        super.stylingHeaderView(headerView);
        ImageView imageView = headerView.findViewById(R.id.img_profile);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Log.d("Click", item.getTitle().toString());
                BaseAwesomeHomepageFragment.sendBroadcastChangeBadge(this, 1, "50");
                break;
            case R.id.item2:
                BaseAwesomeHomepageFragment.sendBroadcastChangeBadge(this, 3, "3");
                Log.d("Click", item.getTitle().toString());
                break;
        }
        toggleDrawer();
        return true;
    }
}

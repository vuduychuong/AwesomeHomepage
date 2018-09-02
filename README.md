# AwesomeHomepage
Library to support build Homepage very fast and easy to use (minSdkVersion = 14).

# Features
* Integrate AHBottomNavigation (More usage at https://github.com/aurelhubert/ahbottomnavigation).
* Integrate DrawerLayout and NavigationView

# How to use?

## Gradle
In build.gradle project level, add following this code:
```
repositories {
    maven {
        url  "https://dl.bintray.com/chuongvd/maven" 
    }
}
```
In build.grade app level, add codes below:
```
dependencies {
  compile 'com.chuongvd.support:awesomehomepage:0.1.8'
}
```

## Integrate Homepage with Bottom navigation

```
public class MainFragment extends BaseAwesomeHomepageFragment {
    @Override
    public void initAdapter(NavigationSupportPagerAdapter adapter) {
        adapter.addFragment(new ItemNavigationFragment("Item 1", R.mipmap.ic_launcher_round,
                Fragment.instantiate(getContext(), SampleFragment.class.getName())));
        adapter.addFragment(new ItemNavigationFragment("Item 2", R.mipmap.ic_launcher_round,
                Fragment.instantiate(getContext(), SampleFragment.class.getName())));
        adapter.addFragment(new ItemNavigationFragment("Item 3", R.mipmap.ic_launcher_round,
                Fragment.instantiate(getContext(), SampleFragment.class.getName())));
        adapter.addFragment(new ItemNavigationFragment("Item 4", R.mipmap.ic_launcher_round,
                Fragment.instantiate(getContext(), SampleFragment.class.getName())));
    }

    @Override
    protected void stylingBottonNavigation(CustomBottomNavigation bottomNavigation) {
        super.stylingBottonNavigation(bottomNavigation);
        bottomNavigation.setNotification("5", 2);
    }
}
```

Present, We only support create from Fragment. If you need to create as Activity, please using `FragmentManager` to add this Fragment to your Activity

```
MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment, MainFragment.class.getName())
                .commit();
```

You can set badge on BottomNavigation by:

```
BaseAwesomeHomepageFragment.sendBroadcastChangeBadge(context, position, value);
```

## Integrate Homepage with Drawer & NavigationView

```
public class MainActivity extends AwesomeHomepageActivity {

     @Override
    protected boolean isEnableDrawer() {
        return true;
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
    protected void stylingNavigationView(NavigationView drawerNavigation) {
        super.stylingNavigationView(drawerNavigation);
        //TODO: customize your navigation
    }

    @Override
    protected void stylingHeaderView(View headerView) {
        super.stylingHeaderView(headerView);
        ImageView imageView = headerView.findViewById(R.id.img_profile);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
        //TODO: customize your headerView
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Log.d("Click", item.getTitle().toString());
                break;
            case R.id.item2:
                Log.d("Click", item.getTitle().toString());
                break;
        }
        return true;
    }
}
```

# Contributions
Feel free to create issues / pull requests.

# License
**AwesomeHomepage** library for Android
Copyright (c) 2018 chuongvd (http://github.com/vuduychuong).

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

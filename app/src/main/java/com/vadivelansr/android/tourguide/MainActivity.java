package com.vadivelansr.android.tourguide;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.vadivelansr.android.tourguide.adapter.MainViewPagerAdapter;
import com.vadivelansr.android.tourguide.config.Constants;
import com.vadivelansr.android.tourguide.fragment.TourGuideFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.main_tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.main_view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    setAppBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                } else if (position == 1) {
                    setAppBarColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                } else if (position == 2) {
                    setAppBarColor(ContextCompat.getColor(MainActivity.this, R.color.teal));
                } else if (position == 3) {
                    setAppBarColor(ContextCompat.getColor(MainActivity.this, R.color.brown));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void setUpViewPager(ViewPager paramViewPager) {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(TourGuideFragment.newInstance(Constants.HISTORICAL_SITES), getString(R.string.historical_sites));
        adapter.addFragment(TourGuideFragment.newInstance(Constants.SHOPPING_MALLS), getString(R.string.shopping_malls));
        adapter.addFragment(TourGuideFragment.newInstance(Constants.PUBS), getString(R.string.pubs));
        adapter.addFragment(TourGuideFragment.newInstance(Constants.FUN_SPOTS), getString(R.string.fun_spots));
        paramViewPager.setAdapter(adapter);
    }

    private void setAppBarColor(int color) {
        toolbar.setBackgroundColor(color);
        tabLayout.setBackgroundColor(color);
        setStatusBarColor(color);
    }

    private void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }


}

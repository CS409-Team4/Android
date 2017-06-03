package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class LayoutsActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private int[] imageResId = {
            R.drawable.stack,
            R.drawable.grid,
            R.drawable.wrap,
            R.drawable.dock,
            R.drawable.absolute
    };

    private int[] imageResIdSelected = {
            R.drawable.stack1,
            R.drawable.grid1,
            R.drawable.wrap1,
            R.drawable.dock1,
            R.drawable.absolute1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(imageResIdSelected[0]);
        for (int i = 1; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }
        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        tab.setIcon(imageResIdSelected[tab.getPosition()]);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        tab.setIcon(imageResId[tab.getPosition()]);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            switch (position) {
                case 0:
                    LayoutsStack fragStack = new LayoutsStack();
                    return fragStack;
                case 1:
                    LayoutsGrid fragGrid = new LayoutsGrid();
                    return fragGrid;
                case 2:
                    LayoutsWrap fragWrap = new LayoutsWrap();
                    return fragWrap;
                case 3:
                    LayoutsDock fragDock = new LayoutsDock();
                    return fragDock;
                case 4:
                    LayoutsAbsolute fragAbsolute = new LayoutsAbsolute();
                    return fragAbsolute;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}

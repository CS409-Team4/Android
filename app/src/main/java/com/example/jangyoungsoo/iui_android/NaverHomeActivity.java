package com.example.jangyoungsoo.iui_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class NaverHomeActivity extends AppCompatActivity {

    public final static String EXTRA_URL = "com.example.jangyoungsoo.iui_android.URL";

    public static DrawerLayout drawerLayout;

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naverhome);

        Window window = getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        Button button_navopen = (Button) findViewById(R.id.nh_button_navopen);
        drawerLayout = (DrawerLayout) findViewById(R.id.nh_drawer_layout);
        button_navopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nh_nav_view);
        View header = navigationView.getHeaderView(0);

        Button button_navclose = (Button) header.findViewById(R.id.nh_button_navclose);
        Button button_mail = (Button) header.findViewById(R.id.nh_button_mail);
        Button button_cafe = (Button) header.findViewById(R.id.nh_button_cafe);
        Button button_blog = (Button) header.findViewById(R.id.nh_button_blog);
        Button button_kin = (Button) header.findViewById(R.id.nh_button_kin);

        button_navclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        button_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NaverHomeActivity.this, NaverOtherActivity.class);
                String message = "http://mail.naver.com";
                intent.putExtra(EXTRA_URL, message);
                startActivity(intent);
            }
        });

        button_cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NaverHomeActivity.this, NaverOtherActivity.class);
                String message = "http://cafe.naver.com";
                intent.putExtra(EXTRA_URL, message);
                startActivity(intent);
            }
        });

        button_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NaverHomeActivity.this, NaverOtherActivity.class);
                String message = "http://blog.naver.com";
                intent.putExtra(EXTRA_URL, message);
                startActivity(intent);
            }
        });

        button_kin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NaverHomeActivity.this, NaverOtherActivity.class);
                String message = "http://kin.naver.com";
                intent.putExtra(EXTRA_URL, message);
                startActivity(intent);
            }
        });

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.nh_viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.nh_tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            NHFragment nhFragment = new NHFragment();
            return nhFragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "뉴스";
                case 1:
                    return "연예";
                case 2:
                    return "스포츠";
                case 3:
                    return "쇼핑";
                case 4:
                    return "푸드";
            }
            return null;
        }
    }
}

package com.example.jangyoungsoo.iui_android;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    public static TabLayout tabLayout;

    public final static ArrayList<SLItem> slItemsFinal = new ArrayList<>();
    public static ArrayList<SLItem> slItems;
    public static ArrayList<SLItem> slItemsFav;

    public static Boolean isReorderMode;
    public static Boolean isEditMode;
    public static SLFragment slFragment;
    public static SLFragment slFragment2;
    public static SelectionActivity selectionActivity;

    public static ArrayList<Integer> slItemsSelectedIndex = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        selectionActivity = this;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.sl_viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.sl_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        isReorderMode = false;
        isEditMode = false;

        slItems = new ArrayList<>();
        slItems.add(new SLItem(
                "Master the Essentials of UI Test Automation: Chapter One",
                "Chapter One: Introduction The goal of this series is to help you understand the right questions to ask of you, your team and your organization. There won't be any Best Practices; there won't be any silver bullets. What we hope is to convey the right information to help you get started on the right foot and get through some of the most common problems teams hit when starting out with UI test automation.",
                "Chapter One: Introduction The goal of this series is to help you understand the right questions to ask of you, your team and your organization. There won't be any Best Practices; there won't be any silver bullets.",
                false, 0));
        slItems.add(new SLItem(
                "Send Data to Apple Watch with Core Data and Telerik UI for iOS in Swift",
                "The Apple Watch has been a long rumored device which finally appeared in September, followed by a Watch SDK, called WatchKit, in November. The introduction of the SDK maybe raised more questions than it answered, and we like everybody else are looking into the future for answers from Apple. One such question is: how can I send data, larger than what is allowed for a push notification, from the iPhone to the Watch?",
                "The Apple Watch has been a long rumored device which finally appeared in September, followed by a Watch SDK, called WatchKit, in November.",
                true, 1));
        slItems.add(new SLItem(
                "6 Key Steps to Successful Agile Testing Projects",
                "Application teams are continuously adopting agile software techniques as the principal method of building applications. Agile methodologies, such as Scrum, Extreme Programming, Feature-Driven Development and Test-Driven Development offer the ability to iteratively develop applications.",
                "Application teams are continuously adopting agile software techniques as the principal method of building applications. Agile methodologies, such as Scrum, Extreme Programming, Feature-Driven Development and Test-Driven Development offer the ability to iteratively develop applications.",
                true, 2));
        slItems.add(new SLItem(
                "Increase Your Mobile App Engagement. Become Part of the Web of Apps.",
                "Mobile developers are facing some severe limitations when it comes to app distribution: app content is almost invisible to browser search, app-to-app connections are scarce, and app updates need to go through a tedious re-submission process on the relevant marketplace. How can Google App Indexing, deep linking and Google Tag Manager for mobile apps help in the process of overcoming these limitations?",
                "Mobile developers are facing some severe limitations when it comes to app distribution: app content is almost invisible to browser search, app-to-app connections are scarce, and app updates need to go through a tedious re-submission process on the relevant marketplace.",
                true, 3));
        slItems.add(new SLItem(
                "Building a Seismograph App with CoreMotion, Swift and Telerik UI for iOS",
                "Data visualizations are important, especially on small screen areas, where Excel files or other tables are difficult to read and comprehend. Visualizations are even more important when you add the various sensors that an iPhone device offers, not to mention the different certified third-party devices. Today, I will show you how you can set up the Telerik Chart for iOS to live-stream data coming from the accelerometer sensor using the CoreMotion API.",
                "Data visualizations are important, especially on small screen areas, where Excel files or other tables are difficult to read and comprehend.",
                false, 4));
        slItems.add(new SLItem(
                "Application Performance Monitoring with the Crittercism Cordova Plugin",
                "As hybrid mobile apps scale to massive amounts of users and tremendous amount of data, developers need to monitor and trace the app’s performance. Crittercism is the world's first mobile application performance management (mAPM) solution, offering both error monitoring and service monitoring solutions. The Crittercism service monitors every aspect of mobile app performance, allowing Developers and IT Operations to deliver high performing, highly reliable, highly available mobile apps.",
                "As hybrid mobile apps scale to massive amounts of users and tremendous amount of data, developers need to monitor and trace the app’s performance.",
                false, 5));

        slItemsFinal.add(new SLItem(
                "Master the Essentials of UI Test Automation: Chapter One",
                "Chapter One: Introduction The goal of this series is to help you understand the right questions to ask of you, your team and your organization. There won't be any Best Practices; there won't be any silver bullets. What we hope is to convey the right information to help you get started on the right foot and get through some of the most common problems teams hit when starting out with UI test automation.",
                "Chapter One: Introduction The goal of this series is to help you understand the right questions to ask of you, your team and your organization. There won't be any Best Practices; there won't be any silver bullets.",
                false, 0));
        slItemsFinal.add(new SLItem(
                "Send Data to Apple Watch with Core Data and Telerik UI for iOS in Swift",
                "The Apple Watch has been a long rumored device which finally appeared in September, followed by a Watch SDK, called WatchKit, in November. The introduction of the SDK maybe raised more questions than it answered, and we like everybody else are looking into the future for answers from Apple. One such question is: how can I send data, larger than what is allowed for a push notification, from the iPhone to the Watch?",
                "The Apple Watch has been a long rumored device which finally appeared in September, followed by a Watch SDK, called WatchKit, in November.",
                true, 1));
        slItemsFinal.add(new SLItem(
                "6 Key Steps to Successful Agile Testing Projects",
                "Application teams are continuously adopting agile software techniques as the principal method of building applications. Agile methodologies, such as Scrum, Extreme Programming, Feature-Driven Development and Test-Driven Development offer the ability to iteratively develop applications.",
                "Application teams are continuously adopting agile software techniques as the principal method of building applications. Agile methodologies, such as Scrum, Extreme Programming, Feature-Driven Development and Test-Driven Development offer the ability to iteratively develop applications.",
                true, 2));
        slItemsFinal.add(new SLItem(
                "Increase Your Mobile App Engagement. Become Part of the Web of Apps.",
                "Mobile developers are facing some severe limitations when it comes to app distribution: app content is almost invisible to browser search, app-to-app connections are scarce, and app updates need to go through a tedious re-submission process on the relevant marketplace. How can Google App Indexing, deep linking and Google Tag Manager for mobile apps help in the process of overcoming these limitations?",
                "Mobile developers are facing some severe limitations when it comes to app distribution: app content is almost invisible to browser search, app-to-app connections are scarce, and app updates need to go through a tedious re-submission process on the relevant marketplace.",
                true, 3));
        slItemsFinal.add(new SLItem(
                "Building a Seismograph App with CoreMotion, Swift and Telerik UI for iOS",
                "Data visualizations are important, especially on small screen areas, where Excel files or other tables are difficult to read and comprehend. Visualizations are even more important when you add the various sensors that an iPhone device offers, not to mention the different certified third-party devices. Today, I will show you how you can set up the Telerik Chart for iOS to live-stream data coming from the accelerometer sensor using the CoreMotion API.",
                "Data visualizations are important, especially on small screen areas, where Excel files or other tables are difficult to read and comprehend.",
                false, 4));
        slItemsFinal.add(new SLItem(
                "Application Performance Monitoring with the Crittercism Cordova Plugin",
                "As hybrid mobile apps scale to massive amounts of users and tremendous amount of data, developers need to monitor and trace the app’s performance. Crittercism is the world's first mobile application performance management (mAPM) solution, offering both error monitoring and service monitoring solutions. The Crittercism service monitors every aspect of mobile app performance, allowing Developers and IT Operations to deliver high performing, highly reliable, highly available mobile apps.",
                "As hybrid mobile apps scale to massive amounts of users and tremendous amount of data, developers need to monitor and trace the app’s performance.",
                false, 5));
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
                    slFragment = new SLFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("fav", false);
                    slFragment.setArguments(bundle);
                    return slFragment;
                case 1:
                    slFragment2 = new SLFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("fav", true);
                    slFragment2.setArguments(bundle2);
                    return slFragment2;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ALL";
                case 1:
                    return "FAVORITES";
            }
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_selection, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_reorder).setVisible(!isReorderMode && !isEditMode);
        menu.findItem(R.id.action_add_to_fav).setVisible(isEditMode);
        menu.findItem(R.id.action_delete).setVisible(isEditMode);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayout tabStrip;
        switch (item.getItemId()) {
            case android.R.id.home:
                if (isReorderMode) {
                    getSupportActionBar().setTitle("Selection");
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#151F2F")));
                    tabLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueBackground));
                    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicator));

                    tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
                    for(int i = 0; i < tabStrip.getChildCount(); i++) {
                        tabStrip.getChildAt(i).setClickable(true);
                    }

                    if (tabLayout.getSelectedTabPosition() == 0) {
                        slFragment2.updateSLItemsFav();
                    }
                    slFragment.setupListRecyclerView();
                    slFragment2.setupListRecyclerView();
                    isReorderMode = false;
                    supportInvalidateOptionsMenu();
                } else if (isEditMode) {
                    getSupportActionBar().setTitle("Selection");
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#151F2F")));
                    tabLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueBackground));
                    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicator));

                    tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
                    for(int i = 0; i < tabStrip.getChildCount(); i++) {
                        tabStrip.getChildAt(i).setClickable(true);
                    }

                    slFragment.setupListRecyclerView();
                    slFragment2.setupListRecyclerView();
                    slItemsSelectedIndex = new ArrayList<>();
                    isEditMode = false;
                    supportInvalidateOptionsMenu();
                } else {
                    finish();
                }
                return true;
            case R.id.action_reorder:
                getSupportActionBar().setTitle("Reorder");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#30BCFF")));
                tabLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueBackgroundLight));
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicatorLight));

                tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
                for(int i = 0; i < tabStrip.getChildCount(); i++) {
                    tabStrip.getChildAt(i).setClickable(false);
                }

                slFragment.setupListReorder();
                slFragment2.setupListReorder();
                isReorderMode = true;
                supportInvalidateOptionsMenu();
                return true;
            case R.id.action_add_to_fav:
                getSupportActionBar().setTitle("Selection");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#151F2F")));
                tabLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueBackground));
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicator));

                tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
                for(int i = 0; i < tabStrip.getChildCount(); i++) {
                    tabStrip.getChildAt(i).setClickable(true);
                }

                for (Integer i : slItemsSelectedIndex) {
                    for (SLItem slitem : SelectionActivity.slItems) {
                        if (slitem.getId() == i) {
                            if (slitem.getFav()) {
                                slitem.setFav(false);
                            } else {
                                slitem.setFav(true);
                            }
                            break;
                        }
                    }
                }

                slItemsSelectedIndex = new ArrayList<>();
                slFragment2.updateSLItemsFav();
                slFragment.setupListRecyclerView();
                slFragment2.setupListRecyclerView();
                isEditMode = false;
                supportInvalidateOptionsMenu();
                return true;
            case R.id.action_delete:
                getSupportActionBar().setTitle("Selection");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#151F2F")));
                tabLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueBackground));
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicator));

                tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
                for(int i = 0; i < tabStrip.getChildCount(); i++) {
                    tabStrip.getChildAt(i).setClickable(true);
                }

                for (Integer i : slItemsSelectedIndex) {
                    for (SLItem slitem : slItems) {
                        if (slitem.getId() == i) {
                            slItems.remove(slitem);
                            break;
                        }
                    }
                }

                slItemsSelectedIndex = new ArrayList<>();
                slFragment2.updateSLItemsFav();
                slFragment.setupListRecyclerView();
                slFragment2.setupListRecyclerView();
                isEditMode = false;
                supportInvalidateOptionsMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void editMode() {
        if (!isEditMode) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#30BCFF")));
            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueBackgroundLight));
            tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicatorLight));

            LinearLayout tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
            for(int i = 0; i < tabStrip.getChildCount(); i++) {
                tabStrip.getChildAt(i).setClickable(false);
            }

            isEditMode = true;
            supportInvalidateOptionsMenu();
        }
    }

    public void setNumberSelected() {
        getSupportActionBar().setTitle(Integer.toString(slItemsSelectedIndex.size()));
    }

}

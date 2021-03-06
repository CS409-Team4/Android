package com.example.jangyoungsoo.iui_android;

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
import android.widget.SearchView;

import java.util.ArrayList;

public class ConferenceAgendaActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;

    public static ArrayList<CAItem> agenda1;
    public static ArrayList<CAItem> agenda2;
    public static ArrayList<CAItem> agenda3;

    private CAFragment caFragment;
    private CAFragment caFragment2;
    private CAFragment caFragment3;

    public static SearchView ca_searchview;
    public static String queryText = "";
    public static Boolean startSearch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferenceagenda);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        caFragment = new CAFragment();
        caFragment2 = new CAFragment();
        caFragment3 = new CAFragment();

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.ca_viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.ca_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        ca_searchview = (SearchView) findViewById(R.id.ca_searchView);
        ca_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                startSearch = true;
                queryText = newText;
                if (caFragment.caListViewAdapter != null) {
                    caFragment.caListViewAdapter.getFilter().filter(newText);
                }
                if (caFragment2.caListViewAdapter != null) {
                    caFragment2.caListViewAdapter.getFilter().filter(newText);
                }
                if (caFragment3.caListViewAdapter != null) {
                    caFragment3.caListViewAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });

        CAItem caitem;

        agenda1 = new ArrayList<>();
        for (int i = 0; i < agendaTime1.length; i++) {
            caitem = new CAItem(agendaTime1[i], agendaRoom1[i], agendaTitle1[i], agendaFav1[i]);
            agenda1.add(caitem);
        }

        agenda2 = new ArrayList<>();
        for (int i = 0; i < agendaTime2.length; i++) {
            caitem = new CAItem(agendaTime2[i], agendaRoom2[i], agendaTitle2[i], agendaFav2[i]);
            agenda2.add(caitem);
        }

        agenda3 = new ArrayList<>();
        for (int i = 0; i < agendaTime3.length; i++) {
            caitem = new CAItem(agendaTime3[i], agendaRoom2[i], agendaTitle3[i], agendaFav3[i]);
            agenda3.add(caitem);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startSearch = false;
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            Bundle bundle = new Bundle();
            switch (position) {
                case 0:
                    bundle.putInt("agenda", 1);
                    caFragment.setArguments(bundle);
                    return caFragment;
                case 1:
                    bundle.putInt("agenda", 2);
                    caFragment2.setArguments(bundle);
                    return caFragment2;
                case 2:
                    bundle.putInt("agenda", 3);
                    caFragment3.setArguments(bundle);
                    return caFragment3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MAY 3";
                case 1:
                    return "MAY 4";
                case 2:
                    return "MAY 5";
            }
            return null;
        }
    }

    private String[] agendaTime1 = {
            "9:30 AM - 12:30 PM",
            "9:30 AM - 12:30 PM",
            "9:30 AM - 12:30 PM",
            "1:30 PM - 4:30 PM",
            "1:30 PM - 4:30 PM",
            "1:30 PM - 4:30 PM"
    };

    private String[] agendaRoom1 = {
            "ROOM 1",
            "ROOM 2",
            "ROOM 3",
            "ROOM 1",
            "ROOM 2",
            "ROOM 3"
    };

    private String[] agendaTitle1 = {
            "Android Deep Dive 1",
            "Smart Design for Smartphones",
            "Build, Deploy, and Scale your Mobile Backend with Node.js and Modulus",
            "Android Deep Dive 2",
            "Smart Design for Smartphones",
            "Responsive Apps with Telerik DevCraft"
    };

    private Boolean[] agendaFav1 = {
            true,
            false,
            false,
            true,
            false,
            false
    };

    private String[] agendaTime2 = {
            "9:30 AM - 12:30 PM",
            "10:45 AM - 11:30 AM",
            "10:45 AM - 11:30 AM",
            "11:45 AM - 12:30 PM",
            "11:45 AM - 12:30 PM",
            "1:30 PM - 2:15 PM",
            "1:30 PM - 2:15 PM",
            "2:30 PM - 3:15 PM",
            "2:30 PM - 3:15 PM"
    };

    private String[] agendaRoom2 = {
            "ROOM 1",
            "ROOM 1",
            "ROOM 2",
            "ROOM 1",
            "ROOM 2",
            "ROOM 1",
            "ROOM 2",
            "ROOM 1",
            "ROOM 2"
    };

    private String[] agendaTitle2 = {
            "Telerik Keynote - Mobilizing and Modernizing",
            "A Lap Around Android",
            "Kendo UI Building Blocks",
            "AngularJS 2.0",
            "Getting Started with ScreenBuilder",
            "Android Extensibility",
            "AngularJS and Kendo UI",
            "Building a CRM Portal in 45 Minutes",
            "JavaScript Beyond the Basics"
    };

    private Boolean[] agendaFav2 = {
            true,
            true,
            false,
            true,
            false,
            true,
            false,
            false,
            true
    };

    private String[] agendaTime3 = {
            "9:30 AM - 12:30 PM",
            "10:45 AM - 11:30 AM",
            "10:45 AM - 11:30 AM",
            "11:45 AM - 12:30 PM",
            "11:45 AM - 12:30 PM",
            "1:30 PM - 2:15 PM",
            "1:30 PM - 2:15 PM",
            "2:30 PM - 3:15 PM",
            "2:30 PM - 3:15 PM"
    };

    private String[] agendaRoom3 = {
            "ROOM 1",
            "ROOM 1",
            "ROOM 2",
            "ROOM 1",
            "ROOM 2",
            "ROOM 1",
            "ROOM 2",
            "ROOM 1",
            "ROOM 2"
    };

    private String[] agendaTitle3 = {
            "Sitefinity Keynote",
            "Introduction to Mobile Testing & Device Cloud",
            "Using Kendo UI in SharePoint/Office 365",
            "Improving Applications with Telerik Analytics",
            "Building Offline Ready Mobile Apps",
            "Debugging with Fiddler",
            "Performance Tuning Your Mobile Web Apps",
            "Cross platform Telerik Native Mobile UI",
            "Advanced Kendo UI"
    };

    private Boolean[] agendaFav3 = {
            true,
            true,
            false,
            true,
            false,
            true,
            false,
            false,
            true
    };

}

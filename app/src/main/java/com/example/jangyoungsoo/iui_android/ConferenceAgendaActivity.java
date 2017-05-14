package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ConferenceAgendaActivity extends AppCompatActivity {

    private ListView listView_agenda;
    private CAListViewAdapter caListViewAdapter1;
    private CAListViewAdapter caListViewAdapter2;
    private CAListViewAdapter caListViewAdapter3;
    private ArrayList<String[]> agenda1;
    private ArrayList<String[]> agenda2;
    private ArrayList<String[]> agenda3;
    public static List<Integer> favoriteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferenceagenda);

        setAgenda();

        listView_agenda = (ListView) findViewById(R.id.listview_agenda);

        caListViewAdapter1 = new CAListViewAdapter(this, agenda1);
        listView_agenda.setAdapter(caListViewAdapter1);

        listView_agenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (favoriteList.contains(Integer.valueOf((int) l))) {
                    favoriteList.remove(Integer.valueOf((int) l));
                } else {
                    favoriteList.add((int) l);
                }
                caListViewAdapter1.notifyDataSetChanged();
            }
        });
    }

    private void setAgenda() {
        String[] data;

        agenda1 = new ArrayList<>();
        for (int i = 0; i < agendaTime1.length; i++) {
            data = new String[4];
            data[0] = agendaTime1[i];
            data[1] = agendaRoom1[i];
            data[2] = agendaTitle1[i];
            data[3] = Integer.toString(i);
            agenda1.add(data);
        }

        agenda2 = new ArrayList<>();
        for (int i = 0; i < agendaTime2.length; i++) {
            data = new String[4];
            data[0] = agendaTime2[i];
            data[1] = agendaRoom2[i];
            data[2] = agendaTitle2[i];
            data[3] = Integer.toString(i);
            agenda2.add(data);
        }

        agenda3 = new ArrayList<>();
        for (int i = 0; i < agendaTime3.length; i++) {
            data = new String[4];
            data[0] = agendaTime3[i];
            data[1] = agendaRoom3[i];
            data[2] = agendaTitle3[i];
            data[3] = Integer.toString(i);
            agenda3.add(data);
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
            "Cross platform Telerik Native Movile UI",
            "Advanced Kendo UI"
    };
}

package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ConferenceAgendaActivity extends AppCompatActivity {

    private ListView listView_agenda;
    private CAListViewAdapter caListViewAdapter;
    private ArrayList<String[]> agenda;
    public static List<Integer> favoriteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferenceagenda);

        setAgenda();

        listView_agenda = (ListView) findViewById(R.id.listview_agenda);

        caListViewAdapter = new CAListViewAdapter(this, agenda);
        listView_agenda.setAdapter(caListViewAdapter);

        listView_agenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (favoriteList.contains(Integer.valueOf((int) l))) {
                    favoriteList.remove(Integer.valueOf((int) l));
                } else {
                    favoriteList.add((int) l);
                }
                caListViewAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setAgenda() {
        agenda = new ArrayList<>();
        String[] data;
        for (int i = 0; i < agendaTime.length; i++) {
            data = new String[4];
            data[0] = agendaTime[i];
            data[1] = agendaRoom[i];
            data[2] = agendaTitle[i];
            data[3] = Integer.toString(i);
            agenda.add(data);
        }
    }

    private String[] agendaTime = {
            "9:30 AM - 12:30 PM",
            "9:30 AM - 12:30 PM",
            "9:30 AM - 12:30 PM",
            "1:30 PM - 4:30 PM",
            "1:30 PM - 4:30 PM",
            "1:30 PM - 4:30 PM"
    };

    private String[] agendaRoom = {
            "ROOM 1",
            "ROOM 2",
            "ROOM 3",
            "ROOM 1",
            "ROOM 2",
            "ROOM 3"
    };

    private String[] agendaTitle = {
            "Android Deep Dive 1",
            "Smart Design for Smartphones",
            "Build, Deploy, and Scale your Mobile Backend with Node.js and Modulus",
            "Android Deep Dive 2",
            "Smart Design for Smartphones",
            "Responsive Apps with Telerik DevCraft"
    };
}

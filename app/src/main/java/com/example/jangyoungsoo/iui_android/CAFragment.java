package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class CAFragment extends Fragment {

    public CAListViewAdapter caListViewAdapter;
    private ArrayList<CAItem> agenda;
//    public SearchView ca_searchview;

    private String[] agendaTime;
    private String[] agendaRoom;
    private String[] agendaTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conferenceagenda, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            agendaTime = bundle.getStringArray("agendaTime");
            agendaRoom = bundle.getStringArray("agendaRoom");
            agendaTitle = bundle.getStringArray("agendaTitle");
        }

        agenda = new ArrayList<>();
        CAItem caitem;
        for (int i = 0; i < agendaTime.length; i++) {
            caitem = new CAItem(agendaTime[i], agendaRoom[i], agendaTitle[i], false);
            agenda.add(caitem);
        }

//        ca_searchview = (SearchView) view.findViewById(R.id.ca_searchView);
        ListView ca_listview = (ListView) view.findViewById(R.id.ca_listView);

        caListViewAdapter = new CAListViewAdapter(getContext(), agenda);

        ca_listview.setAdapter(caListViewAdapter);
        ca_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CAItem caitemClicked = caListViewAdapter.agenda.get((int) l);
                if (caitemClicked.getFav()) {
                    caitemClicked.setFav(false);
                } else {
                    caitemClicked.setFav(true);
                }
                caListViewAdapter.notifyDataSetChanged();
            }
        });

        if (ConferenceAgendaActivity.startSearch) {
            caListViewAdapter.getFilter().filter(ConferenceAgendaActivity.queryText);
        }

//        ConferenceAgendaActivity.ca_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                caListViewAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });

        return view;
    }
}
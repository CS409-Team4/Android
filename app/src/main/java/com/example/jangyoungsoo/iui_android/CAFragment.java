package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class CAFragment extends Fragment {

    public CAListViewAdapter caListViewAdapter;

    private int agendaIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conferenceagenda, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            agendaIndex = bundle.getInt("agenda");
        }

        ListView ca_listview = (ListView) view.findViewById(R.id.ca_listView);

        switch (agendaIndex) {
            case 1:
                caListViewAdapter = new CAListViewAdapter(getContext(), ConferenceAgendaActivity.agenda1);
                break;
            case 2:
                caListViewAdapter = new CAListViewAdapter(getContext(), ConferenceAgendaActivity.agenda2);
                break;
            case 3:
                caListViewAdapter = new CAListViewAdapter(getContext(), ConferenceAgendaActivity.agenda3);
                break;
        }

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

        return view;
    }
}
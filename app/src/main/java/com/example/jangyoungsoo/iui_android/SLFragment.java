package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class SLFragment extends Fragment {

    private Boolean isFavoriteList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selection, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            isFavoriteList = bundle.getBoolean("fav");
        }

        ListView sl_listview = (ListView) view.findViewById(R.id.sl_listView);

        if (isFavoriteList) {
            SelectionActivity.slListViewAdapterFav = new SLListViewAdapter(getContext(), isFavoriteList);
            sl_listview.setAdapter(SelectionActivity.slListViewAdapterFav);
        } else {
            SelectionActivity.slListViewAdapter = new SLListViewAdapter(getContext(), isFavoriteList);
            sl_listview.setAdapter(SelectionActivity.slListViewAdapter);
        }

        sl_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SLItem slitemClicked = SelectionActivity.slItems.get((int) l);

                if (isFavoriteList) {
                    int favIndex = (int) l + 1;
                    for (SLItem slitem : SelectionActivity.slItems) {
                        if (slitem.getFav()) {
                            favIndex--;
                            if (favIndex == 0) {
                                slitemClicked = slitem;
                                break;
                            }
                        }
                    }
                }

                if (slitemClicked.getFav()) {
                    slitemClicked.setFav(false);
                } else {
                    slitemClicked.setFav(true);
                }
                SelectionActivity.slListViewAdapter.notifyDataSetChanged();
                SelectionActivity.slListViewAdapterFav.notifyDataSetChanged();
            }
        });

        return view;
    }

}

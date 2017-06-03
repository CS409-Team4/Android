package com.example.jangyoungsoo.iui_android;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woxthebox.draglistview.DragListView;

import java.util.ArrayList;

public class SLFragment extends Fragment {

    private Boolean isFavoriteList;
    private DragListView mDragListView;

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selection, container, false);

        context = getContext();

        Bundle bundle = getArguments();
        if (bundle != null) {
            isFavoriteList = bundle.getBoolean("fav");
        }

        mDragListView = (DragListView) view.findViewById(R.id.dragListView);
        mDragListView.getRecyclerView().setVerticalScrollBarEnabled(true);
        mDragListView.setDragListListener(new DragListView.DragListListenerAdapter() {
            @Override
            public void onItemDragStarted(int position) {}

            @Override
            public void onItemDragEnded(int fromPosition, int toPosition) {}
        });

        updateSLItemsFav();
        setupListRecyclerView();
        return view;
    }

    public void setupListRecyclerView() {
        mDragListView.setLayoutManager(new LinearLayoutManager(context));

        SLItemAdapter listAdapter;
        if (isFavoriteList) {
            listAdapter = new SLItemAdapter(context, SelectionActivity.slItemsFav, R.layout.sl_listviewitem, R.id.sl_favorite, false);
        } else {
            listAdapter = new SLItemAdapter(context, SelectionActivity.slItems, R.layout.sl_listviewitem, R.id.sl_favorite, false);
        }
        mDragListView.setAdapter(listAdapter, true);
        mDragListView.setCanDragHorizontally(false);
        mDragListView.setDragEnabled(false);
    }

    public void setupListReorder() {
        mDragListView.setLayoutManager(new LinearLayoutManager(context));

        SLItemAdapter listAdapter;
        if (isFavoriteList) {
            listAdapter = new SLItemAdapter(context, SelectionActivity.slItemsFav, R.layout.sl_listviewitemreorder, R.id.sl_reorder, false);
        } else {
            listAdapter = new SLItemAdapter(context, SelectionActivity.slItems, R.layout.sl_listviewitemreorder, R.id.sl_reorder, false);
        }
        mDragListView.setAdapter(listAdapter, true);
        mDragListView.setCanDragHorizontally(false);
        mDragListView.setDragEnabled(true);
    }

    public void updateSLItemsFav() {
        if (isFavoriteList) {
            SelectionActivity.slItemsFav = new ArrayList<>();
            for (SLItem slitem : SelectionActivity.slItems) {
                if (slitem.getFav()) {
                    SelectionActivity.slItemsFav.add(slitem);
                }
            }
        }
    }

}

package com.example.jangyoungsoo.iui_android;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.woxthebox.draglistview.DragListView;

import java.util.ArrayList;

public class SLFragment extends Fragment {

    private Boolean isFavoriteList;
    private DragListView mDragListView;
    private Boolean isReorderMode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selection, container, false);

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

//        ListView sl_listview = (ListView) view.findViewById(R.id.sl_listView);
//
//        if (isFavoriteList) {
//            SelectionActivity.slListViewAdapterFav = new SLListViewAdapter(getContext(), isFavoriteList);
//            sl_listview.setAdapter(SelectionActivity.slListViewAdapterFav);
//        } else {
//            SelectionActivity.slListViewAdapter = new SLListViewAdapter(getContext(), isFavoriteList);
//            sl_listview.setAdapter(SelectionActivity.slListViewAdapter);
//        }
//
//        sl_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                SLItem slitemClicked = SelectionActivity.slItems.get((int) l);
//
//                if (isFavoriteList) {
//                    int favIndex = (int) l + 1;
//                    for (SLItem slitem : SelectionActivity.slItems) {
//                        if (slitem.getFav()) {
//                            favIndex--;
//                            if (favIndex == 0) {
//                                slitemClicked = slitem;
//                                break;
//                            }
//                        }
//                    }
//                }
//
//                if (slitemClicked.getFav()) {
//                    slitemClicked.setFav(false);
//                } else {
//                    slitemClicked.setFav(true);
//                }
//                SelectionActivity.slListViewAdapter.notifyDataSetChanged();
//                SelectionActivity.slListViewAdapterFav.notifyDataSetChanged();
//            }
//        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.activity_selection, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_reorder).setVisible(!isReorderMode);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (isReorderMode) {
                    ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Selection");
                    ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#151F2F")));
                    SelectionActivity.tabLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueBackground));
                    SelectionActivity.tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicator));

                    LinearLayout tabStrip = ((LinearLayout) SelectionActivity.tabLayout.getChildAt(0));
                    for(int i = 0; i < tabStrip.getChildCount(); i++) {
                        tabStrip.getChildAt(i).setClickable(true);
                    }

                    setupListRecyclerView();
                    getActivity().supportInvalidateOptionsMenu();
                } else {
                    getActivity().finish();
                }
                return true;
            case R.id.action_reorder:
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Reorder");
                ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#30BCFF")));
                SelectionActivity.tabLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueBackgroundLight));
                SelectionActivity.tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabIndicatorLight));

                LinearLayout tabStrip = ((LinearLayout) SelectionActivity.tabLayout.getChildAt(0));
                for(int i = 0; i < tabStrip.getChildCount(); i++) {
                    tabStrip.getChildAt(i).setClickable(false);
                }

                setupListReorder();
                getActivity().supportInvalidateOptionsMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupListRecyclerView() {
        mDragListView.setLayoutManager(new LinearLayoutManager(getContext()));

        SLItemAdapter listAdapter;
        if (isFavoriteList) {
            listAdapter = new SLItemAdapter(SelectionActivity.slItemsFav, R.layout.sl_listviewitem, R.id.sl_favorite, false);
        } else {
            listAdapter = new SLItemAdapter(SelectionActivity.slItems, R.layout.sl_listviewitem, R.id.sl_favorite, false);
        }
        mDragListView.setAdapter(listAdapter, true);
        mDragListView.setCanDragHorizontally(false);
        mDragListView.setDragEnabled(false);
        isReorderMode = false;
    }

    private void setupListReorder() {
        mDragListView.setLayoutManager(new LinearLayoutManager(getContext()));

        SLItemAdapter listAdapter;
        if (isFavoriteList) {
            listAdapter = new SLItemAdapter(SelectionActivity.slItemsFav, R.layout.sl_listviewitemreorder, R.id.sl_reorder, false);
        } else {
            listAdapter = new SLItemAdapter(SelectionActivity.slItems, R.layout.sl_listviewitemreorder, R.id.sl_reorder, false);
        }
        mDragListView.setAdapter(listAdapter, true);
        mDragListView.setCanDragHorizontally(false);
        mDragListView.setDragEnabled(true);
        isReorderMode = true;
    }

    private void updateSLItemsFav() {
        SelectionActivity.slItemsFav = new ArrayList<>();
        for (SLItem slitem : SelectionActivity.slItems) {
            if (slitem.getFav()) {
                SelectionActivity.slItemsFav.add(slitem);
            }
        }
    }

}

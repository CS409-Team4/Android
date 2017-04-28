package com.example.subin.softwareproject;

import android.widget.AbsListView;
import android.widget.Adapter;

import java.util.ArrayList;

/**
 * Created by subin on 2017. 4. 22..
 */

public class LazyLoad implements AbsListView.OnScrollListener {
    private int INSERT_COUNT = 10;
    private ArrayList<itemlayout_meta> remain;
    private LazyListAdapter adapter;

    public void LazyLoad(LazyListAdapter adpt, ArrayList<itemlayout_meta> remain_files){
        this.adapter = adpt;
        this.remain = remain_files;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if(view.isShown()){
            // 리스트뷰의 0 번 인덱스 항목이 리스트뷰의 상단에 보이고 있는 경우
            if(firstVisibleItem == 0) {
                // 항목을 추가한다.
                String str;
                for(int i = 0; i < INSERT_COUNT; i++) {
                    //str = "리스트뷰 항목 - " + (totalItemCount + i + 1);
                    this.adapter.addItem(remain.get(i).getFileimg(),remain.get(i).getTitle(), remain.get(i).getAuthor());
                }
                view.setSelection(INSERT_COUNT + 1);
            }
        }

    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }
}

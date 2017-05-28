package com.example.jangyoungsoo.iui_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SLListViewAdapter extends BaseAdapter {

    private Context context;
    private Boolean isFavoriteList;
    private LayoutInflater inflater;

    private TextView tv_title;
    private TextView tv_summary;
    private ImageView iv_favorite;

    public SLListViewAdapter(Context context, Boolean isFavoriteList) {
        this.context = context;
        this.isFavoriteList = isFavoriteList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (isFavoriteList) {
            int favSize = 0;
            for (SLItem slitem : SelectionActivity.slItems) {
                if (slitem.getFav()) {
                    favSize++;
                }
            }
            return favSize;
        }
        return SelectionActivity.slItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.sl_listviewitem, null);
        }

        tv_title = (TextView) view.findViewById(R.id.sl_textView);
        tv_summary = (TextView) view.findViewById(R.id.sl_textView2);
        iv_favorite = (ImageView) view.findViewById(R.id.sl_favorite);

        if (isFavoriteList) {
            int favIndex = position + 1;
            for (SLItem slitem : SelectionActivity.slItems) {
                if (slitem.getFav()) {
                    favIndex--;
                    if (favIndex == 0) {
                        position = slitem.getId();
                        break;
                    }
                }
            }
        }

        SLItem slitem = SelectionActivity.slItems.get(position);
        tv_title.setText(slitem.getTitle());
        tv_summary.setText(slitem.getSummary());

        if (slitem.getFav()) {
            iv_favorite.setVisibility(View.VISIBLE);
        } else {
            iv_favorite.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return SelectionActivity.slItems.get(position);
    }

}

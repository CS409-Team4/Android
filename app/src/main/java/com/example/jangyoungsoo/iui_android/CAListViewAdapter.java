package com.example.jangyoungsoo.iui_android;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CAListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String[]> agenda;
    private LayoutInflater inflater;
    private TextView tv_time;
    private TextView tv_room;
    private TextView tv_title;
    private ImageView iv_favorite;
    private LinearLayout agendum;

    public CAListViewAdapter(Context context, ArrayList<String[]> agenda) {
        this.context = context;
        this.agenda = agenda;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return agenda.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.ca_listviewitem, null);
        }

        tv_time = (TextView) view.findViewById(R.id.tv_time);
        tv_room = (TextView) view.findViewById(R.id.tv_room);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        iv_favorite = (ImageView) view.findViewById(R.id.iv_favorite);
        agendum = (LinearLayout) view.findViewById(R.id.agendum);

        tv_time.setText(agenda.get(position)[0]);
        tv_room.setText(agenda.get(position)[1]);
        tv_title.setText(agenda.get(position)[2]);

        if (ConferenceAgendaActivity.favoriteList.contains(Integer.parseInt(agenda.get(position)[3]))) {
            iv_favorite.setImageResource(R.drawable.add_to_fav_1);
            agendum.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccentLight));
        } else {
            iv_favorite.setImageResource(R.drawable.add_to_fav);
            agendum.setBackgroundColor(ContextCompat.getColor(context, R.color.colorTransparent));
        }

        return view;
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(agenda.get(position)[3]);
    }

    @Override
    public Object getItem(int position) {
        return agenda.get(position);
    }
}

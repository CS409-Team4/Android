package com.example.jangyoungsoo.iui_android;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CAListViewAdapter extends BaseAdapter implements Filterable {
    private Context context;
    public ArrayList<CAItem> agenda;
    private ArrayList<CAItem> mStringFilterList;
    private LayoutInflater inflater;
    private TextView tv_time;
    private TextView tv_room;
    private TextView tv_title;
    private ImageView iv_favorite;
    private LinearLayout agendum;

    ValueFilter valueFilter;

    public CAListViewAdapter(Context context, ArrayList<CAItem> agenda) {
        this.context = context;
        this.agenda = agenda;
        this.mStringFilterList = agenda;
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

        tv_time = (TextView) view.findViewById(R.id.ca_textView);
        tv_room = (TextView) view.findViewById(R.id.ca_textView2);
        tv_title = (TextView) view.findViewById(R.id.ca_textView3);
        iv_favorite = (ImageView) view.findViewById(R.id.iv_favorite);
        agendum = (LinearLayout) view.findViewById(R.id.agendum);

        CAItem caitem = agenda.get(position);
        tv_time.setText(caitem.getTime());
        tv_room.setText(caitem.getRoom());
        tv_title.setText(caitem.getTitle());

        if (caitem.getFav()) {
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
        return position;
    }

    @Override
    public Object getItem(int position) {
        return agenda.get(position);
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<CAItem> filterList = new ArrayList<>();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ((mStringFilterList.get(i).getTitle().toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(mStringFilterList.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            agenda = (ArrayList<CAItem>) results.values;
            notifyDataSetChanged();
        }

    }
}

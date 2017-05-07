package com.example.jangyoungsoo.iui_android;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainGridAdapter extends BaseAdapter {
    private Context mContext;
    private static LayoutInflater inflater = null;

    public class Holder {
        TextView gridText;
        ImageView gridImage;
    }

    public MainGridAdapter(Context c) {
        mContext = c;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return gridImages.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();

        View itemView = inflater.inflate(R.layout.main_grid_item, null);
        holder.gridText =(TextView) itemView.findViewById(R.id.grid_text);
        holder.gridImage =(ImageView) itemView.findViewById(R.id.grid_image);
        holder.gridImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

        holder.gridText.setText(gridTexts[position]);
        holder.gridImage.setImageResource(gridImages[position]);

        return itemView;
    }

    private String[] gridTexts = {
            "Layouts",
            "User profile",
            "Conference agenda",
            "Item layouts",
            "Selection",
            "Naver main"
    };

    private int[] gridImages = {
            R.drawable.screen_layouts,
            R.drawable.screen_user_profile,
            R.drawable.screen_conference_agenda,
            R.drawable.screen_listview_layouts,
            R.drawable.screen_listview_selection,
            R.drawable.screen_naver_mainpage
    };
}
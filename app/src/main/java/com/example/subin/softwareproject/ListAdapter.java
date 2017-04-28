package com.example.subin.softwareproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by subin on 2017. 4. 21..
 */

public class ListAdapter extends BaseAdapter {
    private ArrayList<list_item> listViewItemList = new ArrayList<list_item>() ;

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView img = (ImageView) convertView.findViewById(R.id.img) ;
        TextView txt = (TextView) convertView.findViewById(R.id.txt) ;

        list_item listViewItem = listViewItemList.get(position);

        img.setImageDrawable(listViewItem.getImage());
        txt.setText(listViewItem.getText());

        return convertView;

    }
    public void addItem(String txt, Drawable img) {
        list_item item = new list_item();

        item.setImage(img);
        item.setText(txt);

        listViewItemList.add(item);
    }
}

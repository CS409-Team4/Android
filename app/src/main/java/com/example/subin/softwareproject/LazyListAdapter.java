package com.example.subin.softwareproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by subin on 2017. 4. 21..
 */

public class LazyListAdapter extends BaseAdapter {
    private ArrayList<itemlayout_meta> listViewItemList = new ArrayList<itemlayout_meta>() ;

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
            convertView = inflater.inflate(R.layout.lazy_item, parent, false);
        }

        ImageView img = (ImageView) convertView.findViewById(R.id.file_img) ;
        TextView title = (TextView) convertView.findViewById(R.id.title) ;
        TextView author = (TextView) convertView.findViewById(R.id.author) ;

        itemlayout_meta listViewItem = listViewItemList.get(position);

        img.setImageDrawable(listViewItem.getFileimg());
        title.setText(listViewItem.getTitle());
        author.setText(listViewItem.getAuthor());

        return convertView;

    }
    public void addItem(Drawable img, String title, String author) {
        itemlayout_meta item = new itemlayout_meta();
        item.setMetadata(img, title, author);
        listViewItemList.add(item);
    }
}

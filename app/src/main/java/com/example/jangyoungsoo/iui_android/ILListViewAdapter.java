package com.example.jangyoungsoo.iui_android;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ILListViewAdapter extends BaseAdapter {
    private Context context;
    private String[] recipeTitle;
    private String[] recipeAuthor;
    private Integer[] image;
    private LayoutInflater inflater;
    private ImageView il_imageview;
    private TextView il_textview;
    private TextView il_textview2;
    private Integer height;

    public ILListViewAdapter(Context context, String[] recipeTitle, String[] recipeAuthor, Integer[] image, Integer height) {
        this.context = context;
        this.recipeTitle = recipeTitle;
        this.recipeAuthor = recipeAuthor;
        this.image = image;
        this.height = height;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return recipeTitle.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.il_listviewitem, null);
        }

        il_imageview = (ImageView) view.findViewById(R.id.il_imageView);
        il_textview = (TextView) view.findViewById(R.id.il_textView);
        il_textview2 = (TextView) view.findViewById(R.id.il_textView2);

        il_imageview.setImageResource(image[position]);
        il_imageview.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, this.context.getResources().getDisplayMetrics());
        il_textview.setText(recipeTitle[position]);
        il_textview2.setText("by " + recipeAuthor[position]);

        return view;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return recipeTitle[position];
    }

}
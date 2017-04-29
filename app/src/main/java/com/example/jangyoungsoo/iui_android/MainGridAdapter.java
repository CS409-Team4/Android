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
//        ImageView imageView;
//        if (convertView == null) {
//            // if it's not recycled, initialize some attributes
//            imageView = new ImageView(mContext);
//            final int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, this.mContext.getResources().getDisplayMetrics());
//            final int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, this.mContext.getResources().getDisplayMetrics());
//            imageView.setLayoutParams(new GridView.LayoutParams(width, height));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
//        } else {
//            imageView = (ImageView) convertView;
//        }
//
//        imageView.setImageResource(gridImages[position]);
//        return imageView;

        Holder holder=new Holder();

        View itemView = inflater.inflate(R.layout.main_grid_item, null);
        holder.gridText =(TextView) itemView.findViewById(R.id.grid_text);
        holder.gridImage =(ImageView) itemView.findViewById(R.id.grid_image);

//        final int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, this.mContext.getResources().getDisplayMetrics());
//        final int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, this.mContext.getResources().getDisplayMetrics());
//        holder.gridImage.setLayoutParams(new GridView.LayoutParams(width, height));
        holder.gridImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        holder.gridImage.setPadding(8, 8, 8, 8);

        holder.gridText.setText(gridTexts[position]);
        holder.gridImage.setImageResource(gridImages[position]);

        if (position == 0 || position == 1) {
        }

//        rowView.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();
//            }
//        });

        return itemView;
    }

    private String[] gridTexts = {
            "Layouts",
            "User profile",
            "Conference agenda",
            "Bar series",
            "Line series",
            "Area series",
            "Pie series",
            "Item layouts",
            "Item reorder",
            "selection"
    };

    private int[] gridImages = {
            R.drawable.screen_layouts,
            R.drawable.screen_user_profile,
            R.drawable.screen_conference_agenda,
            R.drawable.screen_bar_chart,
            R.drawable.screen_line_chart,
            R.drawable.screen_area_chart,
            R.drawable.screen_pie_chart,
            R.drawable.screen_listview_layouts,
            R.drawable.screen_reorder,
            R.drawable.screen_listview_selection
    };
}
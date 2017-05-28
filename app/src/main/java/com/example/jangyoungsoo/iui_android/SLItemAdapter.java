package com.example.jangyoungsoo.iui_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.woxthebox.draglistview.DragItemAdapter;

import java.util.ArrayList;

class SLItemAdapter extends DragItemAdapter<SLItem, SLItemAdapter.ViewHolder> {

    private int mLayoutId;
    private int mGrabHandleId;
    private boolean mDragOnLongPress;

    SLItemAdapter(ArrayList<SLItem> list, int layoutId, int grabHandleId, boolean dragOnLongPress) {
        mLayoutId = layoutId;
        mGrabHandleId = grabHandleId;
        mDragOnLongPress = dragOnLongPress;
        setHasStableIds(true);
        setItemList(list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        holder.tv_title.setText(mItemList.get(position).getTitle());
        holder.tv_summary.setText(mItemList.get(position).getSummary());

        if (mItemList.get(position).getFav()) {
            holder.iv_favorite.setVisibility(View.VISIBLE);
        } else {
            holder.iv_favorite.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public long getItemId(int position) {
        return mItemList.get(position).getId();
    }

    class ViewHolder extends DragItemAdapter.ViewHolder {
        TextView tv_title;
        TextView tv_summary;
        ImageView iv_favorite;

        ViewHolder(final View itemView) {
            super(itemView, mGrabHandleId, mDragOnLongPress);
            tv_title = (TextView) itemView.findViewById(R.id.sl_textView);
            tv_summary = (TextView) itemView.findViewById(R.id.sl_textView2);
            iv_favorite = (ImageView) itemView.findViewById(R.id.sl_favorite);
        }

        @Override
        public void onItemClicked(View view) {
            Toast.makeText(view.getContext(), "Item clicked", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClicked(View view) {
            Toast.makeText(view.getContext(), "Item long clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}

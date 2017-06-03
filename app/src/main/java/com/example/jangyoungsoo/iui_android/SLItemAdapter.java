package com.example.jangyoungsoo.iui_android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.woxthebox.draglistview.DragItemAdapter;

import java.util.ArrayList;

class SLItemAdapter extends DragItemAdapter<SLItem, SLItemAdapter.ViewHolder> {

    public final static String EXTRA_MESSAGE = "com.example.jangyoungsoo.iui_android.MESSAGE";

    private Context context;
    private int mLayoutId;
    private int mGrabHandleId;
    private boolean mDragOnLongPress;

    SLItemAdapter(Context context, ArrayList<SLItem> list, int layoutId, int grabHandleId, boolean dragOnLongPress) {
        this.context = context;
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
        holder.position = mItemList.get(position).getId();

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
        LinearLayout itemLayout;
        TextView tv_title;
        TextView tv_summary;
        ImageView iv_favorite;
        Integer position;

        ViewHolder(final View itemView) {
            super(itemView, mGrabHandleId, mDragOnLongPress);
            itemLayout = (LinearLayout) itemView.findViewById(R.id.sl_itemLayout);
            tv_title = (TextView) itemView.findViewById(R.id.sl_textView);
            tv_summary = (TextView) itemView.findViewById(R.id.sl_textView2);
            iv_favorite = (ImageView) itemView.findViewById(R.id.sl_favorite);
        }

        @Override
        public void onItemClicked(View view) {
            if (!SelectionActivity.isEditMode && !SelectionActivity.isReorderMode) {
                Intent intent = new Intent(context, SLDetailActivity.class);
                intent.putExtra(EXTRA_MESSAGE, position);
                context.startActivity(intent);
            } else if (SelectionActivity.isEditMode) {
                if (SelectionActivity.slItemsSelectedIndex.contains(position)) {
                    SelectionActivity.slItemsSelectedIndex.remove(position);
                    SelectionActivity.selectionActivity.setNumberSelected();
                    itemLayout.setBackgroundColor(context.getResources().getColor(R.color.colorTransparent));
                } else {
                    SelectionActivity.slItemsSelectedIndex.add(position);
                    SelectionActivity.selectionActivity.setNumberSelected();
                    itemLayout.setBackgroundColor(context.getResources().getColor(R.color.colorSLBackground));
                }
            }
        }

        @Override
        public boolean onItemLongClicked(View view) {
            if (!SelectionActivity.isEditMode && !SelectionActivity.isReorderMode) {
                SelectionActivity.selectionActivity.editMode();
                SelectionActivity.slItemsSelectedIndex.add(position);
                SelectionActivity.selectionActivity.setNumberSelected();
                itemLayout.setBackgroundColor(context.getResources().getColor(R.color.colorSLBackground));
            }
            return true;
        }
    }
}

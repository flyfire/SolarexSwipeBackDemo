package com.solarexsoft.solarexswipebackdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 11:27/2018/10/12
 *    Desc:
 * </pre>
 */
public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<Integer> mData;

    public CardAdapter(List<Integer> data) {
        mData = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,
                parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        int resource = mData.get(position).intValue();
        holder.iv_avatar.setImageResource(resource);
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setData(List<Integer> data) {
        mData = data;
        notifyDataSetChanged();
    }
}

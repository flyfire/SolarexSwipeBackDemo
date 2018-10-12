package com.solarexsoft.solarexswipebackdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 11:24/2018/10/12
 *    Desc:
 * </pre>
 */
public class CardViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_avatar)
    ImageView iv_avatar;
    @BindView(R.id.iv_like)
    ImageView iv_like;
    @BindView(R.id.iv_dislike)
    ImageView iv_dislike;

    public CardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

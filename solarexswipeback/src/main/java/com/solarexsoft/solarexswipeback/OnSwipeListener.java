package com.solarexsoft.solarexswipeback;

import android.support.v7.widget.RecyclerView;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 09:58/2018/10/11
 *    Desc:
 * </pre>
 */
public interface OnSwipeListener<T> {

    /**
     * 卡片还在滑动时回调
     * @param viewHolder 该滑动卡片的ViewHolder
     * @param ratio 滑动进度的比例
     * @param direction 卡片滑动的方向
     */
    void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction);

    /**
     * 卡片完全滑出时回调
     * @param viewHolder 该滑动卡片的ViewHolder
     * @param t 滑动卡片的数据
     * @param direction 卡片滑动的方向
     */
    void onSwiped(RecyclerView.ViewHolder viewHolder, T t, int direction);

    /**
     * 所有的卡片全部滑出时回调
     */
    void onSwipedClear();
}

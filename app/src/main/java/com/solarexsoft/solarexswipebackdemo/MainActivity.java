package com.solarexsoft.solarexswipebackdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.solarexsoft.solarexswipeback.CardConfig;
import com.solarexsoft.solarexswipeback.CardItemTouchHelperCallback;
import com.solarexsoft.solarexswipeback.CardLayoutManager;
import com.solarexsoft.solarexswipeback.OnSwipeListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_main)
    RecyclerView rv_main;

    CardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        rv_main.setItemAnimator(new DefaultItemAnimator());
        List<Integer> imgs = getData();
        mAdapter = new CardAdapter(imgs);

        final CardItemTouchHelperCallback itemTouchHelperCallback = new CardItemTouchHelperCallback
                (mAdapter, imgs);
        itemTouchHelperCallback.setOnSwipedListener(new OnSwipeListener() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                CardViewHolder holder = (CardViewHolder) viewHolder;
                if (direction == CardConfig.SWIPING_LEFT) {
                    holder.iv_like.setAlpha(Math.abs(ratio));
                } else if (direction == CardConfig.SWIPING_RIGHT) {
                    holder.iv_dislike.setAlpha(Math.abs(ratio));
                } else {
                    holder.iv_dislike.setAlpha(0f);
                    holder.iv_like.setAlpha(0f);
                }
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, Object o, int direction) {
                CardViewHolder holder = (CardViewHolder) viewHolder;
                holder.itemView.setAlpha(1f);
                holder.iv_like.setAlpha(0f);
                holder.iv_dislike.setAlpha(0f);
                Toast.makeText(MainActivity.this, direction == CardConfig.SWIPED_LEFT ? "Swiped " +
                        "Left" : "Swiped Right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipedClear() {
                Toast.makeText(MainActivity.this, "Swipe clear", Toast.LENGTH_SHORT).show();
                rv_main.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       List<Integer> imgs = getData();
                       mAdapter.setData(imgs);
                       itemTouchHelperCallback.setAdapter(mAdapter);
                       itemTouchHelperCallback.setData(imgs);
                    }
                }, 1000);
            }
        });
        final ItemTouchHelper touchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        final CardLayoutManager cardLayoutManager = new CardLayoutManager(rv_main, touchHelper);
        rv_main.setLayoutManager(cardLayoutManager);
        touchHelper.attachToRecyclerView(rv_main);
        rv_main.setAdapter(mAdapter);
    }

    @NonNull
    private List<Integer> getData() {
        List<Integer> imgs = new ArrayList<>();
        imgs.add(R.drawable.img_avatar_01);
        imgs.add(R.drawable.img_avatar_02);
        imgs.add(R.drawable.img_avatar_03);
        imgs.add(R.drawable.img_avatar_04);
        imgs.add(R.drawable.img_avatar_06);
        imgs.add(R.drawable.img_avatar_07);
        return imgs;
    }
}

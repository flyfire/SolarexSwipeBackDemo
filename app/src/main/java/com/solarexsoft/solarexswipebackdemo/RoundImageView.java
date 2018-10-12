package com.solarexsoft.solarexswipebackdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 10:10/2018/10/12
 *    Desc:
 * </pre>
 */
public class RoundImageView extends ImageView {
    private Path mPath;
    private RectF mRectF;
    private float[] radius = new float[8];
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView);
        float attrRadius = typedArray.getDimension(R.styleable.RoundImageView_radius, 10);
        radius[0] = attrRadius;
        radius[1] = attrRadius;
        radius[2] = attrRadius;
        radius[3] = attrRadius;
        radius[4] = 0f;
        radius[5] = 0f;
        radius[6] = 0f;
        radius[7] = 0f;
        typedArray.recycle();
        mPath = new Path();
        mRectF = new RectF();
        mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRectF.set(0, 0, w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPath.reset();
        mPath.addRoundRect(mRectF, radius, Path.Direction.CW);
        canvas.setDrawFilter(mPaintFlagsDrawFilter);
        canvas.save();
        canvas.clipPath(mPath);
        super.onDraw(canvas);
        canvas.restore();
    }
}

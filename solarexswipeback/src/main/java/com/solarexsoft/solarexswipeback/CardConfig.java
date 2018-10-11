package com.solarexsoft.solarexswipeback;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 15:44/2018/10/10
 *    Desc:
 * </pre>
 */
public final class CardConfig {
    // 显示可见的卡片数量
    public static final int DEFAULT_SHOW_ITEMS = 3;

    // 默认缩放的比例
    public static final float DEFAULT_SCALE = 0.1f;

    // 卡片y轴偏移量
    public static final int DEFAULT_TRANSLATE_Y = 14;

    // 卡片滑动时默认倾斜的角度
    public static final float DEFAULT_ROTATE_DEGREE = 15f;

    // 卡片滑动时不偏左也不偏右
    public static final int SWIPING_NONE = 1;

    // 卡片向左滑动时
    public static final int SWIPING_LEFT = 1 << 2;

    // 卡片向右滑动时
    public static final int SWIPING_RIGHT = 1 << 3;

    // 卡片从左边滑出
    public static final int SWIPED_LEFT = 1 << 4;

    // 卡片从右边滑出
    public static final int SWIPED_RIGHT = 1 << 5;
}

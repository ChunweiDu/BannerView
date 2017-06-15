package com.dcw.bannerviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @Author： duchunwei
 * @Date: 2017/6/14   15:46
 * @Email： duchunwei_it@163.com
 * 动画相关
 */

public class CustomTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.95F;

    @Override
    public void transformPage(View page, float position) {

        if (position < -1) {
            page.setScaleY(MIN_SCALE);
        } else if (position <= 1) {
            float scale = Math.max(MIN_SCALE, 1 - Math.abs(position));
            page.setScaleY(scale);
        } else {
            page.setScaleY(MIN_SCALE);
        }
    }
}

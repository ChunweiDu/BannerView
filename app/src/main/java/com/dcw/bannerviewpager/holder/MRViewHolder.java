package com.dcw.bannerviewpager.holder;

import android.content.Context;
import android.view.View;

/**
 * @Author： duchunwei
 * @Date: 2017/6/14   15:40
 * @Email： duchunwei_it@163.com
 * ViewHolder接口
 */

public interface MRViewHolder<T> {

    /**
     * 创建View
     *
     * @param context
     */
    View createView(Context context);

    /**
     * 绑定数据
     *
     * @param context
     * @param position
     * @param data
     */
    void onBind(Context context, int position, T data);
}

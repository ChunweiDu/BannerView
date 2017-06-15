package com.dcw.bannerviewpager.holder;

/**
 * @Author： duchunwei
 * @Date: 2017/6/14   15:42
 * @Email： duchunwei_it@163.com
 * 构造ViewHolder接口
 */
public interface MRHolderCreator<VH extends MRViewHolder> {
    /**
     * 创建ViewHolder
     *
     * @return
     */
    VH createViewHolder();
}

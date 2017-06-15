package com.dcw.bannerviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.dcw.bannerviewpager.BannerView.MRBannerView;
import com.dcw.bannerviewpager.holder.MRHolderCreator;
import com.dcw.bannerviewpager.holder.MRViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MRBannerView mMRBanner;
    private List<BannerResId> mDatas = new ArrayList();

    private int[] resId = {R.mipmap.banner01, R.mipmap.banner02, R.mipmap.banner03, R.mipmap.banner04
            , R.mipmap.banner05};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mMRBanner.setPages(mDatas, new MRHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
    }

    private void initData() {
        for (int i = 0; i < resId.length; i++) {
            BannerResId bannerResId = new BannerResId(resId[i]);
            mDatas.add(bannerResId);
        }
    }

    private void initView() {
        mMRBanner = (MRBannerView) findViewById(R.id.banner);
        //设置BannerView 的切换时间间隔
        mMRBanner.setDelayedTime(5000);
        //设置是否显示Indicator
        mMRBanner.setIndicatorVisible(false);
        //设置ViewPager（Banner）切换速度
        mMRBanner.setDuration(1000);
    }

    public static class BannerViewHolder implements MRViewHolder<BannerResId> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, BannerResId data) {
            // 数据绑定
            mImageView.setImageResource(data.getResId());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mMRBanner.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        mMRBanner.start();//开始轮播
    }
}

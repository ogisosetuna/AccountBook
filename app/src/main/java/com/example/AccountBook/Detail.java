package com.example.AccountBook;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Detail extends FragmentActivity implements View.OnClickListener{
    private static final int NUM_PAGES = 2;
    private TextView item_detail, item_category_report;
    private ViewPager2 vp;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentStateAdapter mFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();

        mFragmentAdapter = new ScreenSlidePagerAdapter(this,mFragmentList);
//        vp.setOffscreenPageLimit(2);//ViewPager的缓存为2帧
        vp.setAdapter(mFragmentAdapter);
//        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧
        item_detail.setTextColor(Color.parseColor("#1ba0e1"));

        //ViewPager的监听事件



//        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                /*此方法在页面被选中时调用*/
//                changeTextColor(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
//                arg0==1的时辰默示正在滑动，
//                arg0==2的时辰默示滑动完毕了，
//                arg0==0的时辰默示什么都没做。*/
//            }
//        });
    }

    /**
     * 初始化布局View
     */
    private void initViews() {
        item_detail = (TextView) findViewById(R.id.item_detail);
        item_category_report = (TextView) findViewById(R.id.item_category_report);

        item_detail.setOnClickListener(this);
        item_category_report.setOnClickListener(this);

        vp = findViewById(R.id.mainViewPager);
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        //给FragmentList添加数据
        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
    }

    /**
     * 点击头部Text 动态修改ViewPager的内容
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_detail:
                changeTextColor(0);
                vp.setCurrentItem(0, true);
                break;
            case R.id.item_category_report:
                changeTextColor(1);
                vp.setCurrentItem(1, true);
                break;
        }
    }

    /**
     * 由ViewPager的滑动修改头部导航Text的颜色
     * @param position
     */
    private void changeTextColor(int position) {
        if (position == 0) {
            item_detail.setTextColor(Color.parseColor("#1ba0e1"));
            item_category_report.setTextColor(Color.parseColor("#000000"));
        } else if (position == 1) {
            item_category_report.setTextColor(Color.parseColor("#1ba0e1"));
            item_detail.setTextColor(Color.parseColor("#000000"));
        }
    }

    /**
     * 返回键
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        public ScreenSlidePagerAdapter(FragmentActivity fa, List<Fragment> fragmentList) {
            super(fa);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment createFragment(int position) {
            if (position == 0){
                return new OneFragment();
            }
            else{
                return new TwoFragment();
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }



}

package com.example.AccountBook;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class CountActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int NUM_PAGES = 2;
    private TextView tv_year;
    private TextView item_detail, item_category_report;
    private Button btnAddRecord;
    private ViewPager2 vp;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentStateAdapter mFragmentAdapter;

    private Spinner month_spinner;
    private ArrayAdapter<String> month_adapter;

    private AlertDialog alertDialog_AddRecord;//点击记一笔按钮时弹出提示框

    String[] titles = new String[]{"明细", "类别报表"};
    private static final String[] yearList = {pubFun.getTime("Y") + "年"};
    private static final String[] monthList = { "01月", "02月", "03月", "04月", "05月", "06月", "07月", "08月", "09月", "10月", "11月", "12月" };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除工具栏
        getSupportActionBar().hide();
        setContentView(R.layout.count);

        initViews();

        initSpinner();

        mFragmentAdapter = new ScreenSlidePagerAdapter(this,mFragmentList);
//        vp.setOffscreenPageLimit(2);//ViewPager的缓存为2帧
        vp.setAdapter(mFragmentAdapter);
//        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧
        item_detail.setTextColor(Color.parseColor("#1ba0e1"));


    }

    /**
     * 初始化布局View
     */
    private void initViews() {
        //title = (TextView) findViewById(R.id.title);
        tv_year = (TextView) findViewById(R.id.tv_year);
        tv_year.setText(yearList[0]);

        btnAddRecord = (Button) findViewById(R.id.btnAddRecord);

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
     * 初始化spinner
     */
    private void initSpinner(){
        month_spinner = (Spinner) findViewById(R.id.month_spinner);
        //将可选内容与ArrayAdapter连接起来
        month_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, monthList);
        //设置下拉列表的风格
        month_adapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter添加到spinner中
        month_spinner.setAdapter(month_adapter);
        //添加事件Spinner事件监听
        month_spinner
                .setOnItemSelectedListener(new month_spinnerSelectedListener());
        //设置默认值
        month_spinner.setSelection(pubFun.getTime("M"), true);
        month_spinner.setVisibility(View.VISIBLE);
    }

    /**
     * 选择 月份 事件 监听器
     */
    class month_spinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            int pos = month_spinner.getSelectedItemPosition();
        }
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    /**
     * 点击底部Text 动态修改ViewPager的内容
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
     * 由ViewPager的滑动修改底部导航Text的颜色
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode== KeyEvent.KEYCODE_BACK) {//返回键
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

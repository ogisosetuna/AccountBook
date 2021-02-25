package com.example.AccountBook;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Created by littlecurl 2018/6/24
 */

/**
 * 此类 implements View.OnClickListener 之后，
 * 就可以把onClick事件写到onCreate()方法之外
 * 这样，onCreate()方法中的代码就不会显得很冗余
 */
public class MainActivity extends AppCompatActivity {

    //第一次点击事件发生的时间
    private long mExitTime;

    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[] { "登录&注册", "关于我们", "目标",
            "设置", "收入&支出", "统计" };
    private int[] mItemImgs = new int[] { R.mipmap.home_mbank_1_normal,
            R.mipmap.home_mbank_2_normal, R.mipmap.home_mbank_3_normal,
            R.mipmap.home_mbank_4_normal, R.mipmap.home_mbank_5_normal,
            R.mipmap.home_mbank_6_normal };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                if (mItemTexts[pos] == "设置") {
                    //openSettingWind(view);
                } else if (mItemTexts[pos] == "收入&支出") {
                    openSpendingWind(view);
                } else if (mItemTexts[pos] == "登录&注册") {
                    openLoginWind(view);
                } else if (mItemTexts[pos] == "统计") {
                    openCountWind(view);
                } else if (mItemTexts[pos] == "关于我们") {
                    openAboutUsAddWind(view);
                } else if (mItemTexts[pos] == "目标") {
                    //openWishWind(view);
                }

            }
            @Override
            public void itemCenterClick(View view) {
                Toast.makeText(MainActivity.this, "you can do something", Toast.LENGTH_SHORT).show();
            }
        });
//        initView();
    }

    /**
     * 跳转至登录&注册界面
     * @param v
     */
    private void openLoginWind(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, LoginActivity.class);
        this.startActivity(intent);
    }

    /**
     * 跳转至开销界面，记录收入与支出
     * @param v
     */
    private void openSpendingWind(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SpendingActivity.class);
        this.startActivity(intent);
    }


    /**
     * 跳转至统计界面
     * @param v
     */
    private void openCountWind(View v){
        Intent intent=new Intent();
        intent.setClass(MainActivity.this, CountActivity.class);
        this.startActivity(intent);
    }


    /**
     * 跳转至特色设置界面
     * @param v
     */

    private void openSettingWind(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SettingActivity.class);
        this.startActivity(intent);
    }

    /**
     * 跳转至心愿墙界面
     * @param v
     */
    private void openWishWind(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, WishActivity.class);
        this.startActivity(intent);
    }

    /**
     * 跳转至关于我们界面
     * @param v
     */
    private void openAboutUsAddWind(View v){
        Intent intent=new Intent();
        intent.setClass(MainActivity.this, AboutusActivity.class);
        this.startActivity(intent);
    }

    /**
     * 点击两次返回退出app
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Object mHelperUtils;
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                //System.currentTimeMillis()系统当前时间
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }




//    private void initView() {
//        // 初始化控件对象
//        Button mBtMainLogout = findViewById(R.id.bt_main_logout);
//        Button mBtMainDetail = findViewById(R.id.sym_det);
//        Button mBtMaininout = findViewById(R.id.bt_in_out);
//        Button mBtMaincount = findViewById(R.id.bt_count);
//        // 绑定点击监听器
//        mBtMainLogout.setOnClickListener(this);
//        mBtMainDetail.setOnClickListener(this);
//        mBtMaininout.setOnClickListener(this);
//        mBtMaincount.setOnClickListener(this);
//    }

//    public void onClick(View view) {
//        if (view.getId() == R.id.bt_main_logout) {
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
//        if (view.getId() == R.id.sym_det){
//            Intent intent1 = new Intent(this, Detail.class);
//            startActivity(intent1);
//            finish();
//        }
//        if (view.getId() == R.id.bt_in_out){
//            Intent intent2 = new Intent(this, SpendingActivity.class);
//            startActivity(intent2);
//            finish();
//        }
//        if (view.getId() == R.id.bt_count){
//            Intent intent3 = new Intent(this, CountActivity.class);
//            startActivity(intent3);
//            finish();
//        }
//
//    }
}

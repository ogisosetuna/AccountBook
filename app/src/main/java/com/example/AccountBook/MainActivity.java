package com.example.AccountBook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Created by littlecurl 2018/6/24
 */

/**
 * 此类 implements View.OnClickListener 之后，
 * 就可以把onClick事件写到onCreate()方法之外
 * 这样，onCreate()方法中的代码就不会显得很冗余
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        // 初始化控件对象
        Button mBtMainLogout = findViewById(R.id.bt_main_logout);
        Button mBtMainDetail = findViewById(R.id.sym_det);
        // 绑定点击监听器
        mBtMainLogout.setOnClickListener(this);
        mBtMainDetail.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.bt_main_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        if (view.getId() == R.id.sym_det){
            Intent intent1 = new Intent(this, Detail.class);
            startActivity(intent1);
            finish();
        }
    }
}

package com.example.AccountBook;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutusActivity extends AppCompatActivity {
    private TextView tvAboutUs;
    private TextView tvIntroduce;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
    }
}

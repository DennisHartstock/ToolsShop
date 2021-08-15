package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ImageView imageViewDrill = findViewById(R.id.imageViewDrill);
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        TextView textViewInfo = findViewById(R.id.textViewInfo);
        Intent intent = getIntent();
        if (intent.hasExtra("resId") && intent.hasExtra("title") && intent.hasExtra("info")) {
            int resId = intent.getIntExtra("resId", -1);
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            imageViewDrill.setImageResource(resId);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
        } else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}
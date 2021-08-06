package com.example.toolsshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ListView listViewTools = findViewById(R.id.listViewTools);
        listViewTools.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    Intent intent = new Intent(getApplicationContext(), DrillCategoryActivity.class);
                    startActivity(intent);
                    break;
            }
        });
    }
}
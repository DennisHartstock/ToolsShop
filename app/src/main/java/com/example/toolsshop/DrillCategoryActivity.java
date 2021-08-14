package com.example.toolsshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    private ArrayList<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        drills = new ArrayList<>();
        drills.add(new Drill(getString(R.string.drill_interskol_title), getString(R.string.drill_interskol_info), R.drawable.interskol));
        drills.add(new Drill(getString(R.string.drill_makita_title), getString(R.string.drill_makita_info), R.drawable.makita));
        drills.add(new Drill(getString(R.string.drill_dewalt_title), getString(R.string.drill_dewalt_info), R.drawable.dewalt));
        ListView listViewDrills = findViewById(R.id.listViewDrills);
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, drills);
        listViewDrills.setAdapter(adapter);
        listViewDrills.setOnItemClickListener((parent, view, position, id) -> {
            Drill drill = drills.get(position);
            Intent intent = new Intent(getApplicationContext(), DrillDetailActivity.class);
            intent.putExtra("title", drill.getTitle());
            intent.putExtra("info", drill.getInfo());
            intent.putExtra("resId", drill.getImageResourceId());
            startActivity(intent);
        });
    }
}
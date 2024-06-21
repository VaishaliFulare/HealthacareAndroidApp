package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticleActivity extends AppCompatActivity {
    private String[][] healthcare_details = {
            {"Walking Daily", "", "", "", "Click more details"},
            {"Home Care for Covid-19", "", "", "", "Click more details"},
            {"Stop Smoking", "", "", "", "Click more details"},
            {"Menstrual Camps ", "", "", "", "Click more details"},
            {"Healthy Gut", "", "", "", "Click more details"}
    };

    private int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5
    };

    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    ListView lst;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);

        lst = findViewById(R.id.ListViewHA);
        btnback = findViewById(R.id.buttonHAback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticleActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < healthcare_details.length; i++) {
            item = new HashMap<>();
            item.put("line1", healthcare_details[i][0]);
            item.put("line2", healthcare_details[i][1]);
            item.put("line3", healthcare_details[i][2]);
            item.put("line4", healthcare_details[i][3]);
            item.put("line5", healthcare_details[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(HealthArticleActivity.this, HealthArticleDetailActivity.class);
                it.putExtra("text1", healthcare_details[i][0]);
                it.putExtra("imageResourceId", images[i]); // Ensure key matches retrieval
                startActivity(it);
            }
        });
    }
}

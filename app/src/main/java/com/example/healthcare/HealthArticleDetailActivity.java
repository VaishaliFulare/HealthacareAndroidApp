package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticleDetailActivity extends AppCompatActivity {

    TextView tv1;
    ImageView img;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_detail);

        btnback = findViewById(R.id.buttonHADback);
        tv1 = findViewById(R.id.textviewHADtitle);
        img = findViewById(R.id.ImageViewHAD);

        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("imageResourceId"); // Ensure key matches intent extra
            img.setImageResource(resId);
        }

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticleDetailActivity.this, HealthArticleActivity.class));
            }
        });
    }
}


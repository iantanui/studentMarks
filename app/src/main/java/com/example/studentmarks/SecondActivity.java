package com.example.studentmarks;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView tvMax, tvMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        tvMax = findViewById(R.id.tvMax);
        tvMin = findViewById(R.id.tvMin);

        int max = getIntent().getIntExtra("MAX_VALUE", 0);
        int min = getIntent().getIntExtra("MIN_VALUE", 0);

        tvMax.setText(String.valueOf(max));
        tvMin.setText(String.valueOf(min));
    }
}

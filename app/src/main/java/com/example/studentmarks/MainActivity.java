package com.example.studentmarks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2, etNum3, etAnswer;
    private Button btnMaximum, btnMinimum, btnSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etNum3 = findViewById(R.id.etNum3);
        etAnswer = findViewById(R.id.etAnswer);

        btnMaximum = findViewById(R.id.btnMaximum);
        btnMinimum = findViewById(R.id.btnMinimum);

        btnSecondActivity = findViewById(R.id.btnSecondActivity);


        btnMaximum.setOnClickListener(view -> calculateMaximum());

        btnMinimum.setOnClickListener(view -> calculateMinimum());

        btnSecondActivity.setOnClickListener(view -> goToSecondActivity());
    }

    private void calculateMaximum() {
        try {
            int num1 = Integer.parseInt(etNum1.getText().toString().trim());
            int num2 = Integer.parseInt(etNum2.getText().toString().trim());
            int num3 = Integer.parseInt(etNum3.getText().toString().trim());

            int max = Math.max(num1, Math.max(num2, num3));

            etAnswer.setText(String.valueOf(max));
        } catch (NumberFormatException e) {
            etAnswer.setText("Invalid input. Enter numbers");
        }
    }

    private void calculateMinimum() {
        try {
            int num1 = Integer.parseInt(etNum1.getText().toString().trim());
            int num2 = Integer.parseInt(etNum2.getText().toString().trim());
            int num3 = Integer.parseInt(etNum3.getText().toString().trim());

            int min = Math.min(num1, Math.min(num2, num3));

            etAnswer.setText(String.valueOf(min));
        } catch (NumberFormatException e) {
            etAnswer.setText("Invalid input. Enter numbers.");
        }
    }

    private void goToSecondActivity() {
        int num1 = Integer.parseInt(etNum1.getText().toString().trim());
        int num2 = Integer.parseInt(etNum2.getText().toString().trim());
        int num3 = Integer.parseInt(etNum3.getText().toString().trim());

        int max = Math.max(num1, Math.max(num2, num3));
        int min = Math.min(num1, Math.min(num2, num3));

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("MAX_VALUE", max);
        intent.putExtra("MIN_VALUE", min);
        startActivity(intent);
    }
}
package com.example.button_counter_powell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counterVal = 0;
    Button resetBtn;
    Button incBtn;
    Button decBtn;
    TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetBtn = findViewById(R.id.resetButton);
        incBtn = findViewById(R.id.incrementButton);
        decBtn = findViewById(R.id.decrementButton);
        counterText = findViewById(R.id.counterText);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVal = 0;
                counterText.setText(String.valueOf(counterVal));
            }
        });

        incBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVal ++;
                counterText.setText(String.valueOf(counterVal));
            }
        });

        decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVal --;
                counterText.setText(String.valueOf(counterVal));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counterVal", counterVal);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counterVal = savedInstanceState.getInt("counterVal");
        counterText.setText(String.valueOf(counterVal));
    }
}

package com.example.button_counter_powell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counterVal = 0;
    private int wowFactor = 0;
    Button resetBtn;
    Button incBtn;
    Button decBtn;
    Button wowBtn;
    TextView counterText;
    ImageView theBoy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetBtn = findViewById(R.id.resetButton);
        incBtn = findViewById(R.id.incrementButton);
        decBtn = findViewById(R.id.decrementButton);
        wowBtn = findViewById(R.id.wowBtn);
        counterText = findViewById(R.id.counterText);
        theBoy = findViewById(R.id.theBoy);
        theBoy.setVisibility(View.INVISIBLE);
        final MediaPlayer goodSong = MediaPlayer.create(this, R.raw.classic);

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

        wowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wowFactor == 0){
                    wowBtn.setText("Don't tap me! (do it)");
                    wowFactor ++;
                }
                else if (wowFactor == 1){
                    wowBtn.setText("You asked for it...");
                    theBoy.setVisibility(View.VISIBLE);
                    resetBtn.setVisibility(View.INVISIBLE);
                    incBtn.setVisibility(View.INVISIBLE);
                    decBtn.setVisibility(View.INVISIBLE);
                    counterText.setVisibility(View.INVISIBLE);
                    goodSong.start();
                    wowFactor ++;
                }
                else {
                    wowFactor = 0;
                    theBoy.setVisibility(View.INVISIBLE);
                    resetBtn.setVisibility(View.VISIBLE);
                    incBtn.setVisibility(View.VISIBLE);
                    decBtn.setVisibility(View.VISIBLE);
                    counterText.setVisibility(View.VISIBLE);
                    wowBtn.setText("That was fun");
                    goodSong.pause();
                }
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

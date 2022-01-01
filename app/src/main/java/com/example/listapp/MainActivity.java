package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView resultTextView, randomTextView;
    private Button button;
    private int max = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        resultTextView = (TextView) findViewById(R.id.resultsTextView);
        button = (Button) findViewById(R.id.rollButton);
        randomTextView = (TextView) findViewById(R.id.randomTextView);

        Random rand = new Random();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                max = progress;
                resultTextView.setText(String.valueOf(max));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomTextView.setText(String.valueOf(rand.nextInt(max) + 1));
            }
        });
    }
}
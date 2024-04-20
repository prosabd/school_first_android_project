package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSolution1 = findViewById(R.id.btnParam1);
        Button btnSolution2 = findViewById(R.id.btnParam2);
        TextView seekBarValue = findViewById(R.id.seekBarValue);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText editText = findViewById(R.id.editText);
        CheckBox checkBox = findViewById(R.id.checkBox);
        SeekBar seekBar = findViewById(R.id.seekBar);

        btnSolution1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, app1.class);
                intent.putExtra("editText", editText.getText().toString());
                intent.putExtra("checkBox", checkBox.isChecked());
                intent.putExtra("seekBar", seekBar.getProgress());
                startActivity(intent);
            }
        });

        btnSolution2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("editText", editText.getText().toString());
                bundle.putBoolean("checkBox", checkBox.isChecked());
                bundle.putInt("seekBar", seekBar.getProgress());

                Intent intent = new Intent(MainActivity.this, app2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        seekBar.setMax(100); // Set the maximum value to 100

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // The 'progress' parameter contains the current value of the SeekBar
                seekBarValue.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
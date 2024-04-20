package com.example.myapplication;

import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class app1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app1);
        // Dans app1.java
        Intent intent = getIntent();
        String editText = intent.getStringExtra("editText");
        boolean checkBox = intent.getBooleanExtra("checkBox", false);
        int seekBar = intent.getIntExtra("seekBar", 0);

        Toast.makeText(this, "EditText: " + editText + ",\n CheckBox: " + checkBox + ",\n SeekBar: " + seekBar, Toast.LENGTH_LONG).show();
        Intent intentReturn = new Intent(app1.this, MainActivity.class);
        startActivity(intentReturn);
    }

}
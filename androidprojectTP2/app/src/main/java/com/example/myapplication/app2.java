package com.example.myapplication;

import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class app2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app2);
        // Dans app2.java
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String editText = bundle.getString("editText");
            boolean checkBox = bundle.getBoolean("checkBox");
            int seekBar = bundle.getInt("seekBar");

            Toast.makeText(this, "EditText: " + editText + ",\n CheckBox: " + checkBox + ",\n SeekBar: " + seekBar, Toast.LENGTH_LONG).show();
            Intent intentReturn = new Intent(app2.this, MainActivity.class);
            startActivity(intentReturn);
        }
    }

}
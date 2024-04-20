// Nouveau.java
package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Nouveau extends AppCompatActivity {
    private EditText editName, editFirstname, editAge;
    private Button btnValidate, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau);

        init();
    }

    private void init() {
        editName = findViewById(R.id.editName);
        editFirstname = findViewById(R.id.editFirstname);
        editAge = findViewById(R.id.editAge);
        btnValidate = findViewById(R.id.btnValidate);
        btnCancel = findViewById(R.id.btnCancel);
        setListeners();
    }

    private void setListeners() {
        btnValidate.setOnClickListener(v -> validate());
        btnCancel.setOnClickListener(v -> cancel());
    }

    private void validate() {
        String name = editName.getText().toString();
        String firstname = editFirstname.getText().toString();
        String ageStr = editAge.getText().toString();

        if (name.isEmpty() || firstname.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("name", name);
        resultIntent.putExtra("firstname", firstname);
        resultIntent.putExtra("age", age);
        setResult(Activity.RESULT_OK, resultIntent);
        Toast.makeText(this, "Personne validée", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void cancel() {
        setResult(Activity.RESULT_CANCELED);
        Toast.makeText(this, "Personne annulée", Toast.LENGTH_SHORT).show();
        finish();
    }
}

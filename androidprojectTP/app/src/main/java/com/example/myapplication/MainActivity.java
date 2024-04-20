// MainActivity.java
package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnNew;
    private ListView listPersons;
    private List<Person> persons = new ArrayList<>();
    private ArrayAdapter<Person> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btnNew = findViewById(R.id.btnNew);
        listPersons = findViewById(R.id.listPersons);

        // Assuming you have a list of persons and an adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, persons);
        listPersons.setAdapter(adapter);

        btnNew.setOnClickListener(v -> {
            Intent intent = new Intent(this, Nouveau.class);
            startActivityForResult(intent, 1);
        });
    }

    private void setListeners() {
        btnNew.setOnClickListener(v -> {
            Intent intent = new Intent(this, Nouveau.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String name = data.getStringExtra("name");
            String firstname = data.getStringExtra("firstname");
            int age = data.getIntExtra("age", 0);

            Person person = new Person(name, firstname, age);
            persons.add(person);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Personne ajoutée : " + person.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}

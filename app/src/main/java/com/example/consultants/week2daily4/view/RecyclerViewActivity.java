package com.example.consultants.week2daily4.view;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.consultants.week2daily4.AnimalDatabase;
import com.example.consultants.week2daily4.R;
import com.example.consultants.week2daily4.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvAnimalList;
    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    List<Animal> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //get category info from the intent
        String category = getIntent().getStringExtra("CATEGORY");

        AnimalDatabase animalDatabase = new AnimalDatabase(this);
        //use cursor to iterate through DB fields and set them into animal objects
        Cursor cursor = animalDatabase.getAnimals(category);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                Animal animal = new Animal(cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getBlob(4), cursor.getInt(5));
                animalList.add(animal);
            }
        }

        //set adapter on the list of animals
        adapter = new RecyclerViewAdapter(animalList);
        layoutManager = new LinearLayoutManager(this);
        rvAnimalList = findViewById(R.id.rvAnimalList);
        rvAnimalList.setAdapter(adapter);
        rvAnimalList.setLayoutManager(layoutManager);
    }
}

package com.example.consultants.week2daily4;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.consultants.week2daily4.model.Animal;
import com.example.consultants.week2daily4.view.ListViewActivity;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
    }

    public void goToCategories(View view) {
        Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
        startActivity(intent);
    }

    public void populateDB(View view) {

        //create database
        AnimalDatabase animalDatabase = new AnimalDatabase(this);

        //Add tiger to DB
        Drawable d = getResources().getDrawable(R.drawable.tiger);
        Bitmap bmTiger = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamTiger = new ByteArrayOutputStream();
        bmTiger.compress(Bitmap.CompressFormat.JPEG, 100, streamTiger);
        byte[] imgTiger = streamTiger.toByteArray();
        animalDatabase.insertAnimal("MAMMALS", "Tiger", "220", imgTiger, R.raw.tigersound);

        //Add cow to DB
        d = getResources().getDrawable(R.drawable.cow);
        Bitmap bmCow = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamCow = new ByteArrayOutputStream();
        bmCow.compress(Bitmap.CompressFormat.JPEG, 100, streamCow);
        byte[] imgCow = streamCow.toByteArray();
        animalDatabase.insertAnimal("MAMMALS", "Cow", "345", imgCow, R.raw.cowsound);

        //Add duck to DB
        d = getResources().getDrawable(R.drawable.duck);
        Bitmap bmDuck = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamDuck = new ByteArrayOutputStream();
        bmDuck.compress(Bitmap.CompressFormat.JPEG, 100, streamDuck);
        byte[] imgDuck = streamDuck.toByteArray();
        animalDatabase.insertAnimal("BIRDS", "Duck", "10", imgDuck, R.raw.ducksound);

    }

    public void showDB(View view) {
        String result = "";
        AnimalDatabase animalDatabase = new AnimalDatabase(this);
        Cursor cursor = animalDatabase.getAnimals("MAMMALS");
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                Animal animal = new Animal(cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getBlob(4), cursor.getInt(5));
                result += cursor.getString(1) + " " + cursor.getString(2);
            }
            tvResult.setText(result);
        }
    }
}

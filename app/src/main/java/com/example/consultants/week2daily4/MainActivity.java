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
        animalDatabase.insertAnimal("MAMMALS", "Tiger", "350", imgTiger, R.raw.tigersound);

        //Add cow to DB
        d = getResources().getDrawable(R.drawable.cow);
        Bitmap bmCow = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamCow = new ByteArrayOutputStream();
        bmCow.compress(Bitmap.CompressFormat.JPEG, 100, streamCow);
        byte[] imgCow = streamCow.toByteArray();
        animalDatabase.insertAnimal("MAMMALS", "Cow", "2000", imgCow, R.raw.cowsound);

        //Add monkey to DB
        d = getResources().getDrawable(R.drawable.monkey);
        Bitmap bmMonkey = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamMonkey = new ByteArrayOutputStream();
        bmMonkey.compress(Bitmap.CompressFormat.JPEG, 100, streamMonkey);
        byte[] imgMonkey = streamMonkey.toByteArray();
        animalDatabase.insertAnimal("MAMMALS", "Monkey", "45", imgMonkey, R.raw.monkeysound);

        //Add pig to DB
        d = getResources().getDrawable(R.drawable.pig);
        Bitmap bmPig = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamPig = new ByteArrayOutputStream();
        bmPig.compress(Bitmap.CompressFormat.JPEG, 100, streamPig);
        byte[] imgPig = streamPig.toByteArray();
        animalDatabase.insertAnimal("MAMMALS", "Pig", "180", imgPig, R.raw.pigsound);

        //Add duck to DB
        d = getResources().getDrawable(R.drawable.duck);
        Bitmap bmDuck = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamDuck = new ByteArrayOutputStream();
        bmDuck.compress(Bitmap.CompressFormat.JPEG, 100, streamDuck);
        byte[] imgDuck = streamDuck.toByteArray();
        animalDatabase.insertAnimal("BIRDS", "Duck", "2", imgDuck, R.raw.ducksound);

    }

}

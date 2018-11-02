package com.example.consultants.week2daily4.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.example.consultants.week2daily4.AnimalDatabase;
import com.example.consultants.week2daily4.R;

import java.io.ByteArrayOutputStream;

public class AnimalGenerator {

    public void populateDB(Context context)
    {
        //create database
        AnimalDatabase animalDatabase = new AnimalDatabase(context);

        //Add tiger to DB
        Drawable d = context.getResources().getDrawable(R.drawable.tiger);
        Bitmap bmTiger = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamTiger = new ByteArrayOutputStream();
        bmTiger.compress(Bitmap.CompressFormat.JPEG, 100, streamTiger);
        byte[] imgTiger = streamTiger.toByteArray();
        animalDatabase.insertAnimal(Animal.CATEGORIES[0], "Tiger", "350", imgTiger, R.raw.tigersound);

        //Add cow to DB
        d = context.getResources().getDrawable(R.drawable.cow);
        Bitmap bmCow = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamCow = new ByteArrayOutputStream();
        bmCow.compress(Bitmap.CompressFormat.JPEG, 100, streamCow);
        byte[] imgCow = streamCow.toByteArray();
        animalDatabase.insertAnimal(Animal.CATEGORIES[0], "Cow", "2000", imgCow, R.raw.cowsound);

        //Add monkey to DB
        d = context.getResources().getDrawable(R.drawable.monkey);
        Bitmap bmMonkey = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamMonkey = new ByteArrayOutputStream();
        bmMonkey.compress(Bitmap.CompressFormat.JPEG, 100, streamMonkey);
        byte[] imgMonkey = streamMonkey.toByteArray();
        animalDatabase.insertAnimal(Animal.CATEGORIES[0], "Monkey", "45", imgMonkey, R.raw.monkeysound);

        //Add pig to DB
        d = context.getResources().getDrawable(R.drawable.pig);
        Bitmap bmPig = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamPig = new ByteArrayOutputStream();
        bmPig.compress(Bitmap.CompressFormat.JPEG, 100, streamPig);
        byte[] imgPig = streamPig.toByteArray();
        animalDatabase.insertAnimal(Animal.CATEGORIES[0], "Pig", "180", imgPig, R.raw.pigsound);

        //Add duck to DB
        d = context.getResources().getDrawable(R.drawable.duck);
        Bitmap bmDuck = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream streamDuck = new ByteArrayOutputStream();
        bmDuck.compress(Bitmap.CompressFormat.JPEG, 100, streamDuck);
        byte[] imgDuck = streamDuck.toByteArray();
        animalDatabase.insertAnimal(Animal.CATEGORIES[1], "Duck", "2", imgDuck, R.raw.ducksound);
    }
}

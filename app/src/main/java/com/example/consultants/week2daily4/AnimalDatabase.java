package com.example.consultants.week2daily4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class AnimalDatabase extends SQLiteOpenHelper {

    public AnimalDatabase(@Nullable Context context)
    {
        super(context, AnimalContract.NAME, null, AnimalContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AnimalContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //drop table and upgrade to new version of database schema
        //migration scripts for saving database
    }

    public long insertAnimal(String category, String name, String weight, byte[] photo, int sound) {

        //get instance of the database
        SQLiteDatabase database = getWritableDatabase();

        //create content values to save the data as a row
        ContentValues contentValues = new ContentValues();
        contentValues.put(AnimalContract.FeedEntry.COL_CAT, category);
        contentValues.put(AnimalContract.FeedEntry.COL_NAME, name);
        contentValues.put(AnimalContract.FeedEntry.COL_WEIGHT, weight);
        contentValues.put(AnimalContract.FeedEntry.COL_PHOTO, photo);
        contentValues.put(AnimalContract.FeedEntry.COL_SOUND, sound);

        long rowId = database.insert(AnimalContract.FeedEntry.TABLE_NAME, null, contentValues);

        return rowId;
    }

    public Cursor getAnimals(String category)
    {
        //get instance of the database, get animals of specific category
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + 
                AnimalContract.FeedEntry.TABLE_NAME + " WHERE " + AnimalContract.FeedEntry.COL_CAT + " = \"" + category + "\"",null);
    }

}

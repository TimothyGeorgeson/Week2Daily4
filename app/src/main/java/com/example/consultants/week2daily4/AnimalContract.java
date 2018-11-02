package com.example.consultants.week2daily4;

import android.provider.BaseColumns;

public class AnimalContract {
    public static final String NAME = "Animal.db";
    public static final int VERSION = 1;

    //Creates table with primary key
    public static final String CREATE_TABLE = "CREATE TABLE " +
            FeedEntry.TABLE_NAME + "(" +
            FeedEntry.COL_ID + " INTEGER PRIMARY KEY, " +
            FeedEntry.COL_CAT + " TEXT," +
            FeedEntry.COL_NAME + " TEXT," +
            FeedEntry.COL_WEIGHT + " TEXT," +
            FeedEntry.COL_PHOTO + " BLOB," +
            FeedEntry.COL_SOUND + " INTEGER)";

    public static final String GET_ALL = "SELECT * FROM " + FeedEntry.TABLE_NAME;

    public static class FeedEntry implements BaseColumns {

        public static final String TABLE_NAME = "animals";
        public static final String COL_ID = "id";
        public static final String COL_CAT = "category";
        public static final String COL_NAME = "name";
        public static final String COL_WEIGHT = "weight";
        public static final String COL_PHOTO = "photo";
        public static final String COL_SOUND = "sound";
    }
}

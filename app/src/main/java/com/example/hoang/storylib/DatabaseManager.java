package com.example.hoang.storylib;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoang on 3/9/2018.
 */

public class DatabaseManager {
    private static final String TAG = "DatabaseManager";
    public final String TABLE_STORY = "tbl_short_story";

    private SQLiteDatabase sqLiteDatabase;
    private static MyDatabase myDatabase;
    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context) {
        databaseManager = new DatabaseManager();
        myDatabase = new MyDatabase(context);
        return databaseManager;
    }

    public List<StoryModel> getStoryTopic() {
        sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + TABLE_STORY, null);
        List<StoryModel> storyModelList = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            //read data
            int id = cursor.getInt(0);
            String imageURL = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);

            StoryModel storyModel = new StoryModel(id, imageURL, title, description, content, author);
            storyModelList.add(storyModel);
            //next
            cursor.moveToNext();
        }
        Log.d(TAG, "getStoryTopic: " + storyModelList);
        return storyModelList;
    }



}

package com.example.qklahpita.toeicvocab12.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qklahpita.toeicvocab12.databases.models.CategoryModel;
import com.example.qklahpita.toeicvocab12.databases.models.TopicModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qklahpita on 3/1/18.
 */

public class DatabaseManager {
    private static final String TAG = "DatabaseManager";

    private static final String TABLE_TOPIC = "tbl_short_story";

    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context) {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager(context);
        }
        return databaseManager;
    }

    public DatabaseManager(Context context) {
        assetHelper = new AssetHelper(context);
    }

    public List<TopicModel> getListTopic() {
        sqLiteDatabase = assetHelper.getReadableDatabase();

        List<TopicModel> topicModelList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_TOPIC, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            //read data
            int id = cursor.getInt(0);
            String imageUrl = cursor.getString(1);
            String title = cursor.getString(2);
            String des = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);

            TopicModel topicModel = new TopicModel(id, imageUrl, title, des, content, author);
            topicModelList.add(topicModel);

            //next
            cursor.moveToNext();
        }

        Log.d(TAG, "getListTopic: " + topicModelList);

        return topicModelList;
    }

    public List<CategoryModel> getListCategory(List<TopicModel> topicModelList) {
        List<CategoryModel> categoryModelList = new ArrayList<>();
        for (int i = 0; i < topicModelList.size(); i = i+5) {
            CategoryModel categoryModel = new CategoryModel(
                    topicModelList.get(i).title,
                    topicModelList.get(i).author,
                    topicModelList.get(i).imageUrl);
            categoryModelList.add(categoryModel);
        }

        return categoryModelList;
    }

    public HashMap<String, List<TopicModel>> getHashMapTopic(
            List<TopicModel> topicModelList,
            List<CategoryModel> categoryModelList) {
        HashMap<String, List<TopicModel>> hashMap = new HashMap<>();
        for (int i = 0; i < categoryModelList.size(); i++) {
            int positionTopic = i*5;

            hashMap.put(categoryModelList.get(i).title,
                    topicModelList.subList(positionTopic, positionTopic + 5));
        }
        return hashMap;
    }
}

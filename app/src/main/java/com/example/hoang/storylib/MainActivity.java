package com.example.hoang.storylib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView elvStory;
    StoryListView storyListView;
    public List<StoryModel> storyModelList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyModelList = DatabaseManager.getInstance(this).getStoryTopic();

        elvStory = findViewById(R.id.elv_story);
        storyListView = new StoryListView(storyModelList);
        elvStory.setAdapter(storyListView);


    }
}

package com.example.qklahpita.toeicvocab12.databases.models;

import java.io.Serializable;

/**
 * Created by qklahpita on 3/1/18.
 */

public class TopicModel implements Serializable{
    public int id;
    public String title;
    public String imageUrl;
    public String description;
    public String content;
    public String author;

    public TopicModel(int id, String title, String imageUrl, String description, String content, String author) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "TopicModel{" +
                "title='" + title + '\'' +
                '}';
    }
}

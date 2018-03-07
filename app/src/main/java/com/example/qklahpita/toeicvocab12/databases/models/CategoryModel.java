package com.example.qklahpita.toeicvocab12.databases.models;

/**
 * Created by qklahpita on 3/4/18.
 */

public class CategoryModel {
    public String title;
    public String author;
    public String imageURL;

    public CategoryModel(String title, String author, String imageURL) {
        this.title = title;
        this.author = author;
        this.imageURL= imageURL;
    }
}

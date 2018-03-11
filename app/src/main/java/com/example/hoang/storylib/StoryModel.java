package com.example.hoang.storylib;

/**
 * Created by hoang on 3/9/2018.
 */

public class StoryModel {

    public int id;
    public String imageURL;
    public String title;
    public String description;
    public String content;
    public String author;

    public StoryModel(int id, String imageURL, String title, String description, String content, String author) {
        this.id = id;
        this.imageURL = imageURL;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "StoryModel{" +
                "id=" + id +
                ", imageURL='" + imageURL + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

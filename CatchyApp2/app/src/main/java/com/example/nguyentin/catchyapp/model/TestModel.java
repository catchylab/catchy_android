package com.example.nguyentin.catchyapp.model;

import android.graphics.Bitmap;

public class TestModel {
    private Bitmap image;
    private String content;
    private String name;

    public TestModel(Bitmap image, String content, String name) {
        this.image = image;
        this.content = content;
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

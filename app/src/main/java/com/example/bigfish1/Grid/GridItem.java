package com.example.bigfish1.Grid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bigfish1.R;

public class GridItem {
    private int imageId;//make string to get from api
    private String text;

    public GridItem(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }
}

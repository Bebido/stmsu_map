package com.lab.stmsumap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button buttonOriginalMap;
    Button buttonMapSnippet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFields();
    }

    private void setFields() {
        imageView = findViewById(R.id.imageView);
        buttonOriginalMap = findViewById(R.id.buttonOriginalMap);
        buttonMapSnippet = findViewById(R.id.buttonMapSnippet);
    }

    public void showOriginalMap(View view) {
        //do nothing for now
    }

    public void showMapSnippet(View view) {
        //do nothing for now
    }
}
package com.lab.stmsumap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonOriginalMap;
    private Button buttonMapSnippet;

    public ImageView getImageView() {
        return imageView;
    }

    public Button getButtonOriginalMap() {
        return buttonOriginalMap;
    }

    public Button getButtonMapSnippet() {
        return buttonMapSnippet;
    }

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
        disableButtons();

        GetMapFragmentRequest mapFragmentRequest = new GetMapFragmentRequest();
        MapDownloader mapDownloader = new MapDownloader(this);
        mapDownloader.execute(mapFragmentRequest);
    }

    private void disableButtons() {
        buttonOriginalMap.setEnabled(false);
        buttonMapSnippet.setEnabled(false);
    }

    public void showMapSnippet(View view) {
        disableButtons();
        GetMapFragmentRequest mapFragmentRequest = new GetMapFragmentRequest();
        mapFragmentRequest.setPixelTopLeftCorner(new Point("0", "0"));
        mapFragmentRequest.setPixelBottomRightCorner(new Point("100", "100"));
        MapDownloader mapDownloader = new MapDownloader(this);
        mapDownloader.execute(mapFragmentRequest);
    }
}
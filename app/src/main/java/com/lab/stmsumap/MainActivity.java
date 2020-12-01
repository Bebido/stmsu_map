package com.lab.stmsumap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonOriginalMap;
    private Button buttonMapSnippet;
    private EditText x0ValueField;
    private EditText x1ValueField;
    private EditText y0ValueField;
    private EditText y1ValueField;

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
        x0ValueField = findViewById(R.id.x0Value);
        x1ValueField = findViewById(R.id.x1Value);
        y0ValueField = findViewById(R.id.y0Value);
        y1ValueField = findViewById(R.id.y1Value);
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
        if (validateSnippetCords())
            callForMapSnippet();
        else
            Toast.makeText(getApplicationContext(), "Coordinates are not filled properly", Toast.LENGTH_SHORT).show();
    }

    private boolean validateSnippetCords() {
        return validateCoord(x0ValueField) && validateCoord(y0ValueField)
                && validateCoord(x1ValueField) && validateCoord(y1ValueField);
    }

    private boolean validateCoord(EditText field) {
        return !field.getText().toString().isEmpty() && !field.getText().toString().contains("-")
                && Long.parseLong(field.getText().toString()) >= 0
                && Long.parseLong(field.getText().toString()) <= 1000;
    }

    private void callForMapSnippet() {
        disableButtons();
        GetMapFragmentRequest mapFragmentRequest = new GetMapFragmentRequest();
        mapFragmentRequest.setPixelTopLeftCorner(new Point(x0ValueField.getText().toString(), y0ValueField.getText().toString()));
        mapFragmentRequest.setPixelBottomRightCorner(new Point(x1ValueField.getText().toString(), y1ValueField.getText().toString()));
        MapDownloader mapDownloader = new MapDownloader(this);
        mapDownloader.execute(mapFragmentRequest);
    }
}
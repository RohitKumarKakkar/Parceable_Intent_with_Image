package com.learning.parceableexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Model modellist = intent.getParcelableExtra("list");

        int ImageRes = modellist.getiImages();
        String line1 = modellist.getLine1();
        String line2 = modellist.getLine2();

        ImageView imgview = findViewById(R.id.imgview);
        imgview.setImageResource(ImageRes);

        Toast.makeText(this, line1 + " - " + line2, Toast.LENGTH_LONG).show();

    }
}
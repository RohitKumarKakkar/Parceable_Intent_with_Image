package com.learning.parceableexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        ArrayList<Model> modelList = new ArrayList<>();

        modelList.add(new Model(R.drawable.ic_android_black_24dp, "Android", "This is a logo"));
        modelList.add(new Model(R.drawable.ic_baseline_4g_plus_mobiledata_24, "4G", "This is a network"));
        modelList.add(new Model(R.drawable.ic_baseline_alternate_email_24, "Email", "This is a symbol"));

        mAdapter = new RecyclerViewAdapter(modelList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                modelList.get(position);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("list", modelList.get(position));

                startActivity(intent);

            }
        });
    }
}
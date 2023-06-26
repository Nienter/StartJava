package com.myjava.javatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    private ListView lv;
    private ScrollView sv;
    private int[] s = {3, 4, 5, 6, 3, 4, 4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        sv = findViewById(R.id.sv);
        lv = findViewById(R.id.lv);
        ArrayAdapter adapter = new ArrayAdapter<Integer>(this, android.R.layout.test_list_item);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        adapter.add(3);
        lv.setAdapter(adapter);

    }
}
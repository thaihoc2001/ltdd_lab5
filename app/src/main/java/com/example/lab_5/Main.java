package com.example.lab_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab_5.adapter.CustomListViewAdapter;
import com.example.lab_5.entity.Cake;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Cake> cakes;
    private CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.idListView);

        cakes = new ArrayList<>();
        cakes.add(new Cake("Tasty Donut", "Spicy tasty donut family", "$10.00", R.drawable.donut_yellow_1));
        cakes.add(new Cake("Pink Donut", "Spicy tasty donut family", "$20.00", R.drawable.tasty_donut_1));
        cakes.add(new Cake("Floating Donut", "Spicy tasty donut family", "$30.00", R.drawable.green_donut_1));
        cakes.add(new Cake("Tasty Donut", "Spicy tasty donut family", "$40.00", R.drawable.donut_red_1));


        adapter = new CustomListViewAdapter(this, R.layout.list_item, cakes);
        listView.setAdapter(adapter);
    }
}

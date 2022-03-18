package com.example.lab_5;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab_5.adapter.CakeDetail;
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "This is an info message");
                Intent i = new Intent(Main.this, CakeDetail.class);
                Bundle b = new Bundle();
                b.putString("name", cakes.get(position).getName());
                b.putString("note", cakes.get(position).getDescription());
                b.putString("money", cakes.get(position).getPrice());
                b.putInt("img", cakes.get(position).getImage());
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}

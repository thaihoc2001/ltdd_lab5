package com.example.lab_5;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
    private Button btnAll, btnPink, btnFloat;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.idListView);
        btnAll = findViewById(R.id.btnAll);
        btnPink = findViewById(R.id.btnPink);
        btnFloat = findViewById(R.id.btnFloat);
        editText = findViewById(R.id.editTextTextPersonName);

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
        btnAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                adapter.allDonut();
                setActiveButton(btnAll, btnPink, btnFloat);
            }
        });
        btnPink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                adapter.filterPinkDonut();
                setActiveButton(btnPink, btnFloat, btnAll);
            }
        });
        btnFloat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                adapter.filterFloating();
                setActiveButton(btnFloat, btnAll, btnPink);
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.filterByText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void setActiveButton(Button buttonActive, Button btn1, Button btn2) {
        buttonActive.setBackgroundColor(Color.parseColor("#F1B000"));
        buttonActive.setTextColor(Color.WHITE);
        btn1.setBackgroundColor(Color.parseColor("#F8F8F8"));
        btn1.setTextColor(Color.BLACK);
        btn2.setTextColor(Color.BLACK);
        btn2.setBackgroundColor(Color.parseColor("#F8F8F8"));
    }
}

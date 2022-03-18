package com.example.lab_5.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab_5.R;

public class CakeDetail extends AppCompatActivity {
    TextView txtName, txtNote, txtMoney;
    ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cake_detail);
        txtName = findViewById(R.id.txtName);
        txtNote = findViewById(R.id.txtNote);
        txtMoney = findViewById(R.id.txtMoney);
        imgHinh = findViewById(R.id.imgHinh);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        txtName.setText(b.getString("name"));
        txtMoney.setText(b.getString("money"));
        txtNote.setText(b.getString("note"));
        imgHinh.setImageResource(b.getInt("img"));

    }
}

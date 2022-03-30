package com.emre.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        /*Intent intent = getIntent();
        textView.setText(intent.getStringExtra("isim"));*/
        sharedPreferences =this.getSharedPreferences("com.emre.multiactivity.ad", Context.MODE_PRIVATE);
        textView.setText(sharedPreferences.getString("isim","veri yok"));

    }
}
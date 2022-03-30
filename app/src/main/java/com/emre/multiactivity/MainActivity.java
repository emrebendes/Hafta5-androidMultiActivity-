package com.emre.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    private static final String TAG ="deneme";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextPersonName);

        sharedPreferences=this.getSharedPreferences("com.emre.multiactivity.ad", Context.MODE_PRIVATE);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"butona basıldı...!",Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart içindeyim");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume içindeyim");
        editText.setText(sharedPreferences.getString("isim","isim giriniz"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause içindeyim");
        sharedPreferences.edit().putString("isim",editText.getText().toString()).apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop içindeyim");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy içindeyim");
    }

    public void butonaBas(View view){
        Toast.makeText(view.getContext(),"butona basıldı...!",Toast.LENGTH_LONG).show();
        Log.e(TAG,"view.getContext():"+view.getContext());
        Log.e(TAG,"this:"+this);
        Log.e(TAG,"MainActivity.this:"+MainActivity.this);
        Log.e(TAG,"getApplicationContext():"+getApplicationContext());

        Intent intent = new Intent(this,MainActivity2.class);
       // intent.putExtra("isim",editText.getText().toString());
        startActivity(intent);


    }
}
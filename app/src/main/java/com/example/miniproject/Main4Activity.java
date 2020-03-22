package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }




    public void onClick(View v) {
       // Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();

       // System.exit(0);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }


}

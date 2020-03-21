package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        openActivity3();
    }

    private void openActivity3() {
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
}

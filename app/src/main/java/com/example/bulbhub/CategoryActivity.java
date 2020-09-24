package com.example.bulbhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {

    private ImageView outdoor,book,disco,led;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        outdoor = (ImageView) findViewById(R.id.outdoor);
        book = (ImageView) findViewById(R.id.book);
        disco = (ImageView) findViewById(R.id.disco);
        led = (ImageView) findViewById(R.id.led);

        outdoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this,AdminActivity.class);
                intent.putExtra("category","outdoor");
                startActivity(intent);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this,AdminActivity.class);
                intent.putExtra("category","book");
                startActivity(intent);
            }
        });
        disco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this,AdminActivity.class);
                intent.putExtra("category","disco");
                startActivity(intent);
            }
        });
        led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this,AdminActivity.class);
                intent.putExtra("category","led");
                startActivity(intent);
            }
        });
    }
}
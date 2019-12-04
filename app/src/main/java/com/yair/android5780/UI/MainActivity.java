package com.yair.android5780.UI;

import android.content.Intent;
import android.os.Bundle;

import com.yair.android5780.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, AddDetailActivity.class);
        startActivity(intent);
    }
}

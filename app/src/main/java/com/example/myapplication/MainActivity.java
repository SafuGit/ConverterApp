package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the default title or update dynamically
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Converter App");
        }

        findViewById(R.id.temperatureButton).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, TemperatureActivity.class)));

        findViewById(R.id.currencyButton).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CurrencyActivity.class)));

        findViewById(R.id.distanceButton).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, DistanceActivity.class)));

        findViewById(R.id.weightButton).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, WeightActivity.class)));

        findViewById(R.id.timeButton).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, TimeActivity.class)));
    }

    // Example method to update the title dynamically
    public void updateToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}

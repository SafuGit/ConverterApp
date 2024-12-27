package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TemperatureActivity extends AppCompatActivity {

    private EditText inputField;
    private TextView resultView;
    private Spinner conversionTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        inputField = findViewById(R.id.inputField);
        resultView = findViewById(R.id.resultView);
        conversionTypeSpinner = findViewById(R.id.conversionTypeSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_conversion_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conversionTypeSpinner.setAdapter(adapter);

        conversionTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculateResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable back button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(null); // Use the default back arrow
        }

        if (toolbar.getNavigationIcon() != null) {
            toolbar.getNavigationIcon().setTint(getResources().getColor(android.R.color.white));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close the activity and return to the previous one
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onConvertClick(View view) {
        calculateResult();
    }

    private void calculateResult() {
        String inputText = inputField.getText().toString();
        if (inputText.isEmpty()) {
            resultView.setText("Please enter a value.");
            return;
        }

        double inputValue;
        try {
            inputValue = Double.parseDouble(inputText);
        } catch (NumberFormatException e) {
            resultView.setText("Invalid input. Please enter a number.");
            return;
        }

        String conversionType = conversionTypeSpinner.getSelectedItem().toString();
        double result;

        switch (conversionType) {
            case "Celsius to Fahrenheit":
                result = (inputValue * 9/5) + 32;
                break;
            case "Fahrenheit to Celsius":
                result = (inputValue - 32) * 5/9;
                break;
            default:
                resultView.setText("Invalid conversion type.");
                return;
        }

        resultView.setText(String.format("Result: %.2f", result));
    }
}

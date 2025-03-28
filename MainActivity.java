package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);

        // Initialize buttons and set onClickListeners

    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(result.getText().toString());
            result.setText(null);

            if (CURRENT_ACTION == '+')
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == '-')
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == '*')
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == '/')
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(result.getText().toString());
            } catch (Exception e) {}
        }
    }
}
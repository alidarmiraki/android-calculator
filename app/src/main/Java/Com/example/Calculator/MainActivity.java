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
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonEqual = findViewById(R.id.buttonEqual);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "0");
            }
        });
        
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "1");
            }
        });

        // Similar onClickListeners for other buttons...

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = '+';
                result.setText(null);
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = '-';
                result.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = '*';
                result.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = '/';
                result.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                result.setText(String.valueOf(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().length() > 0) {
                    CharSequence currentText = result.getText();
                    result.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    result.setText("");
                }
            }
        });
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

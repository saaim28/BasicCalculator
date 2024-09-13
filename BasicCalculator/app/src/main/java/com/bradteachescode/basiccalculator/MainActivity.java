package com.bradteachescode.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String number = "";
    private double num1 = 0;
    private double num2 = 0;
    private String symbol;

    private TextView answerTV;
    private Button keyPad0, keyPad1, keyPad2, keyPad3, keyPad4, keyPad5, keyPad6, keyPad7, keyPad8, keyPad9;
    private Button keyPadAdd, keyPadSub, keyPadMult, keyPadDivide, keyPadClear, keyPadEquals, keyPadDecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTV = findViewById(R.id.answer_tv);

        keyPad0 = findViewById(R.id.key_0_btn);
        keyPad1 = findViewById(R.id.key_1_btn);
        keyPad2 = findViewById(R.id.key_2_btn);
        keyPad3 = findViewById(R.id.key_3_btn);
        keyPad4 = findViewById(R.id.key_4_btn);
        keyPad5 = findViewById(R.id.key_5_btn);
        keyPad6 = findViewById(R.id.key_6_btn);
        keyPad7 = findViewById(R.id.key_7_btn);
        keyPad8 = findViewById(R.id.key_8_btn);
        keyPad9 = findViewById(R.id.key_9_btn);

        keyPadAdd = findViewById(R.id.key_add_btn);
        keyPadSub = findViewById(R.id.key_sub_btn);
        keyPadMult = findViewById(R.id.key_mult_btn);
        keyPadDivide = findViewById(R.id.key_div_btn);
        keyPadClear = findViewById(R.id.key_clear_btn);
        keyPadEquals = findViewById(R.id.key_equals_btn);
        keyPadDecimal = findViewById(R.id.key_decimal_btn);

        keyPad0.setOnClickListener(this);
        keyPad1.setOnClickListener(this);
        keyPad2.setOnClickListener(this);
        keyPad3.setOnClickListener(this);
        keyPad4.setOnClickListener(this);
        keyPad5.setOnClickListener(this);
        keyPad6.setOnClickListener(this);
        keyPad7.setOnClickListener(this);
        keyPad8.setOnClickListener(this);
        keyPad9.setOnClickListener(this);

        keyPadAdd.setOnClickListener(this);
        keyPadSub.setOnClickListener(this);
        keyPadMult.setOnClickListener(this);
        keyPadDivide.setOnClickListener(this);
        keyPadClear.setOnClickListener(this);
        keyPadEquals.setOnClickListener(this);
        keyPadDecimal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.key_0_btn || id == R.id.key_1_btn || id == R.id.key_2_btn ||
                id == R.id.key_3_btn || id == R.id.key_4_btn || id == R.id.key_5_btn ||
                id == R.id.key_6_btn || id == R.id.key_7_btn || id == R.id.key_8_btn ||
                id == R.id.key_9_btn) {
            number = number + ((Button) view).getText().toString();
            answerTV.setText(number);
        } else if (id == R.id.key_add_btn) {
            symbol = "+";
            if (!number.isEmpty()) {
                num1 = Double.parseDouble(number);
                number = "";
            }
        } else if (id == R.id.key_sub_btn) {
            symbol = "-";
            if (!number.isEmpty()) {
                num1 = Double.parseDouble(number);
                number = "";
            }
        } else if (id == R.id.key_mult_btn) {
            symbol = "*";
            if (!number.isEmpty()) {
                num1 = Double.parseDouble(number);
                number = "";
            }
        } else if (id == R.id.key_div_btn) {
            symbol = "/";
            if (!number.isEmpty()) {
                num1 = Double.parseDouble(number);
                number = "";
            }
        } else if (id == R.id.key_clear_btn) {
            symbol = "";
            num1 = 0;
            num2 = 0;
            number = "";
            answerTV.setText("");
        } else if (id == R.id.key_equals_btn) {
            calculateResult();
        } else if (id == R.id.key_decimal_btn) {
            if (!number.contains(".")) {
                number = number + ".";
                answerTV.setText(number);
            }
        }
    }

    private void calculateResult() {
        if (!number.isEmpty()) {
            num2 = Double.parseDouble(number);
            Calculator calculator = new Calculator();
            try {
                double result = calculator.calculate(num1 + " " + symbol + " " + num2);
                answerTV.setText("answer: " + result);
                num1 = result;
                num2 = 0;
                number = "";
            } catch (ArithmeticException e) {
                answerTV.setText("Error: Division by zero");
            } catch (IllegalArgumentException e) {
                answerTV.setText("Error: " + e.getMessage());
            }
        }
    }
}
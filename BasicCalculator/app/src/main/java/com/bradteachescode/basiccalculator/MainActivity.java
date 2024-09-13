package com.bradteachescode.basiccalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String number = "";
    private double num1 = 0;
    private double num2 = 0;
    private String symbol = "";

    private TextView answerTV;
    private Button keyPad0, keyPad1, keyPad2, keyPad3, keyPad4, keyPad5, keyPad6, keyPad7, keyPad8, keyPad9;
    private Button keyPadAdd, keyPadSub, keyPadMult, keyPadDivide, keyPadClear, keyPadEquals;

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
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.key_0_btn) {
            appendNumber("0");
        } else if (id == R.id.key_1_btn) {
            appendNumber("1");
        } else if (id == R.id.key_2_btn) {
            appendNumber("2");
        } else if (id == R.id.key_3_btn) {
            appendNumber("3");
        } else if (id == R.id.key_4_btn) {
            appendNumber("4");
        } else if (id == R.id.key_5_btn) {
            appendNumber("5");
        } else if (id == R.id.key_6_btn) {
            appendNumber("6");
        } else if (id == R.id.key_7_btn) {
            appendNumber("7");
        } else if (id == R.id.key_8_btn) {
            appendNumber("8");
        } else if (id == R.id.key_9_btn) {
            appendNumber("9");
        } else if (id == R.id.key_add_btn) {
            setOperator("+");
        } else if (id == R.id.key_sub_btn) {
            setOperator("-");
        } else if (id == R.id.key_mult_btn) {
            setOperator("*");
        } else if (id == R.id.key_div_btn) {
            setOperator("/");
        } else if (id == R.id.key_clear_btn) {
            clear();
        } else if (id == R.id.key_equals_btn) {
            calculateResult();
        }
    }

    private void appendNumber(String num) {
        number += num;
        answerTV.setText(number);
    }

    private void setOperator(String op) {
        symbol = op;
        try {
            num1 = Double.parseDouble(number);
        } catch (NumberFormatException e) {
            num1 = 0;
        }
        number = "";
    }

    private void clear() {
        symbol = "";
        num1 = 0;
        num2 = 0;
        number = "";
        answerTV.setText("");
    }

    private void calculateResult() {
        try {
            num2 = Double.parseDouble(number);
            double result = 0;
            switch (symbol) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        answerTV.setText("Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    answerTV.setText("Invalid operation");
                    return;
            }
            answerTV.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            answerTV.setText("Error");
        } finally {
            num1 = 0;
            num2 = 0;
            number = "";
        }
    }
}
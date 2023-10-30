package com.example.madt_3_lab_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView calculatorScreen;
    private String input = "";
    private String operator = "";
    private double operand1 = Double.NaN;
    private double operand2;
    private double memory = 0.0;
    private boolean empty = false;

    public static boolean isDecimal(double result) {
        return result % 1 != 0;
    }
    public void NormalAnswer(double result){
        if (!isDecimal(result)){
            int intValue = (int) result;
            input = String.valueOf(intValue);
        }
        else {
            input = String.valueOf(result);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);

        Button[] buttons = new Button[]{
                findViewById(R.id.MC), findViewById(R.id.MR), findViewById(R.id.MS), findViewById(R.id.MPlus), findViewById(R.id.MMinus),
                findViewById(R.id.back), findViewById(R.id.ClearEntry), findViewById(R.id.clear), findViewById(R.id.PlusMinus), findViewById(R.id.SquareRoot),
                findViewById(R.id.n7), findViewById(R.id.n8), findViewById(R.id.n9), findViewById(R.id.division), findViewById(R.id.percent),
                findViewById(R.id.n4), findViewById(R.id.n5), findViewById(R.id.n6), findViewById(R.id.multiplication), findViewById(R.id.OneDividedByX),
                findViewById(R.id.n1), findViewById(R.id.n2), findViewById(R.id.n3), findViewById(R.id.minus), findViewById(R.id.equals),
                findViewById(R.id.n0), findViewById(R.id.period), findViewById(R.id.addition)
        };

        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        String buttonText = ((Button) v).getText().toString();

        switch (buttonText) {

            case "0":
                if(empty){
                    input = "";
                }
                empty = false;

            case "1":
                if(empty){
                    input = "";
                }
                empty = false;

            case "2":
                if(empty){
                    input = "";
                }
                empty = false;

            case "3":
                if(empty){
                    input = "";
                }
                empty = false;

            case "4":
                if(empty){
                    input = "";
                }
                empty = false;

            case "5":
                if(empty){
                    input = "";
                }
                empty = false;

            case "6":
                if(empty){
                    input = "";
                }
                empty = false;

            case "7":
                if(empty){
                    input = "";
                }
                empty = false;

            case "8":
                if(empty){
                    input = "";
                }
                empty = false;

            case "9":
                if(empty){
                    input = "";
                }
                empty = false;


            case ".":
                input += buttonText;

                break;

            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                if (!input.isEmpty()) {
                    operand1 = Double.parseDouble(input);
                    operator = buttonText;
                    input = "";
                }
                break;
            case "=":
                if (!input.isEmpty() && !Double.isNaN(operand1)) {
                    operand2 = Double.parseDouble(input);
                    double result = performOperation(operand1, operand2, operator);
                    NormalAnswer(result);
                    operand1 = result;
                    operator = "";
                    empty = true;
                }
                break;
            case "±":
                if (!input.isEmpty()) {
                    double num = Double.parseDouble(input);
                    num = -num;
                    NormalAnswer(num);
                }
                break;
            case "√":
                if (!input.isEmpty()) {
                    double num = Double.parseDouble(input);
                    num = Math.sqrt(num);
                    NormalAnswer(num);
                }
                break;
            case "1/x":
                if (!input.isEmpty()) {
                    double value = Double.parseDouble(input);
                    if (value != 0) {
                        value = 1 / value;
                        NormalAnswer(value);
                    } else {
                        input = "Error";
                    }
                }
                break;

            case "CE":
                input = "";
                break;

            case "C":
                input = "";
                operand1 = Double.NaN;
                operator = "";
                break;

            case "←":
                if (!input.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                }
                break;

            case "M+":
                if (!input.isEmpty()) {
                    double value = Double.parseDouble(input);
                    memory += value;
                }
                break;

            case "M-":
                if (!input.isEmpty()) {
                    double value = Double.parseDouble(input);
                    memory -= value;
                }
                break;

            case "MC":
                memory = 0.0;
                break;

            case "MR":
                NormalAnswer(memory);
                break;

            case "MS":
                if (!input.isEmpty()) {
                    memory = Double.parseDouble(input);
                }
                break;

        }
        calculatorScreen.setText(input);
    }
         private double performOperation(double operand1, double operand2, String operator){
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    if (operand2 != 0) {
                        return operand1 / operand2;
                    } else {
                        return Double.NaN;
                    }
                case "%":
                    return operand1 * (operand2 / 100);
                default:
                    return operand2;
        }
    }
}
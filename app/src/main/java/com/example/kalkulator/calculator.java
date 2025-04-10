package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Kalkulator extends AppCompatActivity {

    private EditText etPertama, etKedua;
    private TextView resultTxt;
    private Button btnPlus, btnMinus, btnKali, btnBagi, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_kalkulator);

        etPertama = findViewById(R.id.etpertama);
        etKedua = findViewById(R.id.etkedua);
        resultTxt = findViewById(R.id.Result_txt);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnKali = findViewById(R.id.btnkali);
        btnBagi = findViewById(R.id.btnbagi);
        btnClear = findViewById(R.id.btnClear);

        btnPlus.setOnClickListener(v -> calculateResult("+"));
        btnMinus.setOnClickListener(v -> calculateResult("-"));
        btnKali.setOnClickListener(v -> calculateResult("*"));
        btnBagi.setOnClickListener(v -> calculateResult("/"));
        btnClear.setOnClickListener(v -> clearFields());
    }

    private void calculateResult(String operation) {
        String input1 = etPertama.getText().toString().trim();
        String input2 = etKedua.getText().toString().trim();

        if (!isValidNumber(input1) || !isValidNumber(input2)) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result = 0;

        switch (operation) {
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
                    Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        resultTxt.setVisibility(View.VISIBLE);
        resultTxt.setText("Hasil: " + String.format("%.2f", result));
    }

    private boolean isValidNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); // Memeriksa apakah input angka valid (termasuk negatif dan desimal)
    }

    private void clearFields() {
        etPertama.setText("");
        etKedua.setText("");
        resultTxt.setVisibility(View.INVISIBLE);
    }
}
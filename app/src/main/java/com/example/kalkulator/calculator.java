package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class calculator extends AppCompatActivity {

    private EditText etPertama, etKedua;
    private TextView resultTxt;
    private Button btnPlus, btnMinus, btnKali, btnBagi, btnClear,btnsatu, btndua,btntiga,btnempat,btnlima, btnenam, btntujuh, btndelapan, btnsembilan,btnnol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalkulator);

        etPertama = findViewById(R.id.etpertama);
        etKedua = findViewById(R.id.etkedua);
        resultTxt = findViewById(R.id.Result_txt);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnKali = findViewById(R.id.btnkali);
        btnBagi = findViewById(R.id.btnbagi);
        btnClear = findViewById(R.id.btnClear);

        btnsatu=findViewById(R.id.btnsatu);
        btndua=findViewById(R.id.btndua);
        btntiga=findViewById(R.id.btntiga);
        btnempat=findViewById(R.id.btnempat);
        btnlima=findViewById(R.id.btnlima);
        btnenam=findViewById(R.id.btnenam);
        btntujuh=findViewById(R.id.bttujuh);
        btndelapan=findViewById(R.id.btndelapan);
        btnsembilan=findViewById(R.id.btnsembilan);
        btnnol=findViewById(R.id.btnnol);

        etPertama.setShowSoftInputOnFocus(false);
        etKedua.setShowSoftInputOnFocus(false);

        etPertama.setOnClickListener(v -> aktifEditText= etPertama);
        etKedua.setOnClickListener(v -> aktifEditText= etKedua);

        btnPlus.setOnClickListener(v -> calculateResult("+"));
        btnMinus.setOnClickListener(v -> calculateResult("-"));
        btnKali.setOnClickListener(v -> calculateResult("*"));
        btnBagi.setOnClickListener(v -> calculateResult("/"));
        btnClear.setOnClickListener(v -> clearFields());

        btnsatu.setOnClickListener(v -> tambahAngka("1"));
        btndua.setOnClickListener(v -> tambahAngka("2"));
        btntiga.setOnClickListener(v -> tambahAngka("3"));
        btnempat.setOnClickListener(v -> tambahAngka("4"));
        btnlima.setOnClickListener(v -> tambahAngka("5"));
        btnenam.setOnClickListener(v -> tambahAngka("6"));
        btntujuh.setOnClickListener(v -> tambahAngka("7"));
        btndelapan.setOnClickListener(v -> tambahAngka("8"));
        btnsembilan.setOnClickListener(v -> tambahAngka("9"));
        btnnol.setOnClickListener(v -> tambahAngka("0"));




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

    private EditText aktifEditText;

    private void tambahAngka(String Angka){
        String angka =  etPertama.getText().toString();

        if (aktifEditText != null){
            String current= aktifEditText.getText().toString();
            aktifEditText.setText(angka + Angka);
        }
        else {
            Toast.makeText(this, "Pilih kolom untuk diinput terlebih dahulu!", Toast.LENGTH_SHORT).show();
        }


    }
}
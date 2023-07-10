package com.example.efm_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView tvresult;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvresult=findViewById(R.id.tvResult);

        String op=getIntent().getStringExtra("operation");
        Double num=getIntent().getDoubleExtra("num",0);

        switch (op){
            case "Opposite":
                result=-num;
                break;
            case "Absolute Value":
                result=Math.abs(num);
                break;
            case "Square":
                result=Math.pow(num,2);
                break;
        }
        tvresult.setText("The "+op+" of "+num+" is: "+result);
    }
}
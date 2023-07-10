package com.example.efm_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText etnumber;
    Button btncalcul;
    Spinner spinner;
    String selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnumber=findViewById(R.id.etnumber);
        btncalcul=findViewById(R.id.btn_calculate);
        spinner=findViewById(R.id.spinner);

        @SuppressLint("ResourceType")
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btncalcul.setOnClickListener(v -> {
            String number=etnumber.getText().toString();
            if (number.isEmpty() || number.isBlank() ){
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Caution");
                builder.setMessage("You should enter numeric value!");
                builder.show();
            }else {
                try {
                    Double num=Double.parseDouble(number);
                    Intent intent=new Intent(this,Result.class);
                    intent.putExtra("operation",selectedItem);
                    intent.putExtra("num",num);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(this);
                    builder.setTitle("Caution");
                    builder.setMessage("You should enter numeric value!");
                    builder.show();
                }


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedItem = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
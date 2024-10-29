package com.ubl.calculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumber1, txtNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
    }

    public void handlePlusButton(View view) {
        if (validateInputs()) {
            int num1 = Integer.parseInt(txtNumber1.getText().toString());
            int num2 = Integer.parseInt(txtNumber2.getText().toString());
            int result = num1 + num2;
            showResultDialog("Penjumlahan", result);
        }
    }

    public void handleMinusButton(View view) {
        if (validateInputs()) {
            int num1 = Integer.parseInt(txtNumber1.getText().toString());
            int num2 = Integer.parseInt(txtNumber2.getText().toString());
            int result = num1 - num2;
            showResultDialog("Pengurangan", result);
        }
    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(txtNumber1.getText())) {
            Toast.makeText(this, "number 1 is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(txtNumber2.getText())) {
            Toast.makeText(this, "number 2 is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void showResultDialog(String operation, int result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hasil " + operation);
        builder.setMessage("Hasil: " + result);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
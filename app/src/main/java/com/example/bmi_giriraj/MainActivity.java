package com.example.bmi_giriraj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{
    private TextView tvcentimeters,tvkilograms,tvyourbmi,tvResult;
    private EditText etHeight,etWeight;
    private Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = (EditText) findViewById(R.id.etHeight);
        etWeight = (EditText) findViewById(R.id.etWeight);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    float height = Float.parseFloat(etHeight.getText().toString());
                    float weight = Float.parseFloat(etWeight.getText().toString());

                    BMI_Giriraj bmig = new BMI_Giriraj(height, weight);
                    float result = bmig.Calculate();
                    tvResult.setText(new DecimalFormat("##.#").format(result));

                    if (result < 18.5) {
                        Toast.makeText(MainActivity.this, "you are under weight", Toast.LENGTH_LONG).show();
                    } else if (result > 18.4 && result < 25) {
                        Toast.makeText(MainActivity.this, "you are normal weight", Toast.LENGTH_LONG).show();
                    } else if (result > 24 && result < 30) {
                        Toast.makeText(MainActivity.this, "you are overweight", Toast.LENGTH_LONG).show();
                    } else if (result > 30) {
                        Toast.makeText(MainActivity.this, "obesity", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }




    private boolean check() {
        boolean isValid = true;

        if (TextUtils.isEmpty(etHeight.getText().toString())) {
            etHeight.setError("please enter your height");
            etHeight.requestFocus();
            isValid = false;
        } else if (TextUtils.isEmpty(etWeight.getText().toString())) {
            etWeight.setError("please enter your weight");
            etWeight.requestFocus();
            isValid = false;
        }
        return isValid;

    }
}

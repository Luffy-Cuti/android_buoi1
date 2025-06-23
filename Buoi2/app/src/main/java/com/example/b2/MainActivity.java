package com.example.b2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edtC,edtF;
    Button btnCf,btnFc,btnCl;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtC = findViewById(R.id.editc);
        edtF = findViewById(R.id.editF);
        btnCf = findViewById(R.id.BTNCF);
        btnFc = findViewById(R.id.BTNFC);
        btnCl = findViewById(R.id.BTNCL);


        btnCf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtC.getText().toString().trim().isEmpty() && edtF.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"Hay nhap F hoac C",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!edtF.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"F da duoc nhap,khong phai C",Toast.LENGTH_SHORT).show();
                    return;
                }

                DecimalFormat dcm = new DecimalFormat( " 0.00");
                int C = Integer.parseInt(edtC.getText().toString());
                double F = C*1.8 + 32;
                edtF.setText(dcm.format(F)+"");
            }
        });
        btnFc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtC.getText().toString().trim().isEmpty() && edtF.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"Hay nhap F hoac C",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!edtC.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "C đã được nhập, không phải F", Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcm = new DecimalFormat( " 0.00");
                int F = Integer.parseInt(edtF.getText().toString());
                double C = (F-32)/  1.8;
                edtC.setText(dcm.format(C)+"");

            }
        });

        btnCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtC.setText("");
                edtF.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
package com.example.truyendulieutrongactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_2 extends AppCompatActivity {
    EditText Nhan;
    Button btnGoc,btnBinhPhuong;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        Nhan = findViewById(R.id.edtnhan);
        btnGoc = findViewById(R.id.btngoc);
        btnBinhPhuong = findViewById(R.id.btnbinhphuong);
        intent1 = getIntent();
        int a = intent1.getIntExtra("soa",0);
        Nhan.setText(a+"");
        btnGoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    intent1.putExtra("kq",a);
                    setResult(33,intent1);
                    finish();
            }
        });
        btnBinhPhuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1.putExtra("kq",a*a);
                setResult(34,intent1);
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
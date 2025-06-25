package com.example.truyendulieutrongactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText Data,ketqua;
    Button btnKetQua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Data = findViewById(R.id.edtData);
        ketqua = findViewById(R.id.edtKq);
        btnKetQua = findViewById(R.id.btnkq);
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Activity_2.class);
                int a = Integer.parseInt(Data.getText().toString());
                intent1.putExtra("soa",a);
                startActivityForResult(intent1,99);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33){
            int kq = data.getIntExtra("kq",0);
            ketqua.setText("Gia tri goc "+ kq);

        }
        if (requestCode == 99 && resultCode == 34){
            int kq = data.getIntExtra("kq",0);
            ketqua.setText("Gia tri binh phuong "+ kq);

        }
    }
}
package com.example.gridview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    ImageView imgItem2;
    TextView txtTenSP2;
    TextView txtGiaSp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        imgItem2 = findViewById(R.id.Img_item_2);
        txtGiaSp2 = findViewById(R.id.txt_giasp_2);
        txtTenSP2 = findViewById(R.id.txt_tenSP_2);
        //Nhan intent
        Intent iten2 = getIntent();
        int img =  iten2.getIntExtra("image",0);
        imgItem2.setImageResource(img);
        String name = iten2.getStringExtra("name");
        txtTenSP2.setText(name);
        int gia = iten2.getIntExtra("price",0);
        txtGiaSp2.setText("Gia sp "+gia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
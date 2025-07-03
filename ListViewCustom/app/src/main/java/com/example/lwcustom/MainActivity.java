package com.example.lwcustom;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.ip1,R.drawable.ip2,R.drawable.ip3,R.drawable.ip4,R.drawable.ip5,R.drawable.ip6,R.drawable.ip7};
    String name[] = {"Dien thoai 1","Dien thoai 2","Dien thoai 3","Dien thoai 4","Dien thoai 5","Dien thoai 6","Dien thoai 7"};


    ArrayList<Phone> myList;
    Adapter1 myAdapte;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.LV1);
        myList = new ArrayList<>();
        for (int i = 0; i < name.length; i++){
            myList.add(new Phone(image[i],name[i]));
        }
        myAdapte = new Adapter1(MainActivity.this,R.layout.layout1,myList);
        lv.setAdapter(myAdapte);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
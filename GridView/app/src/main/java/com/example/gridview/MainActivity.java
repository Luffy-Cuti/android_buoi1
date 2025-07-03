package com.example.gridview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.b,R.drawable.bh,R.drawable.fdg,R.drawable.fhf,R.drawable.ghg,R.drawable.fghfh,R.drawable.rtr};
    String name[] = {"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7"};
    int price[] = {10000,1131231,123414,53252342,23523424,1234124,235252};
    GridView gv;
    ArrayList<items> myList;
    MyAdapter1 myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        myList = new ArrayList<>();
        for(int i = 0; i < name.length; i ++ ){
            myList.add(new items(image[i],name[i],price[i]));
        }
        myAdapter = new MyAdapter1(MainActivity.this,R.layout.layout_item,myList);
        gv = findViewById(R.id.GVMUASAM);
        gv.setAdapter(myAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent myintent = new Intent(MainActivity.this, MainActivity2.class);
                myintent.putExtra("image",image[i]);
                myintent.putExtra("name",name[i]);
                myintent.putExtra("price",price[i]);
                startActivity(myintent);





            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
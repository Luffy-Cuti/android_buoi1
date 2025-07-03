package com.example.selector;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText edtAtong,edtBtong,edtAhieu,edtBhieu;
    Button btnTong,btnHieu;
    TabHost mytab;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();

        // doc lai du lieu da luu
        SharedPreferences myPre = getSharedPreferences("mysave",MODE_PRIVATE);
        String s = myPre.getString("ls","");
        String[] arr = s.split("\n");
        mylist.addAll(Arrays.asList(arr)); // dùng lại biến mylist toàn cục đã gắn với adapter
        myadapter.notifyDataSetChanged();  // cập nhật lại hiển thị



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //4 buoc luu du lieu
        SharedPreferences myPre = getSharedPreferences("mysave",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = myPre.edit();
        String s = TextUtils.join("\n", mylist);
        myEdit.putString("ls",s);
        myEdit.commit();

    }

    private void addEvent() {
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtAtong.getText().toString());
                int b = Integer.parseInt(edtBtong.getText().toString());
                int c = a + b;
                mylist.add(a+" + " +b + " = "+ c);// them du lieu vao mang
                myadapter.notifyDataSetChanged(); // cap nhat lai apdater
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(edtAhieu.getText().toString());
                int y = Integer.parseInt(edtBhieu.getText().toString());
                int z = x - y;
                mylist.add(x+" - " +y + " = "+ z);// them du lieu vao mang
                myadapter.notifyDataSetChanged(); // cap nhat lai apdater
            }
        });

    }

    private void addControl() {
        edtAtong = findViewById(R.id.edtAtong);
        edtBtong = findViewById(R.id.edtBtong);
        edtAhieu = findViewById(R.id.edtAhieu);
        edtBhieu = findViewById(R.id.edtBhieu);

        btnHieu = findViewById(R.id.btnHieu);
        btnTong = findViewById(R.id.btnTong);


        // xu ly listview

        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,mylist);
        lv.setAdapter(myadapter);
        //xu ly tabhost

        mytab = findViewById(R.id.mytab);
        mytab.setup();
        TabHost.TabSpec spec1,spec2,spec3;
        //ung voi moi tab,thuc hien 4 cong viec
        //tab 1
        spec1 = mytab.newTabSpec("t1"); // tao moi tab

        spec1.setContent(R.id.tab1); // tham chieu id
        spec1.setIndicator("",getResources().getDrawable(R.drawable.cong));// thiet lap icon cho tab
        mytab.addTab(spec1); // them tab 1 vao tab chinh

        //tab 2
        spec2 = mytab.newTabSpec("t2"); // tao moi tab

        spec2.setContent(R.id.tab2); // tham chieu id
        spec2.setIndicator("",getResources().getDrawable(R.drawable.tru));// thiet lap icon cho tab
        mytab.addTab(spec2); // them tab 1 vao tab chinh

        //tab 3
        spec3 = mytab.newTabSpec("t3"); // tao moi tab

        spec3.setContent(R.id.tab3); // tham chieu id
        spec3.setIndicator("",getResources().getDrawable(R.drawable.cong));// thiet lap icon cho tab
        mytab.addTab(spec3); // them tab 1 vao tab chinh




   }
}
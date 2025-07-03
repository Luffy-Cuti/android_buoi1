package com.example.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMaLop,edtTenLop,edtSiSo;
    Button btnThem,btnXoa,btnCapNhat,btnTruyVan;
    ListView lv;
    ArrayList<SV> myList;
    ArrayAdapter<SV > myAdapter;
    SQLiteDatabase mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtMaLop = findViewById(R.id.edtMaLop);
        edtSiSo = findViewById(R.id.edtSiSo);
        edtTenLop = findViewById(R.id.edtTenLop);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnCapNhat = findViewById(R.id.btnCapNhat);
        btnTruyVan = findViewById(R.id.btnTruyVan);

        //tao listview
        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,myList);
        lv.setAdapter(myAdapter);
        // Tao va mơi databse
        mydb = openOrCreateDatabase("QLSV",MODE_PRIVATE,null);
        try {
            String sql = "CREATE TABLE tblop(malop varchar(20) primary key,tenlop varchar(20),siso int)";
            mydb.execSQL(sql);
        }catch(Exception e){
            Log.e("Loi","Bang da ton tai");

        }
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MaLop = edtMaLop.getText().toString();
                String TenLop = edtTenLop.getText().toString();
                int SiSo = Integer.parseInt(edtSiSo.getText().toString());
                ContentValues values = new ContentValues();
                values.put("malop",MaLop);
                values.put("tenlop",TenLop);
                values.put("siso",SiSo);
                String msg = "";
                if(mydb.insert("tblop",null,values) != -1){
                    msg = "Them thanh cong";
                }
                else {
                    msg = "Them that bai";
                    Log.e("Loi","Them that bai");

                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MaLop = edtMaLop.getText().toString();
                int n = mydb.delete("tblop","malop = ?",new String[]{MaLop});
                String msg = "";
                if(n > 0){
                    msg = "Xoa thanh cong";

                }
                else{
                    msg = "Xoa that bai";

                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();


            }
        });
        btnTruyVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.clear();
                Cursor c = mydb.query("tblop",null,null,null,null,null,null);


                while(c.moveToNext())
                {
                    String maLop = c.getString(c.getColumnIndexOrThrow("malop"));
                    String tenLop = c.getString(c.getColumnIndexOrThrow("tenlop"));
                    int siSo = c.getInt(c.getColumnIndexOrThrow("siso"));

                    SV sv = new SV(maLop,tenLop,siSo);
                    myList.add(sv);

                }
                c.close();
                myAdapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SV selectedLop = myList.get(position);
                edtMaLop.setText(selectedLop.getMaLop());
                edtTenLop.setText(selectedLop.getTenLop());

                edtSiSo.setText(String.valueOf(selectedLop.getSiSo()));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
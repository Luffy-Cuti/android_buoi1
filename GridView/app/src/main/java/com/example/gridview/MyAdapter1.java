package com.example.gridview;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter1 extends ArrayAdapter<items> {
    Activity context;
    int idLayout;
    ArrayList<items> myList;

    public MyAdapter1( Activity context, int idLayout, ArrayList<items> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Tao de chua layout
        LayoutInflater myFlater = context.getLayoutInflater();
        //Dat layout len de tao View
        convertView = myFlater.inflate(idLayout,null);
        //lay 1 ptu trong du lieu
        items myItem = myList.get(position);
        // Khai bao anh xa id cho tung item va hien thi anh
        ImageView img_items = convertView.findViewById(R.id.IMG_items);
        img_items.setImageResource(myItem.getImage());
        // Khai bao anh xa id cho tung item va hien thi ten
        TextView txt_ten_items =  convertView.findViewById(R.id.TXT_TENSP);
        txt_ten_items.setText(myItem.getName());
        TextView txt_gia_iems = convertView.findViewById(R.id.TXT_GIASP);
        txt_gia_iems.setText(("Gia: "+ myItem.getPrice()));
        return convertView;



    }
}

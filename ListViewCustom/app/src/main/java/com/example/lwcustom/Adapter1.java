package com.example.lwcustom;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adapter1 extends ArrayAdapter<Phone> {
    Activity context;
    int Layout;
    ArrayList<Phone> mylist;
    //tao ham co tham so

    public Adapter1( Activity context, int layout, ArrayList<Phone> mylist) {
        super(context, layout);
        this.context = context;
        Layout = layout;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //tao de chua layout
        LayoutInflater myflater = context.getLayoutInflater();
        convertView = myflater.inflate(Layout,null);
        Phone myphone = mylist.get(position);
        //khai bao tham chieu id va hien thi anh len imageview
        ImageView img_phone = convertView.findViewById(R.id.img_phone);
        img_phone.setImageResource(myphone.getImage());
        TextView txt_phone = convertView.findViewById(R.id.TV_phone);
        txt_phone.setText(myphone.getName());
        return convertView;

    }
}

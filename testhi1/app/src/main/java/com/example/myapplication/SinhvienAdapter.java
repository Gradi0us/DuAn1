package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SinhvienAdapter extends BaseAdapter {
    Context mycontext;
    int mylayout;
    List<Sinhvien> arrSinhvien;
    public  SinhvienAdapter(Context context, int layout, List<Sinhvien> sinhvienList){
mycontext = context;
mylayout = layout;
arrSinhvien = sinhvienList;


    }

    @Override
    public int getCount() {
        return arrSinhvien.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     convertView = layoutInflater.inflate(mylayout,null);
        TextView txtname = (TextView) convertView.findViewById(R.id.txttensv);
        txtname.setText(arrSinhvien.get(position).name);
        TextView txtnamsinh = (TextView) convertView.findViewById(R.id.txtnssv);
        txtnamsinh.setText(String.valueOf(arrSinhvien.get(position).date));
        return convertView;
    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<Sinhvien> mangSinhVien;
EditText nhap1;
EditText nhap2;
Button addnew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listviewsv);
        nhap1 = findViewById(R.id.nhapten);
        nhap2 = findViewById(R.id.nhaptuoi);
        mangSinhVien = new ArrayList<Sinhvien>();
        SinhvienAdapter adapter = new SinhvienAdapter(
                MainActivity.this,
                R.layout.customlv,
                mangSinhVien

        );
        listView.setAdapter(adapter);

    }

    public void them(View view) {
        String a = nhap1.getText().toString();
        String b = nhap2.getText().toString();
        Sinhvien sv = new Sinhvien();
        sv.setName(a);
        sv.setDate(Integer.parseInt(b));
        mangSinhVien.add(sv);
        SinhvienAdapter adapter = new SinhvienAdapter(
                MainActivity.this,
                R.layout.customlv,
                mangSinhVien

        );
listView.setAdapter(adapter);

    }
}
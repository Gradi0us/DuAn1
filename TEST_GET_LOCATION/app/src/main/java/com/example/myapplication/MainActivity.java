package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    String locationURL;
    private FusedLocationProviderClient fusedLocationClient;
    static String TAG = "zzzzzzzzzzzzzzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "onFailure: khong lay duoc thong tin" + e.getMessage());
                        e.printStackTrace();
                    }
                })
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            // Logic to handle location object
                            // lấy được tọa độ

                            Log.d(TAG, "onSuccess: Lat = " + location.getLatitude());
                            Log.d(TAG, "onSuccess: Lng = " + location.getLongitude());
                            tv1.setText("Vĩ độ : " + location.getLatitude());
                            tv2.setText("Kinh độ : " + location.getLongitude());


                            String msg1 = "http://www.google.com/maps/search/?api=1&query=" + location.getLatitude() + "%2C" + location.getLongitude();
                            locationURL = msg1;
                            Log.d(TAG, "" + msg1);

                        } else {
                            Log.d(TAG, "onSuccess: Lcation null");
                        }
                    }
                });
    }
    //acccccccccccccccccccccccccccccc
    //abcgchgccgg
    public void Map(View view) {
        Intent intent = new Intent(MainActivity.this,Map.class);
        intent.putExtra("url","http://www.google.com/maps/search/?api=1&query=37.4219983%2C-122.084");
        startActivity(intent);
    }




}

package com.example.duan1_pro1121_nhom3.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1_pro1121_nhom3.MainActivity;
import com.example.duan1_pro1121_nhom3.R;

public class Activity_ManhinhCho extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_cho);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Activity_DangNhap.class));
            }
        },3000);
    }
}
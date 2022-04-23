package com.example.duan1_pro1121_nhom3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.Fragment.Fragment_DienThoai;
import com.example.duan1_pro1121_nhom3.Fragment.Fragment_GioiThieu;
import com.example.duan1_pro1121_nhom3.Fragment.Fragment_HangDT;
import com.example.duan1_pro1121_nhom3.Fragment.Fragment_HoaDon;
import com.example.duan1_pro1121_nhom3.Fragment.Fragment_KhachHang;
import com.example.duan1_pro1121_nhom3.Fragment.Fragment_NhanVien;
import com.example.duan1_pro1121_nhom3.Login.Activity_DangNhap;
import com.example.duan1_pro1121_nhom3.Product.NhanVien;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getIntent();
        String vaiTro = intent.getStringExtra("VAITRO");
        if(vaiTro.equals("Quản Lý")==true)
        {
            setContentView(R.layout.activity_main);
        }
        if (vaiTro.equals("Nhân Viên")==true)
        {
            setContentView(R.layout.activity_main2);
        }
        toolbar = findViewById(R.id.toolBar_);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.outline_menu_white_18);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Điện Thoại");

        drawerLayout = findViewById(R.id.Draw_layout);
        navigationView = findViewById(R.id.Draw_nav);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                TextView txtNameHeader,txtVaiTroHeader;
                txtNameHeader = findViewById(R.id.tvName_header);
                txtVaiTroHeader = findViewById(R.id.tvVaiTro_header);

                NhanVien nhanVien = (NhanVien) intent.getSerializableExtra("infomation");
                txtNameHeader.setText("Họ Tên: "+nhanVien.getTenNhanVien());
                txtVaiTroHeader.setText("Vai Trò: "+nhanVien.getVaiTro());
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        // end edit Nav_header
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_main,new Fragment_DienThoai()).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                NhanVien nhanVien = (NhanVien) intent.getSerializableExtra("infomation");
                switch (item.getItemId())
                {
                    case R.id.mnu_DienThoai:
                        fragmentManager.beginTransaction().replace(R.id.fragment_main,new Fragment_DienThoai()).commit();
                        getSupportActionBar().setTitle("Điện Thoại");
                        break;
                    case R.id.mnu_hangdt:
                        fragmentManager.beginTransaction().replace(R.id.fragment_main,new Fragment_HangDT()).commit();
                        getSupportActionBar().setTitle("Hãng Điện Thoại");
                        break;
                    case R.id.mnu_nhanvien:
                        fragmentManager.beginTransaction().replace(R.id.fragment_main,new Fragment_NhanVien()).commit();
                        getSupportActionBar().setTitle("Nhân Viên");
                        break;
                    case R.id.mnu_Khach:
                        fragmentManager.beginTransaction().replace(R.id.fragment_main,new Fragment_KhachHang()).commit();
                        getSupportActionBar().setTitle("Khách Hàng");
                        break;
                    case R.id.mnu_HoaDon:
                        fragmentManager.beginTransaction().replace(R.id.fragment_main,new Fragment_HoaDon()).commit();
                        getSupportActionBar().setTitle("Hoá Đơn");
                        break;
                    case R.id.mnu_GioiThieu:
                        fragmentManager.beginTransaction().replace(R.id.fragment_main,new Fragment_GioiThieu()).commit();
                        getSupportActionBar().setTitle("Giới Thiệu");
                        break;
                    case R.id.mnu_exit:
                        DangXuat();
                        break;
                }
                drawerLayout.closeDrawer(navigationView);
                return false;
            }
        });
    }


    public void DangXuat()
    {
        intent = new Intent(MainActivity.this, Activity_DangNhap.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Đã đăng xuất!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home )
        {
            drawerLayout.openDrawer(navigationView);
        }

        return super.onOptionsItemSelected(item);
    }


}



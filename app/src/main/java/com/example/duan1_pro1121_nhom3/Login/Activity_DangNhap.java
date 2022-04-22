package com.example.duan1_pro1121_nhom3.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.MainActivity;
import com.example.duan1_pro1121_nhom3.Product.NhanVien;
import com.example.duan1_pro1121_nhom3.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Activity_DangNhap extends AppCompatActivity {
    Button btnDangNhap;
    EditText edTaiKhoan,edMatKhau;
    TextView tvDangKi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        tvDangKi = findViewById(R.id.tvDangKi);
        edTaiKhoan = findViewById(R.id.edUserLogin);
        edMatKhau = findViewById(R.id.edPassWord);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TaiKhoan = edTaiKhoan.getText().toString();
                String MatKhau = edMatKhau.getText().toString();
                DAOSP sqLife = new DAOSP(getApplicationContext());
                ArrayList<NhanVien> nhanViens = new ArrayList<>();
                nhanViens = sqLife.getALLNV();
                boolean check = false;
                for (int i =0;i<nhanViens.size();i++)
                {
                    String TaiKhoan2 = nhanViens.get(i).getUserName();
                    String MatKhau2 = nhanViens.get(i).getPassWord();

                    if (TaiKhoan.toString().equals(TaiKhoan2.toString())==true)
                    {
                        if (MatKhau.toString().equals(MatKhau2.toString())==true)
                        {
                            String VAITRO = nhanViens.get(i).getVaiTro();
                            NhanVien nhanVienput = nhanViens.get(i);
                            Intent intent = new Intent(Activity_DangNhap.this, MainActivity.class);
                            intent.putExtra("VAITRO",VAITRO);
                            intent.putExtra("infomation", (Serializable) nhanVienput);

                            ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);

                            startActivity(intent);
                            return;
                        }
                        if (MatKhau.toString().equals(MatKhau2.toString())==false)
                        {
                            Toast.makeText(Activity_DangNhap.this, "Mật Khẩu Chưa Chính Xác", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    check = false;


                }
                if (check==false)
                {
                    Toast.makeText(Activity_DangNhap.this, "Tài Khoản Không Tồn Tại", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        tvDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_DangNhap.this,Activity_DangKi.class);
                startActivity(intent);
            }
        });
    }
}
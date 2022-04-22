package com.example.duan1_pro1121_nhom3.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.Product.NhanVien;
import com.example.duan1_pro1121_nhom3.R;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity_ThongTin extends AppCompatActivity {
    EditText edHoTen,edSDT,edDiaChi;
    TextView txtNgaySinh;
    Button btnDangKi;
    RadioButton rdNam,rdNu;
    Intent intent;

    ArrayList<NhanVien> nhanViens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        intent = getIntent();
        edHoTen = findViewById(R.id.edHT_NV_Add);
        edDiaChi = findViewById(R.id.edDC_NV_Add);
        edSDT = findViewById(R.id.edSDT_NV_Add);
        btnDangKi = findViewById(R.id.btnDangKiAdd);
        rdNam = findViewById(R.id.rdGT_NV_Nam_Add);
        rdNu = findViewById(R.id.rdGT_NV_Nu_Add);
        txtNgaySinh = findViewById(R.id.tvNS_NV_Add);
        rdNam.setChecked(true);
//        Button Chọn Ngày Sinh <Start>
        txtNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis( System.currentTimeMillis() );


                DatePickerDialog dialog = new DatePickerDialog(
                        Activity_ThongTin.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                                int nam = i;
                                int thang = i1;
                                int ngay = i2;

                                txtNgaySinh.setText(nam + "-" + (thang + 1) + "-" + ngay);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE)
                );

                dialog.show();
            }
        });

        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String HOTEN = edHoTen.getText().toString();
                    String DIACHI = edDiaChi.getText().toString();
                    int PHONE = Integer.parseInt(edSDT.getText().toString());
                    String TaiKhoan = intent.getStringExtra("TaiKhoan");
                    String MatKhau = intent.getStringExtra("MatKhau");
                    String NgaySinh = txtNgaySinh.getText().toString();
                    String GioiTinh= "Nam";
                    if(rdNam.isChecked()==true)
                    {
                        GioiTinh = "Nam";
                    }
                    if (rdNu.isChecked()==true)
                    {
                        GioiTinh="Nữ";
                    }

                    String VaiTro;
                    DAOSP dao = new DAOSP(getApplicationContext());
                    nhanViens = dao.getALLNV();
                    if(HOTEN.toString().length()==0&&DIACHI.toString().length()==0)
                    {
                        Toast.makeText(Activity_ThongTin.this, "Không Được Để Trống", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(NgaySinh.toString().equals("00-00-0000"))
                    {
                        Toast.makeText(Activity_ThongTin.this, "Vui Lòng Chọn Ngày Sinh", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (nhanViens.size()==0)
                    {
                        VaiTro = "Quản Trị";
                        NhanVien nhanVien  = new NhanVien(0,HOTEN,TaiKhoan,MatKhau,PHONE,DIACHI,NgaySinh,GioiTinh,VaiTro);
                        dao.AddNhanVien(nhanVien);
                        intent = new Intent(Activity_ThongTin.this,Activity_DangNhap.class);
                        startActivity(intent);
                    }
                    if (nhanViens.size()>0)
                    {

                        VaiTro = "Nhân Viên";
                        NhanVien nhanVien  = new NhanVien(0,HOTEN,TaiKhoan,MatKhau,PHONE,DIACHI,NgaySinh,GioiTinh,VaiTro);
                        dao.AddNhanVien(nhanVien);
                        intent = new Intent(Activity_ThongTin.this,Activity_DangNhap.class);
                        startActivity(intent);
                    }
                }catch (Exception e){
                    Toast.makeText(Activity_ThongTin.this, "Số Điện Thoại Phải Là Số và Không Được Để Trống", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
package com.example.duan1_pro1121_nhom3.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1_pro1121_nhom3.AdapterProduct.KhachHang_Adapter;
import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.Product.KhachHang;
import com.example.duan1_pro1121_nhom3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

public class Fragment_KhachHang extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_kh,container,false);
        FloatingActionButton btnADD = view.findViewById(R.id.btnAddKH);
        ListView listView = view.findViewById(R.id.lvKH);
        DAOSP daosp = new DAOSP(view.getContext());
        KhachHang_Adapter khachHang_adapter = new KhachHang_Adapter(daosp.getALLKH());
        listView.setAdapter(khachHang_adapter);

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                View view1 = inflater.inflate(R.layout.show_add_kh,container,false);
                builder.setView(view1);
                Dialog dialog = builder.create();
                dialog.show();
                EditText edHoTen,edSDT,edDiaChi;
                Button btnSave;
                RadioButton rdNam,rdNu;
                edHoTen = view1.findViewById(R.id.edHT_KH_Add);
                edSDT = view1.findViewById(R.id.edSDT_KH_Add);
                edDiaChi = view1.findViewById(R.id.edDC_KH_Add);
                btnSave = view1.findViewById(R.id.btnAddKH_);
                rdNam = view1.findViewById(R.id.rdGT_KH_Nam_Add);
                rdNu = view1.findViewById(R.id.rdGT_KH_Nu_Add);

                ArrayList<KhachHang> khachHangs = new ArrayList<>();

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {
                            String TENKH = edHoTen.getText().toString();
                            int SDT = Integer.parseInt(edSDT.getText().toString());
                            String DiaChi = edDiaChi.getText().toString();
                            String GioiTinh= "Nam";
                            if(rdNam.isChecked()==true)
                            {
                                GioiTinh = "Nam";
                            }
                            if (rdNu.isChecked()==true)
                            {
                                GioiTinh="Nữ";
                            }
                            if (TENKH.toString().length()==0 && DiaChi.toString().length()==0 ) {
                                Toast.makeText(v.getContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            KhachHang khachHang = new KhachHang(0,TENKH,SDT,DiaChi,GioiTinh);
                            daosp.AddKhachhang(khachHang);
                            listView.setAdapter(new KhachHang_Adapter(daosp.getALLKH()));
                            dialog.dismiss();

                        }catch (Exception e)
                        {
                            Toast.makeText(v.getContext(), "Số Điện Thoại Phải là số nguyên", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return view;
    }
}
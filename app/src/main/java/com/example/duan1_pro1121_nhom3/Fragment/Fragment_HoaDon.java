package com.example.duan1_pro1121_nhom3.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1_pro1121_nhom3.AdapterProduct.DienThoai_Adapter;
import com.example.duan1_pro1121_nhom3.AdapterProduct.HoaDon_Adapter;
import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.Product.DienThoai;
import com.example.duan1_pro1121_nhom3.Product.HoaDon;
import com.example.duan1_pro1121_nhom3.Product.KhachHang;
import com.example.duan1_pro1121_nhom3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

public class Fragment_HoaDon extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    DienThoai dienThoai;
    KhachHang khachHang;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_hd,container,false);
        ListView listView = view.findViewById(R.id.lvHD);
        FloatingActionButton btnAdd = view.findViewById(R.id.btnAddHD);
        DAOSP daosp = new DAOSP(view.getContext());
        HoaDon_Adapter hoaDon_adapter = new HoaDon_Adapter(daosp.getALLHD());
        listView.setAdapter(hoaDon_adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View view1 = inflater.inflate(R.layout.show_add_hd,container,false);
                builder.setView(view1);
                Dialog dialog = builder.create();
                dialog.show();

                Button btnSave;
                EditText edSoLuong;
                TextView tvNgayBan;
                Spinner spinnerKH, spinnerSP;
                btnSave = view1.findViewById(R.id.btnSaveHD);
                edSoLuong = view1.findViewById(R.id.ed_SLN_Add);
                tvNgayBan = view1.findViewById(R.id.tvNgayNhap_Add);
                spinnerKH = view1.findViewById(R.id.spinnerKH);
                spinnerSP = view1.findViewById(R.id.spinnerSP);

                ArrayList<String> list = new ArrayList<>();

                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(view1.getContext(), android.R.layout.simple_spinner_item,list);
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                ArrayList<KhachHang> khachHangs = daosp.getALLKH();
                for (int i = 0;i<khachHangs.size();i++)
                {
                    int MaKH = khachHangs.get(i).getMaKhach();
                    String TenKH = khachHangs.get(i).getTenKhach();
                    list.add(TenKH);
                }
                spinnerKH.setAdapter(spinnerAdapter);
                spinnerKH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        khachHang = khachHangs.get(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                ArrayList<DienThoai> dienThoais = daosp.getALLDT();
                for (int i = 0;i<dienThoais.size();i++)
                {
                    String TenDT = dienThoais.get(i).getTenDT();
                    list.add(TenDT);
                }
                spinnerSP.setAdapter(spinnerAdapter);
                spinnerSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        dienThoai = dienThoais.get(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                tvNgayBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis( System.currentTimeMillis() );
                        DatePickerDialog dialog = new DatePickerDialog(
                                view.getContext(),
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                        int nam = i;
                                        int thang = i1;
                                        int ngay = i2;
                                        tvNgayBan.setText(nam + "-" + (thang + 1) + "-" + ngay);
                                    }
                                },
                                calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DATE)
                        );
                        dialog.show();
                    }
                });
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String NgayBan = tvNgayBan.getText().toString();
                        int SoLuong = Integer.parseInt(edSoLuong.getText().toString());
                        HoaDon hoaDon = new HoaDon();
                        daosp.AddHoaDon(hoaDon);
                        listView.setAdapter(new HoaDon_Adapter(daosp.getALLHD()));
                        dialog.dismiss();
                    }
                });
            }
        });
        return view;
    }
}

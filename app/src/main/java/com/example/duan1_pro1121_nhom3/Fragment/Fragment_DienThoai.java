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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1_pro1121_nhom3.AdapterProduct.DienThoai_Adapter;
import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.Product.DienThoai;
import com.example.duan1_pro1121_nhom3.Product.HangDienThoai;
import com.example.duan1_pro1121_nhom3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

public class Fragment_DienThoai extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    HangDienThoai hangDienThoai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_dt,container,false);
        ListView listView = view.findViewById(R.id.lvDT);
        FloatingActionButton btnAdd = view.findViewById(R.id.btnAddDT);
        DAOSP daosp = new DAOSP(view.getContext());
        DienThoai_Adapter dienThoai_adapter = new DienThoai_Adapter(daosp.getALLDT());
        listView.setAdapter(dienThoai_adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                View view1 = inflater.inflate(R.layout.show_add_dt,container,false);
                builder.setView(view1);
                Dialog dialog = builder.create();
                dialog.show();
                Button btnSave;
                EditText edTenDT,edGiaNhap,edSoLuong;
                TextView tvNgaySX;
                Spinner spinner;
                edTenDT = view1.findViewById(R.id.ed_TenDT_Add);
                edSoLuong = view1.findViewById(R.id.ed_SLN_Add);
                edGiaNhap = view1.findViewById(R.id.ed_GiaNhap_Add);
                tvNgaySX = view1.findViewById(R.id.tvNgayNhap_Add);
                btnSave = view1.findViewById(R.id.btnSaveDT);
                spinner = view1.findViewById(R.id.spinnerHANG_dt);

                ArrayList<String> courses = new ArrayList<>();
                ArrayList<HangDienThoai> hangDienThoais = daosp.getALL_HDT();
                for (int i = 0;i<hangDienThoais.size();i++)
                {
                    int MaHang = hangDienThoais.get(i).getMaHang();
                    String TenHang = hangDienThoais.get(i).getTenHang();
                    courses.add(TenHang);
                }

                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(view1.getContext(), android.R.layout.simple_spinner_item,courses);
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerAdapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        hangDienThoai = hangDienThoais.get(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                tvNgaySX.setOnClickListener(new View.OnClickListener() {
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

                                        tvNgaySX.setText(nam + "-" + (thang + 1) + "-" + ngay);
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
                        String TenDT = edTenDT.getText().toString();
                        int SoLuong = Integer.parseInt(edSoLuong.getText().toString());
                        int GiaNhap = Integer.parseInt(edGiaNhap.getText().toString());
                        String NgaySX = tvNgaySX.getText().toString();
                        DienThoai dienThoai = new DienThoai(0,TenDT,GiaNhap,NgaySX,SoLuong,0,hangDienThoai.getMaHang(),hangDienThoai.getTenHang());
                        daosp.AddDT(dienThoai);
                        listView.setAdapter(new DienThoai_Adapter(daosp.getALLDT()));
                        dialog.dismiss();
                    }
                });

            }
        });
        return view;
    }
}
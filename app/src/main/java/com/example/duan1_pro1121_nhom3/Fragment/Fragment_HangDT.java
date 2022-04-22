package com.example.duan1_pro1121_nhom3.Fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1_pro1121_nhom3.AdapterProduct.HangDT_Adapter;
import com.example.duan1_pro1121_nhom3.AdapterProduct.NhanVien_Adapter;
import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.Product.HangDienThoai;
import com.example.duan1_pro1121_nhom3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Fragment_HangDT extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_hdt,container,false);
        ListView listView = view.findViewById(R.id.lvHDT);
        DAOSP daosp = new DAOSP(view.getContext());
        HangDT_Adapter hangDT_adapter = new HangDT_Adapter(daosp.getALL_HDT());
        listView.setAdapter(hangDT_adapter);
        FloatingActionButton btnAdd;
        btnAdd = view.findViewById(R.id.btnAddHDT);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View view1 = LayoutInflater.from(view.getContext()).inflate(R.layout.show_add_hdt,container,false);
                builder.setView(view1);
                Dialog dialog = builder.create();
                dialog.show();
                EditText edTen;
                Button btnSave;
                edTen = view1.findViewById(R.id.edTenHDT_ADD);
                btnSave = view1.findViewById(R.id.btnADDHDT_);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HangDienThoai hangDienThoai = new HangDienThoai(0,edTen.getText().toString());
                        daosp.AddHangDT(hangDienThoai);
                        ArrayList<HangDienThoai> hangDienThoais = daosp.getALL_HDT();
                        HangDT_Adapter hangDT_adapter = new HangDT_Adapter(hangDienThoais);
                        listView.setAdapter(hangDT_adapter);
                        dialog.dismiss();
                        Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        return view;
    }

}
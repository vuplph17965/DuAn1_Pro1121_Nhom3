package com.example.duan1_pro1121_nhom3.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1_pro1121_nhom3.AdapterProduct.DienThoai_Adapter;
import com.example.duan1_pro1121_nhom3.AdapterProduct.HoaDon_Adapter;
import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Fragment_HoaDon extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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

            }
        });
        return view;
    }
}

package com.example.duan1_pro1121_nhom3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_pro1121_nhom3.AdapterProduct.NhanVien_Adapter;
import com.example.duan1_pro1121_nhom3.DAO.DAOSP;
import com.example.duan1_pro1121_nhom3.R;

public class Fragment_NhanVien extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_nv,container,false);
        ListView listView = view.findViewById(R.id.lvNV);
        DAOSP daosp = new DAOSP(view.getContext());
        NhanVien_Adapter nhanVien_adapter = new NhanVien_Adapter(daosp.getALLNV());
        listView.setAdapter(nhanVien_adapter);
        return view;
    }
}

package com.example.duan1_pro1121_nhom3.AdapterProduct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1_pro1121_nhom3.Product.KhachHang;
import com.example.duan1_pro1121_nhom3.Product.NhanVien;
import com.example.duan1_pro1121_nhom3.R;

import java.util.ArrayList;

public class KhachHang_Adapter extends BaseAdapter {
    ArrayList<KhachHang> khachHangs;

    public KhachHang_Adapter(ArrayList<KhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }

    @Override
    public int getCount() {
        return khachHangs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_kh,viewGroup,false);
        TextView tvName,tvDiaChi,tvNumberPhone;
        tvName = view1.findViewById(R.id.txtRowTenKH);
        tvDiaChi = view1.findViewById(R.id.txtRowDiaChiKH);
        tvNumberPhone = view1.findViewById(R.id.txtRowPhoneKH);

        KhachHang khachHang = khachHangs.get(i);

        tvName.setText(khachHang.getTenKhach());
        tvDiaChi.setText(khachHang.getDiaChi());
        tvNumberPhone.setText(khachHang.getSoDienThoai()+"");
        return view1;
    }
}

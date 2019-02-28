package com.phong.cuahangonline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phong.cuahangonline.Activity.ActivityChitietSanpham;
import com.phong.cuahangonline.Model.SanPham;
import com.phong.cuahangonline.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ViewHolder> {
    List<SanPham> listSanpham;
    Context context;

    public SanphamAdapter(List<SanPham> listSanpham, Context context) {
        this.listSanpham = listSanpham;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recyclerview_newsanpham, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Bind(position);
    }

    @Override
    public int getItemCount() {
        return listSanpham.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView textViewGia, textViewTen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_newsanpham);
            textViewTen = itemView.findViewById(R.id.textview_ten_newsanpham);
            textViewGia = itemView.findViewById(R.id.textview_gia_newsanpham);
            itemView.setOnClickListener(this);
        }

        public void Bind(int position) {
            textViewTen.setText(listSanpham.get(position).getTensanpham());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            textViewGia.setText("Giá: " + decimalFormat.format(listSanpham.get(position).getGiasnpham()) + "Đ");
            Picasso.get().load(listSanpham.get(position).getHinhanhsanpham())
                    .resize(100, 100)
                    .placeholder(R.drawable.ic_sync_black_24dp)
                    .error(R.drawable.ic_not_interested_black_24dp)
                    .into(imageView);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ActivityChitietSanpham.class);
            context.startActivity(intent);
        }
    }
}

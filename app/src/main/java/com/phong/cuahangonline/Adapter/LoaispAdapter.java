package com.phong.cuahangonline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phong.cuahangonline.Model.LoaiSP;
import com.phong.cuahangonline.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LoaispAdapter extends RecyclerView.Adapter<LoaispAdapter.VH> {
    List<LoaiSP> listLoaiSPS;
    Context context;

    public LoaispAdapter(List<LoaiSP> loaiSPS, Context context) {
        this.listLoaiSPS = loaiSPS;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_listview_loaisp, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return listLoaiSPS.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public VH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_loaisp);
            textView = itemView.findViewById(R.id.textView_loaisp);
        }

        public void onBind(int position) {
            textView.setText(listLoaiSPS.get(position).getTenloaisp());
            Picasso.get().load(listLoaiSPS.get(position).getHinhanhloaisp())
                    .resize(100,100)
                    .placeholder(R.drawable.ic_sync_black_24dp)
                    .error(R.drawable.ic_not_interested_black_24dp)
                    .into(imageView);
        }
    }
}
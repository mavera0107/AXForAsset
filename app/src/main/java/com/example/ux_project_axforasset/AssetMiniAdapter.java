package com.example.ux_project_axforasset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class AssetMiniAdapter extends RecyclerView.Adapter<AssetMiniAdapter.ViewHolder>{

    Vector<AssetListItem> assetListItem;
    Context context;
    ClickInterface2 clickInterface;

    int btnindex;

    public AssetMiniAdapter(Context context, ClickInterface2 clickInterface, int btnindex) {
        this.context = context;
        this.clickInterface = clickInterface;
        this.btnindex = btnindex;
    }

    public void setAssetListItem(Vector<AssetListItem> assetListItem) {
        this.assetListItem = assetListItem;
    }


    @NonNull
    @Override
    public AssetMiniAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rv_smallassetlist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AssetMiniAdapter.ViewHolder holder, int position) {
        holder.tv_AssetName.setText(assetListItem.get(position).getAssetName());
        holder.tv_AssetShortDesc.setText(assetListItem.get(position).getAssetShortDesc());
        holder.iv_AssetImage.setImageResource(assetListItem.get(position).getAssetImage());

        holder.itemView.findViewById(R.id.assetItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.onClick(holder.getBindingAdapterPosition(), btnindex);
            }
        });
    }

    @Override
    public int getItemCount() {
        return assetListItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_AssetName, tv_AssetShortDesc;
        ImageView iv_AssetImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_AssetName = itemView.findViewById(R.id.sml_assetName);
            tv_AssetShortDesc = itemView.findViewById(R.id.sml_assetDesc);
            iv_AssetImage = itemView.findViewById(R.id.sml_imageView);
        }

    }
}

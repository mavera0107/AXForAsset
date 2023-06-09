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

public class AssetListItemAdapter extends RecyclerView.Adapter<AssetListItemAdapter.ViewHolder>{

    Vector<AssetListItem> assetListItem;
    Context context;
    ClickInterface clickInterface;

    public AssetListItemAdapter(Context context, ClickInterface clickInterface) {
        this.context = context;
        this.clickInterface = clickInterface;
    }

    public void setAssetListItem(Vector<AssetListItem> assetListItem) {
        this.assetListItem = assetListItem;
    }


    @NonNull
    @Override
    public AssetListItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rv_assetlist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AssetListItemAdapter.ViewHolder holder, int position) {
        holder.tv_AssetName.setText(assetListItem.get(position).getAssetName());
        holder.tv_AssetShortDesc.setText(assetListItem.get(position).getAssetShortDesc());
        holder.iv_AssetImage.setImageResource(assetListItem.get(position).getAssetImage());

        holder.itemView.findViewById(R.id.btn_AssetDetails).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.onClick(holder.getBindingAdapterPosition());
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

            tv_AssetName = itemView.findViewById(R.id.tv_AssetName);
            tv_AssetShortDesc = itemView.findViewById(R.id.tv_AssetShortDesc);
            iv_AssetImage = itemView.findViewById(R.id.iv_AssetImage);
        }

    }
}

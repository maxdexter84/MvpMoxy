package com.maxdexter.mvpmoxy.recyclerview.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxdexter.mvpmoxy.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Drawable mDrawable;

    public RecyclerAdapter(Drawable drawable) {
        this.mDrawable = drawable;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_image,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mDrawable);
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.item_image_view);
        }
        public void bind(Drawable drawable){
            mImageView.setImageDrawable(drawable);
        }
    }
}

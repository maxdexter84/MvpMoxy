package com.maxdexter.mvpmoxy.recyclerview.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.maxdexter.mvpmoxy.R;
import com.maxdexter.mvpmoxy.recyclerview.presenter.MainRecyclerPresenter;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Drawable mDrawable;
    int x = 0;

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
        holder.setOnClick();
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "tag";

        ImageView mImageView;
        CardView mCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCardView = (CardView) itemView;
            mImageView = itemView.findViewById(R.id.item_image_view);
        }
        public void bind(Drawable drawable){
            mImageView.setImageDrawable(drawable);
        }
        private void setOnClick(){
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x += 1;
                    Log.d(TAG,"" + x);
                }
            });
        }
    }
}

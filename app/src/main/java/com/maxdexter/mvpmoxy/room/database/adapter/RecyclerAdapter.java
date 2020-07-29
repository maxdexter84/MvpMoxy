package com.maxdexter.mvpmoxy.room.database.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxdexter.mvpmoxy.R;
import com.maxdexter.mvpmoxy.room.User;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<User> users;
    public RecyclerAdapter () {

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);

    }
    public void addList(List<User> list) {
        users = list;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userSurname;
        TextView userAge;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.tv_user_name);
            userSurname = itemView.findViewById(R.id.tv_user_surname);
            userAge = itemView.findViewById(R.id.tv_user_age);
        }
        private void bind(User user) {
            userName.setText(user.getName());
            userSurname.setText(user.getSurname());
            userSurname.setText("Age " + user.getAge());
        }
    }
}

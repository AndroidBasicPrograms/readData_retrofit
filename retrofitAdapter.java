package com.example.jayhind.lecture_app.Retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jayhind.lecture_app.R;

import java.util.ArrayList;

/**
 * Created by Jay Hind on 6/29/2018.
 */

public class retrofitAdapter extends RecyclerView.Adapter<retrofitAdapter.retrofitViewHolder>{
    ArrayList<user> users;
    UserClickListener listener;

    public retrofitAdapter(ArrayList<user> users,UserClickListener listener) {
        this.users=users;
        this.listener=listener;
    }

    @Override
    public retrofitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user,parent,false);
        retrofitViewHolder s=new retrofitViewHolder(view);
        return s;
    }

    @Override
    public void onBindViewHolder(retrofitViewHolder holder, int position) {
        final user c=users.get(position);
        holder.id.setText(c.getUsername());
        holder.name.setText(c.getPassword());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserClick(c);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class retrofitViewHolder extends RecyclerView.ViewHolder {
        TextView id,name;
        View view;
        public retrofitViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            id=itemView.findViewById(R.id.username);
            name=itemView.findViewById(R.id.password);
        }
    }
    public interface UserClickListener
    {
        public void onUserClick(user users);
    }
}


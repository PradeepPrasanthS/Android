package com.example.mvvmsampleapp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvvmsampleapp.R;
import com.example.mvvmsampleapp.service.repository.AndroidVersion;

import java.util.ArrayList;

public class ListItemsAdapter extends RecyclerView.Adapter<ListItemsAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> android;

    public ListItemsAdapter(ArrayList<AndroidVersion> list) {
        this.android = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView surname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            surname = itemView.findViewById(R.id.surname);

        }
    }

    @NonNull
    @Override
    public ListItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_items,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemsAdapter.ViewHolder viewHolder, int i) {
        viewHolder.name.setText(android.get(i).getName());
        viewHolder.surname.setText(android.get(i).getVer());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }
}

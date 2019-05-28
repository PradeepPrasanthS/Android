package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> person;
    ItemClick activity;

    public interface ItemClick{
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list) {
        person = list;
        activity = (ItemClick)context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivView;
        TextView tvName, tvSurname;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            ivView = itemView.findViewById(R.id.ivPref);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(person.indexOf((Person) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(person.get(i));

        viewHolder.tvName.setText(person.get(i).getName());
        viewHolder.tvSurname.setText(person.get(i).getSurName());

        if(person.get(i).getPreference().equals("bus")){
            viewHolder.ivView.setImageResource(R.drawable.bus);
        }
        else{
            viewHolder.ivView.setImageResource(R.drawable.plane);
        }
    }

    @Override
    public int getItemCount() {
        return person.size();
    }
}

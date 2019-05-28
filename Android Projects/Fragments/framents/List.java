package com.example.framents;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends ListFragment {

    Itemselected activity;

    public interface Itemselected{
        void onItemSelected(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Itemselected)context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] data = getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));

        if(this.getActivity().findViewById(R.id.layout_portrait)==null){
            activity.onItemSelected(0);
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        activity.onItemSelected(position);
    }
}

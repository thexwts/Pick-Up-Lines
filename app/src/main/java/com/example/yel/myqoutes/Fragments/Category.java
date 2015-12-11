package com.example.yel.myqoutes.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.yel.myqoutes.Activity.Category_Window;
import com.example.yel.myqoutes.Others.StaticTAGS;
import com.example.yel.myqoutes.R;


public class Category extends Fragment {

    private ListView myList;
    private StaticTAGS staticTAGS = new StaticTAGS();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_category, container, false);
        myList = (ListView) v.findViewById(R.id.listview);
        String[] data = v.getResources().getStringArray(R.array.categories);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_aa_app_listview, R.id.txtdummy, data);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                My.message(getActivity(), "Index: " + position);
                if (position == 1) {
                    Intent i = new Intent(getActivity(), Category_Window.class);
                    i.putExtra(staticTAGS.getCategoryKey(), staticTAGS.getCategoryValue());
                    startActivity(i);
                }
            }
        });

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
//        My.message(getActivity(), "Paused");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        My.message(getActivity(), "Destroyed");
    }
}

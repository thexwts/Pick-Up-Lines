package com.example.yel.myqoutes.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yel.myqoutes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class List_Content_Category extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_list__content__category, container, false);
        return v;
    }

}

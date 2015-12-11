package com.example.yel.myqoutes.Fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yel.myqoutes.R;


public class Favorite extends Fragment {

    private Toolbar toolbar;
    private TextView titlebar;
    private MyTypeface myTypeface;
    private ListView favoriteList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_favorite, container, false);

        myTypeface = new MyTypeface();
        toolbar = (Toolbar) v.findViewById(R.id.favorite_appbar);
        toolbar.setTitle("");
        titlebar = (TextView) v.findViewById(R.id.title_appbar);
        titlebar.setText("Favorite");
        myTypeface.whatTypeFace("robotobold.ttf");
        titlebar.setTypeface(myTypeface.getTypeface());
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        favoriteList = (ListView) v.findViewById(R.id.favorite_listview);
        String[] data = getResources().getStringArray(R.array.favorite);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_aa_app_listview_favorite, R.id.txtdummy, data);
        favoriteList.setAdapter(adapter);

        return v;
    }

    private class MyTypeface {
        private Typeface typeface;

        private void setTypeface(Typeface typeface) {
            this.typeface = typeface;
        }

        public void whatTypeFace(String type) {

            if ("kaushanregular.otf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getActivity().getAssets(), type));
            }
            if ("robotobold.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getActivity().getAssets(), type));
            }

        }

        public Typeface getTypeface() {
            return typeface;
        }

    }

}

package com.example.yel.myqoutes.Fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yel.myqoutes.R;

public class View_Content_Category extends Fragment {


    private TextView contentLines, categoryShare;
    private MyTypeface myTypeface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_view__content__category, container, false);
        myTypeface = new MyTypeface();
        contentLines = (TextView) v.findViewById(R.id.random_content_description);
        myTypeface.whatTypeFace("kaushanregular.otf");
        contentLines.setTypeface(myTypeface.getTypeface());

        categoryShare = (TextView) v.findViewById(R.id.category_share);
        categoryShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You've just hit Share!", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    private class MyTypeface {
        private Typeface typeface;

        private void setTypeface(Typeface typeface) {
            this.typeface = typeface;
        }

        public void whatTypeFace(String type) {

            if ("kaushanregular.otf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }
            if ("robotobold.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }
            if ("robotoregular.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }

        }

        public Typeface getTypeface() {
            return typeface;
        }

    }


}

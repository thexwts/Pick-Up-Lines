package com.example.yel.myqoutes.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.yel.myqoutes.Others.My;
import com.example.yel.myqoutes.R;


public class Main_Random extends Fragment {

    private Button reload;
    private Spinner mySpinner;
    private static ArrayAdapter<String> adapter;
    private MyTypeface myTypeface;
    private TextView contentLines, contentTitle, contentPage;
    private Toolbar toolbar;
    private TextView share, titlebar;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myTypeface = new MyTypeface();
        contentLines = (TextView) getActivity().findViewById(R.id.random_content_description);
        contentTitle = (TextView) getActivity().findViewById(R.id.random_content_title);
        myTypeface.whatTypeFace("kaushanregular.otf");
        contentLines.setTypeface(myTypeface.getTypeface());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main_random, container, false);
        toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        titlebar = (TextView) v.findViewById(R.id.title_appbar);
        titlebar.setText("Pinoy Pick Up Lines");
        mySpinner = (Spinner) v.findViewById(R.id.spinner);
        String[] data = v.getResources().getStringArray(R.array.categories);
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_aa_app_spinner, R.id.txtdummy, data);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            }

        );

        share = (TextView) v.findViewById(R.id.random_btn_share);
        reload = (Button) v.findViewById(R.id.random_btn_reload);
        reload.setOnClickListener(new View.OnClickListener()

                                  {
                                      @Override
                                      public void onClick(View v) {
                                          My.message(getActivity(), "Reload");
                                      }
                                  }

        );
        share.setOnClickListener(new View.OnClickListener()

                                 {
                                     @Override
                                     public void onClick(View v) {
                                         My.message(getActivity(), "Share");
                                     }
                                 }

        );

        return v;
    }

    private class MyTypeface {
        private Typeface typeface;

        private void setTypeface(Typeface typeface) {
            this.typeface = typeface;
        }

        private void whatTypeFace(String type) {

            if ("kaushanregular.otf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }
            if ("robotobold.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }
            if ("robotoregular.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }
            if ("robotocondensedbold.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }
            if ("robotocondensedregular.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }
            if ("papyrus.TTF".equals(type)) {
                setTypeface(Typeface.createFromAsset(getResources().getAssets(), type));
            }

        }

        public Typeface getTypeface() {
            return typeface;
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        My.message(getActivity(), "destroyed");
    }
}

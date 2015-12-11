package com.example.yel.myqoutes.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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


public class Random extends Fragment {

    private Button fav, share, reload;
    private Spinner mySpinner;
    private static boolean favClicked = true;
    private static favoriteFunction function = new favoriteFunction();
    private static ArrayAdapter<String> adapter;
    private MyTypeface myTypeface;
    private TextView contentLines, contentTitle, contentPage;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myTypeface = new MyTypeface();
        contentLines = (TextView) getActivity().findViewById(R.id.random_content_description);
        contentPage = (TextView) getActivity().findViewById(R.id.random_content_page);
        contentTitle = (TextView) getActivity().findViewById(R.id.random_content_title);

        myTypeface.whatTypeFace("robotocondensedregular.ttf");
        contentLines.setTypeface(myTypeface.getTypeface());
        contentPage.setTypeface(myTypeface.getTypeface());
        myTypeface.whatTypeFace("robotocondensedbold.ttf");
        contentTitle.setTypeface(myTypeface.getTypeface());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_random, container, false);
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

        share = (Button) v.findViewById(R.id.random_btn_share);
        fav = (Button) v.findViewById(R.id.random_btn_favorite);
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
        fav.setOnClickListener(new View.OnClickListener()

                               {
                                   @Override
                                   public void onClick(View v) {
                                       My.message(getActivity(), "Favorites");
                                       if (!function.favoriteValue()) {
                                           fav.setBackgroundResource(R.drawable.ctm_btn_favorite_pressed);
                                           function.favoriteIsClicked(false);
                                       } else {
                                           fav.setBackgroundResource(R.drawable.ctm_btn_favorite);
                                           function.favoriteIsClicked(true);//if it's clicked it will move to favoriteValue to give value before changing appearance

                                       }
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

        }

        public Typeface getTypeface() {
            return typeface;
        }


    }

    private static class favoriteFunction {

        public void favoriteIsClicked(boolean value) {//answer if it is clicked or not.
            favClicked = value;
        }

        public boolean favoriteValue() {
            if (favClicked) {
                favClicked = false;
            } else {
                favClicked = true;
            }
            return favClicked;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        My.message(getActivity(), "destroyed");
    }
}

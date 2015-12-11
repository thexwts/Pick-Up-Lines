package com.example.yel.myqoutes.Activity.Host;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yel.myqoutes.Fragments.Category;
import com.example.yel.myqoutes.Fragments.Favorite;
import com.example.yel.myqoutes.Fragments.Random;
import com.example.yel.myqoutes.Others.StaticTAGS;
import com.example.yel.myqoutes.R;

public class Main_Host extends AppCompatActivity {


    private FragmentTransaction transaction;
    private FragmentManager manager;
    private LinearLayout navMain, navCategory, navFavorite;

    private static String TAG;
    private static StaticTAGS staticTAGS = new StaticTAGS();

    private Random randomFrag = new Random();
    private Category categoryFrag = new Category();
    private Favorite favoriteFrag = new Favorite();

    private static ImageView main, category, favorite;
    private static TextView mainTxt, categoryTxt, favoriteTxt;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__host);

        main = (ImageView) findViewById(R.id.nav_ic_main);
        category = (ImageView) findViewById(R.id.nav_ic_category);
        mainTxt = (TextView) findViewById(R.id.nav_ic_main_txt);
        categoryTxt = (TextView) findViewById(R.id.nav_ic_category_txt);
        favorite = (ImageView) findViewById(R.id.nav_ic_favorite);
        favoriteTxt = (TextView) findViewById(R.id.nav_ic_favorite_txt);

        navMain = (LinearLayout) findViewById(R.id.host_navigation_main);
        navCategory = (LinearLayout) findViewById(R.id.host_navigation_categories);
        navFavorite = (LinearLayout) findViewById(R.id.host_navigation_favorites);

        navCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentFetch(staticTAGS.getMyFragCategory(), staticTAGS.getFragFetchCategory());
            }
        });
        navMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentFetch(staticTAGS.getMyFragRandom(), staticTAGS.getFragFetchRandom());
            }
        });
        navFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentFetch(staticTAGS.getMyFragFavorite(), staticTAGS.getFragFetchFavorite());
            }
        });


        if (savedInstanceState != null) {

        } else {
            fragmentTransaction(randomFrag, staticTAGS.getMyFragRandom());
            setNavIconAppearance(randomFrag);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = getIntent();

        if (i != null) {

            String value = i.getStringExtra("mCategory");
            if ("category_closed".equals(value)) {
                fragmentTransaction(categoryFrag, staticTAGS.getMyFragCategory());
                setNavIconAppearance(categoryFrag);

            }

        } else {

        }
    }

    public void fragmentFetch(String mtag, String fragToFetch) {
        switch (fragToFetch) {

            case "fetchRandom":
                if (TAG == mtag) {
                    //Nothing
                } else {

                    fragmentTransaction(randomFrag, mtag);
                    setNavIconAppearance(randomFrag);

                }
                break;

            case "fetchCategory":
                if (TAG == mtag) {
                    //Nothing
                } else {

                    fragmentTransaction(categoryFrag, mtag);
                    setNavIconAppearance(categoryFrag);
                }
                break;

            case "fetchFavorite":
                if (TAG == mtag) {
                    //Nothing
                } else {

                    fragmentTransaction(favoriteFrag, mtag);
                    setNavIconAppearance(favoriteFrag);
                }
                break;
        }

    }

    public void setNavIconAppearance(Fragment mFrag) {

        if (mFrag == randomFrag) {
            main.setBackgroundResource(R.drawable.ctm_nav_main_pressed);
            category.setBackgroundResource(R.drawable.ctm_nav_category);
            favorite.setBackgroundResource(R.drawable.ctm_nav_favorite);
            favoriteTxt.setTextColor(Color.parseColor(staticTAGS.getColor757575()));
            mainTxt.setTextColor(Color.parseColor(staticTAGS.getColor00bcd4()));
            categoryTxt.setTextColor(Color.parseColor(staticTAGS.getColor757575()));
        }

        if (mFrag == categoryFrag) {
            main.setBackgroundResource(R.drawable.ctm_nav_main);
            category.setBackgroundResource(R.drawable.ctm_nav_category_pressed);
            favorite.setBackgroundResource(R.drawable.ctm_nav_favorite);
            favoriteTxt.setTextColor(Color.parseColor(staticTAGS.getColor757575()));
            categoryTxt.setTextColor(Color.parseColor(staticTAGS.getColor00bcd4()));
            mainTxt.setTextColor(Color.parseColor(staticTAGS.getColor757575()));

        }

        if (mFrag == favoriteFrag) {
            main.setBackgroundResource(R.drawable.ctm_nav_main);
            category.setBackgroundResource(R.drawable.ctm_nav_category);
            favorite.setBackgroundResource(R.drawable.ctm_nav_favorite_pressed);
            categoryTxt.setTextColor(Color.parseColor(staticTAGS.getColor757575()));
            favoriteTxt.setTextColor(Color.parseColor(staticTAGS.getColor00bcd4()));
            mainTxt.setTextColor(Color.parseColor(staticTAGS.getColor757575()));

        }

    }

    public void fragmentTransaction(Fragment mFrag, String mTag) {
        this.TAG = mTag;
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.host_fragments, mFrag, mTag);
        transaction.commit();
    }

}



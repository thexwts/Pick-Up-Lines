package com.example.yel.myqoutes.Activity.Host;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yel.myqoutes.Fragments.Main_Category;
import com.example.yel.myqoutes.Fragments.Main_Random;
import com.example.yel.myqoutes.Others.StaticTAGS;
import com.example.yel.myqoutes.R;

public class Main_Host extends AppCompatActivity {


    private FragmentTransaction transaction;
    private FragmentManager manager;
    private LinearLayout navMain, navCategory;

    private static String TAG;
    private static StaticTAGS staticTAGS = new StaticTAGS();

    private Main_Random randomFrag = new Main_Random();
    private Main_Category categoryFrag = new Main_Category();


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


        navMain = (LinearLayout) findViewById(R.id.host_navigation_main);
        navCategory = (LinearLayout) findViewById(R.id.host_navigation_categories);


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


        }

    }

    public void setNavIconAppearance(Fragment mFrag) {

        if (mFrag == randomFrag) {
            main.setBackgroundResource(R.drawable.ctm_nav_main_pressed);
            category.setBackgroundResource(R.drawable.ctm_nav_category);
            mainTxt.setTextColor(Color.parseColor(staticTAGS.getColor00bcd4()));
            categoryTxt.setTextColor(Color.parseColor(staticTAGS.getColor757575()));
        }

        if (mFrag == categoryFrag) {
            main.setBackgroundResource(R.drawable.ctm_nav_main);
            category.setBackgroundResource(R.drawable.ctm_nav_category_pressed);
            categoryTxt.setTextColor(Color.parseColor(staticTAGS.getColor00bcd4()));
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_host, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_more) {
            Intent intent = new Intent(this, More.class);
            startActivity(intent);
        }

        if (id == R.id.action_rate) {
            Toast.makeText(this, "rate me", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.action_exit) {
            //dialog first
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //return nothing
        return;
    }

}



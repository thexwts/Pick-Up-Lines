package com.example.yel.myqoutes.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.yel.myqoutes.Activity.Host.Main_Host;
import com.example.yel.myqoutes.Others.My;
import com.example.yel.myqoutes.Others.StaticTAGS;
import com.example.yel.myqoutes.R;

public class Category_Window extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleBar, contentLines;
    private StaticTAGS staticTAGS = new StaticTAGS();
    private static boolean favClicked = true;
    private favoriteFunction function = new favoriteFunction();
    private MyTypeface myTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_window);
        myTypeface = new MyTypeface();
        contentLines = (TextView) findViewById(R.id.random_content_description);
        myTypeface.whatTypeFace("kaushanregular.otf");
        contentLines.setTypeface(myTypeface.getTypeface());

        toolbar = (Toolbar) findViewById(R.id.category_appbar);
        titleBar = (TextView) findViewById(R.id.title_appbar);
        Intent i = getIntent();
        if (i != null) {

            String mTitle = i.getStringExtra(staticTAGS.getCategoryKey());
            titleBar.setText(mTitle);
            myTypeface.whatTypeFace("robotobold.ttf");
            titleBar.setTypeface(myTypeface.getTypeface());

        }
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private class MyTypeface {
        private Typeface typeface;

        private void setTypeface(Typeface typeface) {
            this.typeface = typeface;
        }

        public void whatTypeFace(String type) {

            if ("kaushanregular.otf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getAssets(), type));
            }
            if ("robotobold.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getAssets(), type));
            }

        }

        public Typeface getTypeface() {
            return typeface;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.category_n_menu, menu);
        menu.findItem(R.id.action_favorite).setIcon(R.drawable.favorite_ic_bar);
        return true;
    }

    private class favoriteFunction {

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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_favorite) {
            if (!function.favoriteValue()) {
                item.setIcon(R.drawable.ctm_bar_favorite);
                function.favoriteIsClicked(false);
            } else {

                item.setIcon(R.drawable.ctm_bar_favorite_pressed);
                function.favoriteIsClicked(true);
            }

            return true;
        }

        if (id == R.id.action_share) {

            My.message(getBaseContext(), "You just hit Share!");

            return true;

        }
        if (id == android.R.id.home) {
            Intent i = new Intent(getApplication(), Main_Host.class);
            i.putExtra(staticTAGS.getHomeCategoryKey(), staticTAGS.getHomeCategoryValue());
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

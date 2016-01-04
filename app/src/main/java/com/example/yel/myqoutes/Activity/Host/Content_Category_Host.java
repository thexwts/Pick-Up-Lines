package com.example.yel.myqoutes.Activity.Host;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.yel.myqoutes.Fragments.List_Content_Category;
import com.example.yel.myqoutes.Fragments.View_Content_Category;
import com.example.yel.myqoutes.Others.StaticTAGS;
import com.example.yel.myqoutes.R;

import java.util.ArrayList;
import java.util.List;

public class Content_Category_Host extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager pager;

    private TextView titleBar;
    private StaticTAGS staticTAGS = new StaticTAGS();
    private MyTypeface myTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_category_host);
        myTypeface = new MyTypeface();
        toolbar = (Toolbar) findViewById(R.id.category_appbar);
        titleBar = (TextView) findViewById(R.id.title_appbar);
        titleBar.setText(staticTAGS.getCategoryValue());
        myTypeface.whatTypeFace("robotoregular.ttf");
        titleBar.setTypeface(myTypeface.getTypeface());

        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(pager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new View_Content_Category(), "View");
        adapter.addFragment(new List_Content_Category(), "List");
        viewPager.setAdapter(adapter);

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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
            if ("robotoregular.ttf".equals(type)) {
                setTypeface(Typeface.createFromAsset(getAssets(), type));
            }

        }

        public Typeface getTypeface() {
            return typeface;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent i = new Intent(getApplication(), Main_Host.class);
            i.putExtra(staticTAGS.getHomeCategoryKey(), staticTAGS.getHomeCategoryValue());
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //return nothing
        return;
    }
}

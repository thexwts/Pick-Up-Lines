package com.example.yel.myqoutes.Activity.Host;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.yel.myqoutes.R;

public class About extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar = (Toolbar) findViewById(R.id.about_appBar);
        titleBar = (TextView) findViewById(R.id.title_appbar);
        titleBar.setText("About");
        setSupportActionBar(toolbar);

    }

}

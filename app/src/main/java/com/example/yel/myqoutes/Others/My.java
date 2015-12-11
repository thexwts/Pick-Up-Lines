package com.example.yel.myqoutes.Others;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Yel on 12/5/2015.
 */
public class My {

    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

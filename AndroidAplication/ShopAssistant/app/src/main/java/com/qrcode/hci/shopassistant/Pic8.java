package com.qrcode.hci.shopassistant;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by eeristi on 2.5.2015.
 */
public class Pic8 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pic8);

        //Show backButton
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}


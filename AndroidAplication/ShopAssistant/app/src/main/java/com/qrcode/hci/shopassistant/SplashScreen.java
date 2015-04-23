package com.qrcode.hci.shopassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by eeristi on 23.4.2015.
 */
public class SplashScreen  extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);




        setContentView(R.layout.splash_screen);

        Thread splash_screen = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                    //startActivity(new Intent("com.qrcode.hci.shopassistant.ScanActivity"));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(getApplicationContext(),ScanActivity.class));
                    finish();
                }
            }

        };

        splash_screen.start();

    }
}

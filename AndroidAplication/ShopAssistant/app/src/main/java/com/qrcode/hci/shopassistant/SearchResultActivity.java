package com.qrcode.hci.shopassistant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchResultActivity extends ActionBarActivity {

    // Array of strings storing country names
    String[] products = new String[]
            {
                    "Iphone 5S 16GB SMART PHONE",
                    "Samsung I9190 GALAXY S4 MINI WHITE",
                    "Iphone 6 16GB GOLD SMART PHONE",
                    "Samsung I9190 GALAXY S6 WHITE 32GB",
                    "LG723 G3 BEAT TITAN SMART PHONE ",
                    "Samsung I9301 GALAXY S3 NEO WHITE",
                    "Samsung I8200 GALAXY S3 MINI WHITE",
                    "Samsung I9060 GALAXY GRAND NEO PLUS BLACK",
                    "Watch",
                    "Tablet",
            };


    int[] flags = new int[]
            {

                    R.drawable.zc,
                    R.drawable.zd,
                    R.drawable.zf,
                    R.drawable.zg,
                    R.drawable.zh,
                    R.drawable.zi,
                    R.drawable.zj,
                    R.drawable.zk,
                    R.drawable.za,
                    R.drawable.zb
            };

    // Array of strings to store currencies
    String[] currency = new String[]
            {
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n" ,
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n" ,
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n" ,
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n" ,
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n" ,
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n" ,
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x Smart Watch \n"  + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n" ,
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x Smart Watch \n"  + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n",
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x Smart Watch \n"  + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n" ,
                    "\n" + "\t1 Material: Silicone and Aluminium \n" + "\t2 Weight:2.68Oz/76g \n" + "\t3 Color:White \n" + "\t4 Dimensions:\n" + "\t\t(9.45x1.57x0.39)''/(8x4x1)cm (LxWxH) \n"  + "\t5 Package Includes:\n" + "\t\t1 x Smart Watch \n"  + "\t\t1 x USB Cable \n"  + "\t\t1 x User Manual \n"
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        //Show backButton
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Each row in the list stores country name, currency and flag
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 10; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt", "Product : " + products[i]);
            hm.put("cur", "Specifications : " + currency[i]);
            hm.put("flag", Integer.toString(flags[i]));
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = {"flag", "txt", "cur","ratingBar"};

        // Ids of views in listview_layout
        int[] to = {R.id.flag, R.id.txt, R.id.cur};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = (ListView) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_result, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    public void btnGoToProducttClick(View view){
        Intent intent = new Intent(this, ProductPage.class);
        startActivity(intent);
    }

}


































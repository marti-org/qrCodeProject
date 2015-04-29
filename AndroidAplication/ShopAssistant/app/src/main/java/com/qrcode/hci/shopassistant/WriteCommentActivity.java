package com.qrcode.hci.shopassistant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class WriteCommentActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.qrcode.hci.shopassistant.MESSAGE";
    public final static String EXTRA_SENDMESSAGE = "com.qrcode.hci.shopassistant.SENDMESSAGE";
    private int maxLetter = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_comment);

        //Show backButton
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Edit message change numbers
        EditText myTextBox = (EditText) findViewById(R.id.messageBox);
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                TextView myOutputBox = (TextView) findViewById(R.id.txvCounting);
                int letterCount = maxLetter - start;
                myOutputBox.setText("Characters left:"+Integer.toString(letterCount));
                //myOutputBox.setText("text");
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_write_comment, menu);
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

    public void btnSaveMessageClick(View view){

        Intent intent = new Intent(this, ProductPage.class);
        EditText editText = (EditText) findViewById(R.id.messageBox);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        intent.putExtra(EXTRA_SENDMESSAGE,true);
        startActivity(intent);

    }
}

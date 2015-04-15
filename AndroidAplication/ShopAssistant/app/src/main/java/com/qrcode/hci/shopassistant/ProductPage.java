package com.qrcode.hci.shopassistant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class ProductPage extends ActionBarActivity {

    private int comment1Likes = 15;
    private int comment1Dislikes = 20;
    private int comment2Likes = 4;
    private int comment2Dislikes = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        //Show backButton
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setComment1LikesRating();
        setComment2LikesRating();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_page, menu);
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

    public void btnWriteCommentClick(View view){
        Intent intent = new Intent(this, WriteCommentActivity.class);
        startActivity(intent);
    }

    private void setComment1LikesRating(){
        TextView txvComment1LikeScore = (TextView) findViewById(R.id.coment1LikeScore);
        txvComment1LikeScore.setText(Integer.toString(comment1Likes)+"/"+Integer.toString(comment1Dislikes));
    }

    private void setComment2LikesRating(){
        TextView txvComment2LikeScore = (TextView) findViewById(R.id.coment2LikeScore);
        txvComment2LikeScore.setText(Integer.toString(comment2Likes)+"/"+Integer.toString(comment2Dislikes));
    }

    public void btnComment1LikeClick(View view){
        comment1Likes++;
        setComment1LikesRating();
        ImageButton btnComment1Like = (ImageButton) findViewById(R.id.btnComment1Like);
        btnComment1Like.setEnabled(false);
        ImageButton btnComment1Dislike = (ImageButton) findViewById(R.id.btnComment1Dislike);
        btnComment1Dislike.setEnabled(false);
    }

    public void btnComment1DislikeClick(View view){
        comment1Dislikes++;
        setComment1LikesRating();
        ImageButton btnComment1Like = (ImageButton) findViewById(R.id.btnComment1Like);
        btnComment1Like.setEnabled(false);
        ImageButton btnComment1Dislike = (ImageButton) findViewById(R.id.btnComment1Dislike);
        btnComment1Dislike.setEnabled(false);
    }

    public void btnComment2LikeClick(View view){
        comment2Likes++;
        setComment2LikesRating();
        ImageButton btnComment2Like = (ImageButton) findViewById(R.id.btnComment2Like);
        btnComment2Like.setEnabled(false);
        ImageButton btnComment2Dislike = (ImageButton) findViewById(R.id.btnComment2Dislike);
        btnComment2Dislike.setEnabled(false);
    }

    public void btnComment2DislikeClick(View view){
        comment2Dislikes++;
        setComment2LikesRating();
        ImageButton btnComment2Like = (ImageButton) findViewById(R.id.btnComment2Like);
        btnComment2Like.setEnabled(false);
        ImageButton btnComment2Dislike = (ImageButton) findViewById(R.id.btnComment2Dislike);
        btnComment2Dislike.setEnabled(false);
    }



}

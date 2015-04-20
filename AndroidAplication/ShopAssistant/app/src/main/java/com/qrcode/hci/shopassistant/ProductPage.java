package com.qrcode.hci.shopassistant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class ProductPage extends ActionBarActivity {

    private int comment1Likes = 15;
    private int comment1Dislikes = 20;
    private int comment2Likes = 4;
    private int comment2Dislikes = 8;

    //CoverFlow Variables
    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        //Show backButton
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setComment1LikesRating();
        setComment2LikesRating();



        mData.add(new GameEntity(R.drawable.addidas1, R.string.photo1Description));
        mData.add(new GameEntity(R.drawable.addidas2, R.string.photo2Description));
        mData.add(new GameEntity(R.drawable.addidas3, R.string.photo3Description));
        mData.add(new GameEntity(R.drawable.addidas4, R.string.photo4Description));
        mData.add(new GameEntity(R.drawable.addidas5, R.string.photo5Description));
        mData.add(new GameEntity(R.drawable.addidas6, R.string.photo6Description));
        mData.add(new GameEntity(R.drawable.addidas7, R.string.photo7Description));
        mData.add(new GameEntity(R.drawable.addidas8, R.string.photo8Description));


        mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(ProductPage.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CoverFlowAdapter(this);
        mAdapter.setData(mData);
        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ProductPage.this,
                        getResources().getString(mData.get(position).titleResId),
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });


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

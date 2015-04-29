package com.qrcode.hci.shopassistant;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;





public class ProductPage extends ActionBarActivity {


    //my constant for id
    private static int btnLikeId = 1000;
    private static int btnDislikeId = 2000;
    private static int txvScoreId = 3000;

    public final static String EXTRA_SORT = "com.qrcode.hci.shopassistant.SORT";

    private boolean SortByPopular = true;


    //CoverFlow Variables
    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;

    //Comments variables
    private ArrayList<Comment> mComments = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        //Show backButton
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set sorting
        Intent intent = getIntent();
        SortByPopular = intent.getBooleanExtra(ProductPage.EXTRA_SORT,true);



        //Inserting comments
        //public Comment(String Name, int Face,String Date, String Text, int Likes, int Dislikes)
        mComments.add(new Comment(1,
                getResources().getString(R.string.comment1DateAndName),
                R.drawable.face1,
                getResources().getString(R.string.comment1DateAndName),
                getResources().getString(R.string.comment1Text),
                5,6));

        mComments.add(new Comment(2,
                getResources().getString(R.string.comment2DateAndName),
                R.drawable.face2,
                getResources().getString(R.string.comment2DateAndName),
                getResources().getString(R.string.comment2Text),
                8,10));

        mComments.add(new Comment(3,
                getResources().getString(R.string.comment3DateAndName),
                R.drawable.face3,
                getResources().getString(R.string.comment3DateAndName),
                getResources().getString(R.string.comment3Text),
                400,2));


        insertComments();




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

        if(!SortByPopular) {
            Button btnSort = (Button) findViewById(R.id.bntSort);
            btnSort.setText(getResources().getString(R.string.btnSortPopular));
        }

        TextView txtCommentNumber = (TextView) findViewById(R.id.commentNumber);
        txtCommentNumber.setText(getResources().getString(R.string.commentNumber)+ Integer.toString(mComments.size()));

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

    public void btnSortCommentClick(View view){
        SortByPopular = !SortByPopular;

        Intent intent = getIntent();
        finish();
        intent.putExtra(EXTRA_SORT,SortByPopular);
        startActivity(intent);
    }

    public void insertComments(){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_product_page, null);

        LinearLayout ll = (LinearLayout) v.findViewById(R.id.myLayout);

        if(SortByPopular) {
            for (Comment comment : mComments) {
                insertComment(ll, comment);
            }
        }else
        {
            Button btnSort = (Button) findViewById(R.id.bntSort);
            btnSort.setText(getResources().getString(R.string.btnSortPopular));

            Comment comment;
            for (int j = mComments.size()-1;j>=0;j--){
                comment = mComments.get(j);
                insertComment(ll, comment);
            }
        }

        setContentView(v);

    }

    public void insertComment(LinearLayout ll, Comment comment)//Comment comment)
    {



        TextView tv = new TextView(this);
        tv.setText(comment.name);
        tv.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setTextSize(18);
        ll.addView(tv);

        RatingBar rb = new RatingBar(this, null, android.R.attr.ratingBarStyleSmall);
        rb.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        rb.setNumStars(5);
        rb.setRating(3);
        ll.addView(rb);


        //Linear Lineout Message
        // Create a LinearLayout element
        LinearLayout llMessage = new LinearLayout(this);
        llMessage.setOrientation(LinearLayout.HORIZONTAL);
        llMessage.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        ImageView imgFace = new ImageView(this);
        imgFace.setImageResource(comment.face);
        imgFace.setLayoutParams(new ViewGroup.LayoutParams(100,100));

        TextView tvComment = new TextView(this);
        tvComment.setText(comment.text);

        llMessage.addView(imgFace);
        llMessage.addView(tvComment);
        ll.addView(llMessage);


        //LinearLiout Voting
        LinearLayout llVoting = new LinearLayout(this);
        llVoting.setOrientation(LinearLayout.HORIZONTAL);
        //llVoting.setLayoutParams(new ViewGroup.LayoutParams(
          //      ViewGroup.LayoutParams.MATCH_PARENT,
            //    ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1.0f;
        params.gravity = Gravity.RIGHT;
        llVoting.setLayoutParams(params);

        llVoting.setGravity(Gravity.CENTER);

        TextView txvScore = new TextView(this);
        txvScore.setText("+"+Integer.toString(comment.likes)+"/-"+Integer.toString(comment.dislikes));
        txvScore.setId(txvScoreId+comment.id);

        ImageButton btnLike = new ImageButton(this);
        //btnLike.setBackgroundColor(Color.WHITE);
        btnLike.setLayoutParams(new ViewGroup.LayoutParams(68, 68));
        btnLike.setImageResource(R.drawable.like);
        btnLike.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btnLike.setId(btnLikeId+comment.id);
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btnId = view.getId();
                int itemId = btnId - btnLikeId;

                //find item in list of  comment
                for (Comment comment : mComments)
                {
                    if (comment.id==itemId){

                        comment.likes++;

                        //Write new rating
                        TextView txvComment1LikeScore = (TextView) findViewById(txvScoreId+itemId);
                        txvComment1LikeScore.setText("+"+Integer.toString(comment.likes)+"/-"+Integer.toString(comment.dislikes));

                        //Turn of button
                        ImageButton btnCommentLike = (ImageButton) findViewById(btnLikeId+itemId);
                        btnCommentLike.setEnabled(false);
                        ImageButton btnCommentDislike = (ImageButton) findViewById(btnDislikeId+itemId);
                        btnCommentDislike.setEnabled(false);
                    }
                }


            }
        });

        ImageButton btnDislike = new ImageButton(this);
       // btnDislike.setBackgroundColor(Color.WHITE);
        btnDislike.setLayoutParams(new ViewGroup.LayoutParams(68,68));
        btnDislike.setImageResource(R.drawable.unlike);
        btnDislike.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btnDislike.setId(btnDislikeId+comment.id);
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btnId = view.getId();
                int itemId = btnId - btnDislikeId;

                //find item in list of  comment
                for (Comment comment : mComments)
                {
                    if (comment.id==itemId){

                        comment.dislikes++;

                        //Write new rating
                        TextView txvComment1LikeScore = (TextView) findViewById(txvScoreId+itemId);
                        txvComment1LikeScore.setText("+"+Integer.toString(comment.likes)+"/-"+Integer.toString(comment.dislikes));

                        //Turn of button
                        ImageButton btnCommentLike = (ImageButton) findViewById(btnLikeId+itemId);
                        btnCommentLike.setEnabled(false);
                        ImageButton btnCommentDislike = (ImageButton) findViewById(btnDislikeId+itemId);
                        btnCommentDislike.setEnabled(false);
                    }
                }


            }
        });

        llVoting.addView(txvScore);
        llVoting.addView(btnLike);
        llVoting.addView(btnDislike);

        ll.addView(llVoting);





    }


}

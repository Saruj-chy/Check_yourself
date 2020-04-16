package com.sd.saruj.check_yourself.Saruj;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.check_yourself.R;
import java.util.ArrayList;
import java.util.Collections;


public class YourSelfActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private YourselfRecyclerAdapter mAdapter1;
    private ArrayList<Item> mItemList;
    private QuizDBHelper mDbHelper;

    private ConstraintLayout mParentLayout;
    private TextView mScoreTextView;
    private TextView mRemaningQuestionsTextView;
    private int mTotalQuestions = 20;
    private int mSelect;

    private String Category_id = "CategoryID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourselfl);

        setTitle("Check YourSelf");

        //  ================
        mParentLayout = findViewById(R.id.question_layout);
        String hexColor = String.format("#%06X", (0xFFFFFF & R.color.soft_green));
        hexColor = "#44"+hexColor.substring(1);
        mParentLayout.setBackgroundColor(Color.parseColor(hexColor));

        mScoreTextView = findViewById(R.id.score);
        mRemaningQuestionsTextView = findViewById(R.id.remaining_questions);

        mRecyclerView = findViewById(R.id.recyclerView);


        mRecyclerView.setNestedScrollingEnabled(false);

        mRecyclerView.setHasFixedSize(true);


      //  Toast.makeText(getApplicationContext()," "+chapterName+" "+testName,Toast.LENGTH_SHORT).show();

        mDbHelper = new QuizDBHelper(this);

            mItemList = mDbHelper.getAllQuestions(Category_id);

            mTotalQuestions = mItemList.size();
            mSelect = 0;



     //   Collections.shuffle(mItemList);



        displayScore();
        //  Toast.makeText(getApplicationContext(), questionName, Toast.LENGTH_SHORT).show();
        mAdapter1 = new YourselfRecyclerAdapter(this, mItemList, Category_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter1);

    }



    public void displayScore() {

        String scoreString = "Select " + mSelect;
        mScoreTextView.setText(scoreString);
        mRemaningQuestionsTextView.setText("Total: " + mTotalQuestions);


    }



    public void selectScore() {
        mSelect++;

    }





    @Override
    public void onBackPressed() {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            alertDialogBuilder.setMessage("Are you sure,You wanted to quit from here ?");
            alertDialogBuilder.setPositiveButton("yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            // Toast.makeText(getApplicationContext()," "+chapterName+" "+testName,Toast.LENGTH_SHORT).show();
                            finishActivity(1);
                            YourSelfActivity.super.onBackPressed();

                        }
                    });
            alertDialogBuilder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //  finish();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();


    }






}
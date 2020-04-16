package com.sd.saruj.check_yourself.Saruj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sd.saruj.check_yourself.R;

import java.util.ArrayList;

public class YourselfRecyclerAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<Item> mItemList;
    private String mCategoryLabel;





    public YourselfRecyclerAdapter(Context context, ArrayList<Item> itemList, String category) {
        this.mContext = context;
        this.mItemList = itemList;
        this.mCategoryLabel = category;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mCategoryLabel = mCategoryLabel.length() > 2 ?
                (mCategoryLabel.substring(0,1).toUpperCase() + mCategoryLabel.substring(1)) :
                mCategoryLabel.toUpperCase();
      //  ((Chapter1stPracticeActivity) mContext).setTitle(mCategoryLabel);
        View questionView = LayoutInflater.from(mContext)
                .inflate(R.layout.card_layout, parent, false);
        return new QuestionViewHolder(questionView);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final Item item = mItemList.get(position);
        final QuestionViewHolder questionViewHolder = (QuestionViewHolder) holder;

        questionViewHolder.mRb.setText(item.getmOption1());





        ArrayList<RadioButton> radioButtons = questionViewHolder.mTableLayout.getChildren();
        for (final RadioButton rb : radioButtons) {
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    questionViewHolder.mTableLayout.checkAnswer(rb, item.getmAnswer(), mContext);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
      //  return 20;
         return mItemList.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {



        RadioButton mRb;


        ToggleButtonTableLayout mTableLayout;


        QuestionViewHolder(View itemView) {
            super(itemView);


            mRb = itemView.findViewById(R.id.rb1);


            mTableLayout = itemView.findViewById(R.id.table_layout);

        }
    }


}
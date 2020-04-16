package com.sd.saruj.check_yourself.Saruj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;


import com.sd.saruj.check_yourself.R;

import java.util.ArrayList;

public class ToggleButtonTableLayout extends TableLayout {

    private RadioButton mActiveRadioButton;

    public ToggleButtonTableLayout(Context context) {
        super(context);
    }

    public ToggleButtonTableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public ArrayList<RadioButton> getChildren() {
        ArrayList<RadioButton> radioButtons = new ArrayList<>();
        int childCount = this.getChildCount();
        //  Toast.makeText(getContext(),"childcount"+childCount,Toast.LENGTH_SHORT).show();
        for(int i=0; i<childCount; i++) {

            TableRow tableRow = (TableRow) this.getChildAt(i);
            int rowChildCount = tableRow.getChildCount();
            //   Toast.makeText(getContext(),"rowchild"+rowChildCount,Toast.LENGTH_SHORT).show();
            int j=0;
            //   for(int j=0 ;j<rowChildCount; j++) {
            while(j<rowChildCount){
                View v = tableRow.getChildAt(j);
                if(v instanceof RadioButton) {
                    radioButtons.add((RadioButton) v);
                }
                j++;
            }
        }
        return radioButtons;
    }

    @SuppressLint("ResourceAsColor")
    public void checkAnswer(final RadioButton rb, String answer, Context mContext) {
        if(mActiveRadioButton != null) {
            mActiveRadioButton.setChecked(false);
        }
        /*switch (activity){
            case "QuestionActivity":
                ((QuestionActivity) mContext).selectScore();
                break;
            case "ModelQuestionActivity":
                ((ModelQuestionActivity) mContext).selectScore();
                break;

        }*/
        ((YourSelfActivity) mContext).selectScore();
        int id = -1;
        rb.setChecked(true);
        if(rb.getText().equals(answer)) {
            setRadioButtonBackgroundColor(rb, R.color.transparent_green);
            rb.setTextColor(getResources().getColor(R.color.yellow));

          //  ((YourSelfActivity) mContext).updateScore();
        } else {
            setRadioButtonBackgroundColor(rb, R.color.red);
            //   rb.setTextColor(getResources().getColor(R.color.transparent_red));
            for(RadioButton radioButton:getChildren()) {
                if(radioButton.getText().equals(answer)) {
                    setRadioButtonBackgroundColor(radioButton, R.color.transparent_green);
                    //   radioButton.setTextColor(getResources().getColor(R.color.transparent_green ));
                    id = radioButton.getId();
                }
            }
        }
        ((YourSelfActivity) mContext).displayScore();
        //  mActiveRadioButton = rb;
        for(RadioButton radioButton:getChildren()) {
            radioButton.setClickable(false);
            if(radioButton.getId() != rb.getId() && radioButton.getId() != id){
                setRadioButtonBackgroundColor(radioButton, R.color.grey);
                radioButton.setTextColor(getResources().getColor(R.color.black));
                radioButton.setClickable(false);
            }
        }

    }

    private void setRadioButtonBackgroundColor(RadioButton button, int colorId) {
        button.getBackground().setColorFilter(Color.parseColor(getContext().getString(colorId)), PorterDuff.Mode.MULTIPLY);

        if(getResources().getColor(R.color.transparent_green) == colorId){
            Toast.makeText(getContext(),"yes",Toast.LENGTH_SHORT).show();
        }
       /* if(colorId==Integer.parseInt("#7700ff00")){
            Toast.makeText(getContext(),"yes",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(),"no",Toast.LENGTH_SHORT).show();
        }*/

    }
}
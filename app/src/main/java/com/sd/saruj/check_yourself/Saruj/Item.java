package com.sd.saruj.check_yourself.Saruj;

public class Item {



    private String mOption;
    private String mAnswer;
    private String mCategory;


    public Item() {
    }
    public Item(String mOption, String mAnswer, String mCategory) {
        this.mOption = mOption;
        this.mAnswer = mAnswer;
        this.mCategory = mCategory;
    }


    public String getmOption1() {
        return mOption;
    }

    public String getmAnswer() {
        return mAnswer;
    }

    public String getmCategory() {
        return mCategory;
    }
    public void setmOption1(String mOption) {
        this.mOption = mOption;
    }

    public void setmAnswer(String mAnswer) {
        this.mAnswer = mAnswer;
    }


}

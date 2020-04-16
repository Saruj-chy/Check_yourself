package com.sd.saruj.check_yourself.Saruj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class QuizDBHelper extends SQLiteOpenHelper
{

    private static final String DB_NAME = "quizzes.d179";
    private static final int DB_VERSION = 8;

    public static final String ID = "_id";
    public static final String TABLE_NAME = "quiz_questions";
    public static final String COLUMN_OPTION1 = "option1";
    public static final String COLUMN_ANSWER = "answer";
    public static final String COLUMN_CATEGORY = "category";


//********************              chapter 1
    public static final String CHAPTER_1A = "CategoryID";



    private final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME +
            "(" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_OPTION1 + " TEXT, " +
            COLUMN_ANSWER + " TEXT, " +
            COLUMN_CATEGORY + " TEXT" +
            ")";

    private final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private SQLiteDatabase db;
    private List<Item> mItemList;


    public QuizDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TABLE_QUERY);

        setUpQuestions();
        insertQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    private void setUpQuestions() {
        mItemList = new ArrayList<>();

        question_1A(CHAPTER_1A);
    }
    private void question_1A(String category){
        mItemList.add(new Item("আল্লাহর সাথে শিরক করা","আল্লাহর সাথে শিরক করা",category));
        mItemList.add(new Item("নামায পরিত্যাগ করা","নামায পরিত্যাগ করা",category));
        mItemList.add(new Item(" পিতা-মাতার অবাধ্য হওয়া"," পিতা-মাতার অবাধ্য হওয়া",category));
        mItemList.add(new Item("অন্যায়ভাবে মানুষ হত্যা করা","অন্যায়ভাবে মানুষ হত্যা করা",category));
        mItemList.add(new Item("পিতা-মাতাকে অভিসম্পাত করা","পিতা-মাতাকে অভিসম্পাত করা",category));
        mItemList.add(new Item("যাদু-টোনা করা","যাদু-টোনা করা",category));
        mItemList.add(new Item("এতীমের সম্পদ আত্মসাৎ করা","এতীমের সম্পদ আত্মসাৎ করা",category));
        mItemList.add(new Item("জিহাদের ময়দান থেকে থেকে পলায়ন","জিহাদের ময়দান থেকে থেকে পলায়ন",category));
        mItemList.add(new Item("সতী-সাধ্বী মু‘মিন নারীর প্রতি অপবাদ","সতী-সাধ্বী মু‘মিন নারীর প্রতি অপবাদ",category));
        mItemList.add(new Item("যাকাত আদায় না করা","যাকাত আদায় না করা",category));
        mItemList.add(new Item("রোযা না রাখা ","রোযা না রাখা ",category));

        mItemList.add(new Item(" ক্ষমতা থাকা সত্যেও হজ্জ আদায় না করা"," ক্ষমতা থাকা সত্যেও হজ্জ আদায় না করা",category));
        mItemList.add(new Item(" যাদুর বৈধতায় বিশ্বাস করা "," যাদুর বৈধতায় বিশ্বাস করা ",category));
        mItemList.add(new Item("  প্রতিবেশীকে কষ্ট দেয়া ","  প্রতিবেশীকে কষ্ট দেয়া ",category));
        mItemList.add(new Item(" অহংকার করা "," অহংকার করা ",category));
        mItemList.add(new Item("  চুগলখোরি করা (ঝগড়া লাগানোর উদ্দেশ্যে একজনের কথা আরেকজনের নিকট লাগোনো)  ","  চুগলখোরি করা (ঝগড়া লাগানোর উদ্দেশ্যে একজনের কথা আরেকজনের নিকট লাগোনো)  ",category));
        mItemList.add(new Item(" আত্মহত্যা করা "," আত্মহত্যা করা ",category));
        mItemList.add(new Item(" আত্মীয়তা সম্পর্ক ছিন্ন করা "," আত্মীয়তা সম্পর্ক ছিন্ন করা ",category));
        mItemList.add(new Item("  অবৈধ পথে উপার্জিত অর্থ ভক্ষণ করা ","  অবৈধ পথে উপার্জিত অর্থ ভক্ষণ করা ",category));
        mItemList.add(new Item(" উপকার করে খোটা দান করা "," উপকার করে খোটা দান করা ",category));
        mItemList.add(new Item("মদ বা নেশা দ্রব্য গ্রহণ করা","মদ বা নেশা দ্রব্য গ্রহণ করা",category));

        mItemList.add(new Item("মদ প্রস্তুত ও প্রচারে অংশ গ্রহণ করা","মদ প্রস্তুত ও প্রচারে অংশ গ্রহণ করা",category));
        mItemList.add(new Item("জুয়া খেলা","জুয়া খেলা",category));
        mItemList.add(new Item("তকদীর অস্বীকার করা","তকদীর অস্বীকার করা",category));
        mItemList.add(new Item(" অদৃশ্যের খবর জানার দাবী করা "," অদৃশ্যের খবর জানার দাবী করা ",category));
        mItemList.add(new Item("  গণকের কাছে ধর্না দেয়া বা গণকের কাছে অদৃশ্যের খবর জানতে চাওয়া ","  গণকের কাছে ধর্না দেয়া বা গণকের কাছে অদৃশ্যের খবর জানতে চাওয়া ",category));
        mItemList.add(new Item("  পেশাব থেকে পবিত্র না থাকা ","  পেশাব থেকে পবিত্র না থাকা ",category));
        mItemList.add(new Item(" রাসূল (সা:)এর নামে মিথ্যা হাদীস বর্ণনা করা"," রাসূল (সা:)এর নামে মিথ্যা হাদীস বর্ণনা করা", category));
        mItemList.add(new Item("মিথ্যা স্বপ্ন বর্ণনা করা ","মিথ্যা স্বপ্ন বর্ণনা করা ", category));
        mItemList.add(new Item(" মিথ্যা কথা বলা",  " মিথ্যা কথা বলা", category ));
        mItemList.add(new Item("মিথ্যা কসমের মাধ্যমে পণ্য বিক্রয় করা",  "মিথ্যা কসমের মাধ্যমে পণ্য বিক্রয় করা", category ));

        mItemList.add(new Item("জিনা-ব্যভিচারে লিপ্ত হওয়া",  "জিনা-ব্যভিচারে লিপ্ত হওয়া", category ));
        mItemList.add(new Item("সমকামিতায় লিপ্ত হওয়া",  "সমকামিতায় লিপ্ত হওয়া", category ));
        mItemList.add(new Item(" মিথ্যা কসম খাওয়া",  " মিথ্যা কসম খাওয়া",category  ));
        mItemList.add(new Item(" মানুষের গোপন কথা চুপিসারে শোনার চেষ্টা করা",  " মানুষের গোপন কথা চুপিসারে শোনার চেষ্টা করা", category ));
        mItemList.add(new Item(" হিল্লা তথা চুক্তি ভিত্তিক বিয়ে করা",  " হিল্লা তথা চুক্তি ভিত্তিক বিয়ে করা", category ));
        mItemList.add(new Item("যার জন্যে হিলা করা হয়",  "যার জন্যে হিলা করা হয়",  category));
        mItemList.add(new Item("মানুষের বংশ মর্যাদায় আঘাত হানা",  "মানুষের বংশ মর্যাদায় আঘাত হানা",category  ));
        mItemList.add(new Item("  মৃতের উদ্দেশ্যে উচ্চস্বরে ক্রন্দন করা ",   "  মৃতের উদ্দেশ্যে উচ্চস্বরে ক্রন্দন করা ", category  ));
        mItemList.add(new Item(" মুসলিম সমাজ থেকে বিচ্ছিন্ন থাকা ",  " মুসলিম সমাজ থেকে বিচ্ছিন্ন থাকা ",  category));
        mItemList.add(new Item("  মুসলিমকে গালি দেয়া অথবা তার সাথে লড়ায়ে লিপ্ত হওয়া ",  "  মুসলিমকে গালি দেয়া অথবা তার সাথে লড়ায়ে লিপ্ত হওয়া ", category ));

        mItemList.add(new Item(" খেলার ছলে কোন প্রাণীকে নিক্ষেপ যোগ্য অস্ত্রের লক্ষ্য বস্তু বানানো ",   " খেলার ছলে কোন প্রাণীকে নিক্ষেপ যোগ্য অস্ত্রের লক্ষ্য বস্তু বানানো ", category  ));
        mItemList.add(new Item(" কোন অপরাধীকে আশ্রয় দান করা ",  " কোন অপরাধীকে আশ্রয় দান করা ", category ));
        mItemList.add(new Item(" আল্লাহ ছাড়া অন্য কারো নামে পশু জবেহ করা ",  " আল্লাহ ছাড়া অন্য কারো নামে পশু জবেহ করা ", category ));
        mItemList.add(new Item(" ওজনে কম দেয়া ",  " ওজনে কম দেয়া ", category ));
        mItemList.add(new Item("  ঝগড়া-বিবাদে অশ্লীল ভাষা প্রয়োগ করা ",  "  ঝগড়া-বিবাদে অশ্লীল ভাষা প্রয়োগ করা ", category ));
        mItemList.add(new Item("  ইসলামী আইনানুসারে বিচার বা শাসনকার্য পরিচালনা না করা ",  "  ইসলামী আইনানুসারে বিচার বা শাসনকার্য পরিচালনা না করা ", category ));
        mItemList.add(new Item("  জমিনের সীমানা পরিবর্তন করা বা পরের জমি জবর দখল করা ",  "  জমিনের সীমানা পরিবর্তন করা বা পরের জমি জবর দখল করা ",category  ));
        mItemList.add(new Item("  গীবত তথা অসাক্ষাতে কারো দোষ চর্চা করা ",  "  গীবত তথা অসাক্ষাতে কারো দোষ চর্চা করা ", category));
        mItemList.add(new Item(" দাঁত চিকন করা ",  " দাঁত চিকন করা ", category ));
        mItemList.add(new Item(" সৌন্দর্যের উদ্দেশ্যে মুখ মণ্ডলের চুল তুলে ফেলা বা চুল উঠিয়ে ভ্রু চিকন করা",  " সৌন্দর্যের উদ্দেশ্যে মুখ মণ্ডলের চুল তুলে ফেলা বা চুল উঠিয়ে ভ্রু চিকন করা",category  ));

        mItemList.add(new Item(" অতিরিক্ত চুল সংযোগ করা",   " অতিরিক্ত চুল সংযোগ করা", category  ));
        mItemList.add(new Item("  পুরুষের নারী বেশ ধারণ করা ",  "  পুরুষের নারী বেশ ধারণ করা ", category ));
        mItemList.add(new Item("  নারীর পুরুষ বেশ ধারণ করা ",  "  নারীর পুরুষ বেশ ধারণ করা ", category ));
        mItemList.add(new Item("  বিপরীত লিঙ্গের প্রতি কামনার দৃষ্টিতে তাকানো ",  "  বিপরীত লিঙ্গের প্রতি কামনার দৃষ্টিতে তাকানো ", category ));
        mItemList.add(new Item(" কবরকে মসজিদ হিসেবে গ্রহণ করা",  " কবরকে মসজিদ হিসেবে গ্রহণ করা",  category));
        mItemList.add(new Item(" পথিককে নিজের কাছে অতিরিক্ত পানি থাকার পরেও না দেয়া ",   " পথিককে নিজের কাছে অতিরিক্ত পানি থাকার পরেও না দেয়া ", category  ));
        mItemList.add(new Item("  পুরুষের টাখনুর নিচে ঝুলিয়ে পোশাক পরিধান করা",  "  পুরুষের টাখনুর নিচে ঝুলিয়ে পোশাক পরিধান করা", category ));
        mItemList.add(new Item("  মুসলিম শাসকের সাথে কৃত বাইআত বা আনুগত্যের শপথ ভঙ্গ করা",   "  মুসলিম শাসকের সাথে কৃত বাইআত বা আনুগত্যের শপথ ভঙ্গ করা",  category ));
        mItemList.add(new Item(" ডাকাতি করা",  " ডাকাতি করা", category ));
        mItemList.add(new Item("চুরি করা",  "চুরি করা",category  ));

        mItemList.add(new Item("সুদ লেন-দেন করা, সুদ লেখা বা তাতে সাক্ষী থাকা",  "সুদ লেন-দেন করা, সুদ লেখা বা তাতে সাক্ষী থাকা", category ));
        mItemList.add(new Item("ঘুষ লেন-দেন করা",  "ঘুষ লেন-দেন করা", category ));
        mItemList.add(new Item(" গনিমত তথা জিহাদের মাধ্যমে কাফেরদের নিকট থেকে প্রাপ্ত সম্পদ বণ্টনের পূর্বে আত্মসাৎ করা",  " গনিমত তথা জিহাদের মাধ্যমে কাফেরদের নিকট থেকে প্রাপ্ত সম্পদ বণ্টনের পূর্বে আত্মসাৎ করা", category ));
        mItemList.add(new Item("স্ত্রীর পায়ু পথে যৌন ক্রিয়া করা",  "স্ত্রীর পায়ু পথে যৌন ক্রিয়া করা", category ));
        mItemList.add(new Item("জুলুম-অত্যাচার করা",  "জুলুম-অত্যাচার করা",category  ));
        mItemList.add(new Item("অস্ত্র দ্বারা ভয় দেখানো বা তা দ্বারা কাউকে ইঙ্গিত করা",  "অস্ত্র দ্বারা ভয় দেখানো বা তা দ্বারা কাউকে ইঙ্গিত করা", category ));
        mItemList.add(new Item("প্রতারণা বা ঠগ বাজী করা",  "প্রতারণা বা ঠগ বাজী করা", category ));
        mItemList.add(new Item("রিয়া বা লোক দেখানোর উদ্দেশ্যে সৎ আমল করা",  "রিয়া বা লোক দেখানোর উদ্দেশ্যে সৎ আমল করা",  category));
        mItemList.add(new Item("স্বর্ণ বা রৌপ্যের তৈরি পাত্র ব্যবহার করা",  "স্বর্ণ বা রৌপ্যের তৈরি পাত্র ব্যবহার করা", category ));
        mItemList.add(new Item("পুরুষের রেশমি পোশাক এবং স্বর্ণ ও রৌপ্য পরিধান করা",  "পুরুষের রেশমি পোশাক এবং স্বর্ণ ও রৌপ্য পরিধান করা", category ));

        mItemList.add(new Item(" সাহাবীদের গালি দেয়া",  " সাহাবীদের গালি দেয়া", category ));
        mItemList.add(new Item("নামাযরত অবস্থায় মুসল্লির সামনে দিয়ে গমন করা",  "নামাযরত অবস্থায় মুসল্লির সামনে দিয়ে গমন করা", category ));
        mItemList.add(new Item("মনিবের নিকট থেকে কৃতদাসের পলায়ন",  "মনিবের নিকট থেকে কৃতদাসের পলায়ন",category  ));
        mItemList.add(new Item("ভ্রান্ত মতবাদ জাহেলী রীতিনীতি অথবা বিদআতের প্রতি আহবান করা",  "ভ্রান্ত মতবাদ জাহেলী রীতিনীতি অথবা বিদআতের প্রতি আহবান করা", category ));
        mItemList.add(new Item("পবিত্র মক্কা ও মদীনায় কোন অপকর্ম বা দুষ্কৃতি করা",  "পবিত্র মক্কা ও মদীনায় কোন অপকর্ম বা দুষ্কৃতি করা", category ));
        mItemList.add(new Item(" কোন দুষ্কৃতিকারীকে প্রশ্রয় দেয়া",  " কোন দুষ্কৃতিকারীকে প্রশ্রয় দেয়া",  category));
        mItemList.add(new Item(" আল্লাহর ব্যাপারে অনধিকার চর্চা করা",  " আল্লাহর ব্যাপারে অনধিকার চর্চা করা", category ));
        mItemList.add(new Item("বিনা প্রয়োজনে তালাক চাওয়া",  "বিনা প্রয়োজনে তালাক চাওয়া", category ));
        mItemList.add(new Item(" যে নারীর প্রতি তার স্বামী অসন্তুষ্ট",  " যে নারীর প্রতি তার স্বামী অসন্তুষ্ট", category ));
        mItemList.add(new Item(" স্বামীর অবাধ্য হওয়া",  " স্বামীর অবাধ্য হওয়া", category ));

        mItemList.add(new Item("স্ত্রী কর্তৃক স্বামীর অবদান অস্বীকার করা",  "স্ত্রী কর্তৃক স্বামীর অবদান অস্বীকার করা",category  ));
        mItemList.add(new Item("স্বামী-স্ত্রীর মিলনের কথা জনসম্মুখে প্রকাশ করা",  "স্বামী-স্ত্রীর মিলনের কথা জনসম্মুখে প্রকাশ করা", category ));
        mItemList.add(new Item("স্বামী-স্ত্রীর মাঝে বিবাদ সৃষ্টি করা",  "স্বামী-স্ত্রীর মাঝে বিবাদ সৃষ্টি করা", category ));
        mItemList.add(new Item("বেশী বেশী অভিশাপ দেয়া",  "বেশী বেশী অভিশাপ দেয়া", category ));
        mItemList.add(new Item("বিশ্বাস ঘাতকতা করা",  "বিশ্বাস ঘাতকতা করা", category ));
        mItemList.add(new Item(" অঙ্গীকার পূরণ না করা",  " অঙ্গীকার পূরণ না করা", category ));
        mItemList.add(new Item(" আমানতের খিয়ানত করা",  " আমানতের খিয়ানত করা", category ));
        mItemList.add(new Item("প্রতিবেশীকে কষ্ট দেয়া",  "প্রতিবেশীকে কষ্ট দেয়া",  category));
        mItemList.add(new Item("ঋণ পরিশোধ না করা",  "ঋণ পরিশোধ না করা", category ));
        mItemList.add(new Item("বদ মেজাজি ও এমন অহংকারী যে উপদেশ গ্রহণ করে না",  "বদ মেজাজি ও এমন অহংকারী যে উপদেশ গ্রহণ করে না",  category));

        mItemList.add(new Item("তাবিজ-কবজ, রিং, সুতা ইত্যাদি ঝুলানো",  "তাবিজ-কবজ, রিং, সুতা ইত্যাদি ঝুলানো",  category));
        mItemList.add(new Item(" পরীক্ষায় নকল করা",  " পরীক্ষায় নকল করা",  category));
        mItemList.add(new Item(" ভেজাল পণ্য বিক্রয় করা",  " ভেজাল পণ্য বিক্রয় করা",  category));
        mItemList.add(new Item(" ইচ্ছাকৃত ভাবে জেনে শুনে অন্যায় বিচার করা",  " ইচ্ছাকৃত ভাবে জেনে শুনে অন্যায় বিচার করা",  category));
        mItemList.add(new Item("আল্লাহ বিধান ব্যতিরেকে বিচার- ফয়সালা করা",  "আল্লাহ বিধান ব্যতিরেকে বিচার- ফয়সালা করা",  category));
        mItemList.add(new Item(" দুনিয়া কামানোর উদ্দেশ্যে দীনী ইলম অর্জন করা",  " দুনিয়া কামানোর উদ্দেশ্যে দীনী ইলম অর্জন করা",  category));
        mItemList.add(new Item(" কোন ইলম সম্পর্কে জিজ্ঞাসা করা হলে জানা সত্যেও তা গোপন করা",  " কোন ইলম সম্পর্কে জিজ্ঞাসা করা হলে জানা সত্যেও তা গোপন করা",  category));
        mItemList.add(new Item("নিজের পিতা ছাড়া অন্যকে পিতা বলে দাবী করা",  "নিজের পিতা ছাড়া অন্যকে পিতা বলে দাবী করা",  category));
        mItemList.add(new Item("আল্লাহর রাস্তায় বাধা দেয়া",  "আল্লাহর রাস্তায় বাধা দেয়া",  category));
    }




    private void insertQuestions() {
        for(Item q : mItemList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_OPTION1, q.getmOption1());
            contentValues.put(COLUMN_ANSWER, q.getmAnswer());
            contentValues.put(COLUMN_CATEGORY, q.getmCategory());
            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    public ArrayList<Item> getAllQuestions(String categoryID) {
        Log.d("TAG", "Getting all questions for : " + categoryID);
        ArrayList<Item> itemList = new ArrayList<>();
        db = getReadableDatabase();
        String SELECT_TABLE_QUERY = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_CATEGORY + " = \"" + categoryID + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if(cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setmOption1(cursor.getString(cursor.getColumnIndex(COLUMN_OPTION1)));

                item.setmAnswer(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER)));
                itemList.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return itemList;
    }

}

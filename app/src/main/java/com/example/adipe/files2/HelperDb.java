package com.example.adipe.files2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import static com.example.adipe.files2.Age.AGE;
import static com.example.adipe.files2.Age.BRSI;
import static com.example.adipe.files2.Age.CLASS;
import static com.example.adipe.files2.Age.KEY_ID;
import static com.example.adipe.files2.Age.TABLE_AGE;
import static com.example.adipe.files2.Name.FNAME;
import static com.example.adipe.files2.Name.KEY_ID1;
import static com.example.adipe.files2.Name.LNAME;
import static com.example.adipe.files2.Name.TABLE_USERS;

public  class HelperDb extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;

    public HelperDb (Context context) {
        super( context,  DATABASE_NAME,  null, DATABASE_VERSION);
        this.strCreate=strCreate;
        this.strDelete=strDelete;
    }

        @Override
        public void onCreate(SQLiteDatabase db) {


            strCreate="CREATE TABLE "+TABLE_USERS;
            strCreate+=" ("+KEY_ID1+" INTEGER PRIMARY KEY,";
            strCreate+=" "+FNAME+" TEXT,";
            strCreate+=" "+LNAME+" TEXT";
            strCreate+=");";
            db.execSQL(strCreate);


            strCreate="CREATE TABLE "+TABLE_AGE;
            strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
            strCreate+=" "+AGE+" INTEGER,";
            strCreate+=" "+ BRSI+" TEXT,";
            strCreate+=" "+ CLASS+" TEXT";
            strCreate+=");";
            db.execSQL(strCreate);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            strDelete = "DROP TABLE IF EXISTS " + TABLE_USERS;
            db.execSQL(strDelete);
            strDelete = "DROP TABLE IF EXISTS " + TABLE_AGE;
            db.execSQL(strDelete);
            onCreate(db);
        }
    }


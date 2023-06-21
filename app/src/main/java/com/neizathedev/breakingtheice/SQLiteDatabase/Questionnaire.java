package com.neizathedev.breakingtheice.SQLiteDatabase;

/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:06 PM
 */


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.neizathedev.breakingtheice.Model.TestClass;

/* loaded from: classes8.dex */
public class Questionnaire extends SQLiteOpenHelper {
    private static final String DB_NAME = "usersDB";
    private static final int DB_VERSION = 1;
    private static final String EMAIL_COL = "email";
    private static final String TABLE_NAME = "Users";
    private static final String a = "a";
    private static final String b = "b";
    private static final String c = "c";
    private static final String d = "d";
    private static final String e = "e";
    private static final String f = "f";
    private static final String g = "g";
    private static final String h = "h";
    private static final String i = "i";
    private static final String j = "j";
    private static final String k = "k";
    private static final String l = "l";
    private static final String m = "m";
    private static final String n = "n";
    private static final String o = "o";
    TestClass U;

    public Questionnaire(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        onCreate(db);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Users(email TEXT,a TEXT,b TEXT,c TEXT,d TEXT,e TEXT,f TEXT,g TEXT,h TEXT,i TEXT,j TEXT,k TEXT,l TEXT,m TEXT,n TEXT,o TEXT)");
    }

    public void deleteStudent(TestClass delUser) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, "email = ?", new String[]{String.valueOf(delUser.getId())});
        db.close();
    }

    public Cursor getData() {
        SQLiteDatabase DB = getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Users", null);
        return cursor;
    }
}

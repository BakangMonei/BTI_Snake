package com.neizathedev.breakingtheice.SQLiteDatabase;

/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:05 PM
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes8.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String COLUMN_ID = "id";
    private static final String COLUMN_ID2 = "id";
    public static final String COLUMN_NAME = "name";
    private static final String COLUMN_NAME2 = "name";
    public static final String COLUMN_PATH = "path";
    private static final String COLUMN_PATH2 = "path";
    private static final String DATABASE_NAME = "documents.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "documents";
    private static final String TABLE_NAME2 = "documents";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE documents(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, path TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS documents");
        onCreate(db);
    }

    public boolean insertDocument(String name, String path) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("path", path);
        long result = db.insert("documents", null, contentValues);
        return result != -1;
    }

    public Cursor getDocument(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {"path"};
        String[] selectionArgs = {String.valueOf(id)};
        return db.query("documents", projection, "id=?", selectionArgs, null, null, null);
    }
}
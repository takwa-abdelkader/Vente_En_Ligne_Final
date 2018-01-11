package com.example.takwa.test_vente.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.takwa.test_vente.Database.DataBaseHelper;
import com.example.takwa.test_vente.Model.Client;

/**
 * Created by takwa on 11/01/2018.
 */

public class DOAClient {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ClientDB";
    public static final String TABLE_NAME = "Client";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PRENOM = "prenom";
    public static final String KEY_TEL = "tel";
    public static final String KEY_PM = "pm";
    public static final String KEY_EMAIL = "email";


    private DataBaseHelper dbhelper;
    private Context context;

    public DOAClient(Context context)
    {
        this.context = context;
        this.dbhelper = new DataBaseHelper(context);
    }


    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY autoincrement," + KEY_NAME + "TEXT," + KEY_PRENOM + "TEXT," + KEY_TEL + "TEXT," + KEY_PM + "TEXT," + KEY_EMAIL +
                "TEXT);");

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void addClient(Client cl) {
        ContentValues v = new ContentValues();
        v.put(KEY_ID, cl.getId());}
}
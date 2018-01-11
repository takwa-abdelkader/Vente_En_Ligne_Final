package com.example.takwa.test_vente.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.takwa.test_vente.DAO.DAOCategory;
import com.example.takwa.test_vente.DAO.DAOProduct;
import com.example.takwa.test_vente.DAO.DOAClient;

/**
 * Created by takwa on 10/01/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "VenteDB";

    private Context context;

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        DAOCategory.onCreate(sqLiteDatabase);
        DAOProduct.onCreate(sqLiteDatabase);
        DOAClient.onCreate(sqLiteDatabase);

        //        Initiate Data
        DataInitialisation.initiateCategories(sqLiteDatabase, context);
        Log.e("database helper ", "data base helper oncreate Categories ok");

        DataInitialisation.initiateProducts(sqLiteDatabase,context);
        Log.e("database helper ", "data base helper oncreate Product ok");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        DAOCategory.onUpgrade(sqLiteDatabase, i, i1);
    }
}

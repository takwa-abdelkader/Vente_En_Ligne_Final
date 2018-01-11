package com.example.takwa.test_vente.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.takwa.test_vente.Database.DataBaseHelper;
import com.example.takwa.test_vente.Model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takwa on 10/01/2018.
 */

public class DAOCategory
{
    private Context context;
    private DataBaseHelper dbhelper;
    private static final String LOG = "CategorY DAO";

    // Database table Tags Strings
    public static final String TABLE_CATEGORY = "category";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LABEL = "label";
    public static final String[] LIST_CATEGORIS ={"cartes","moteurs","cables"};

    // Class Constructor
    public DAOCategory(Context context)
    {
        this.context = context;
        this.dbhelper = new DataBaseHelper(context);
    }

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CATEGORY
            + " ("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LABEL + " text not null"
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        try {
            database.execSQL(DATABASE_CREATE);
            Log.e("Category_create",DATABASE_CREATE);
        }catch (Exception ex)
        {
            Log.e("CategoriCreate",ex.toString());
        }

    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(Category.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        onCreate(database);
    }


    /**
     * getting all categories
     * */
    public List<Category> getAllCategoris() {
        List<Category> categories = new ArrayList<Category>();
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY;

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        Log.e(LOG,selectQuery);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            Log.e(LOG,"c moved to first");
            do {
                Category cat = new Category();
                cat.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
                cat.setLabel((c.getString(c.getColumnIndex(COLUMN_LABEL))));

                // adding to user list
                categories.add(cat);
            } while (c.moveToNext());
        }

        Log.e(LOG,String.valueOf(categories));

        return categories;
    }

    /**
     * get categorie by Label
     */
    public static Category getCategoryByLabel(String label, SQLiteDatabase db)
    {
        String selectQuery = "SELECT * FROM "+TABLE_CATEGORY + " WHERE "
                + COLUMN_LABEL + " = \"" + label + "\";" ;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Category cat = new Category();
        cat.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
        cat.setLabel((c.getString(c.getColumnIndex(COLUMN_LABEL))));

        return cat;
    }
}

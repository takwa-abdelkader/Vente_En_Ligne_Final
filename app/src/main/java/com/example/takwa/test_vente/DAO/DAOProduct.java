package com.example.takwa.test_vente.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.takwa.test_vente.Database.DataBaseHelper;
import com.example.takwa.test_vente.Model.Category;
import com.example.takwa.test_vente.Model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takwa on 10/01/2018.
 */

public class DAOProduct
{

    private Context context;
    private DataBaseHelper dbhelper;
    private static final String LOG = "Product DAO";

    // Database table Tags Strings
    public static final String TABLE_PRODUCT = "product";
    public static final String COLUMN_REFERENCE = "Reference";
    public static final String COLUMN_NOM = "Nom";
    public static final String COLUMN_PRIX = "prix";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_CATEGORY = "category";

    // Class Constructor
    public DAOProduct(Context context)
    {
        this.context = context;
        this.dbhelper = new DataBaseHelper(context);
    }

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_PRODUCT
            + " ("
            + COLUMN_REFERENCE + " text primary key, "
            + COLUMN_NOM + " text not null, "
            + COLUMN_PRIX + " REAL not null, "
            + COLUMN_DESCRIPTION + " text not null, "
            + COLUMN_CATEGORY + " INTEGER not null, "
            + " FOREIGN KEY ("+COLUMN_REFERENCE+") REFERENCES "+ DAOCategory.TABLE_CATEGORY+"("+DAOCategory.COLUMN_ID+"));";

    public static void onCreate(SQLiteDatabase database) {
        try {
            database.execSQL(DATABASE_CREATE);
            Log.e("Product_create",DATABASE_CREATE);
        }catch (Exception ex)
        {
           // Log.e("ProductCreate",ex.toString());
            Log.e("ProductCreate","erreur dans oncreat Product DAO");
        }

    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,int newVersion)
    {
        Log.w(Product.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(database);
    }



    /**
     * getting all Product by category
     * */
    public List<Product> getAllProduct(Category category) {
        List<Product> products = new ArrayList<Product>();
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCT
                +" WHERE "+ COLUMN_CATEGORY +" = "+ category.getId()+ " ;";

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        Log.e(LOG,selectQuery);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            Log.e(LOG,"c moved to first");
            do {
                Product prod = new Product();

                prod.setReference(c.getString(c.getColumnIndex(COLUMN_REFERENCE)));
                prod.setNom(c.getString(c.getColumnIndex(COLUMN_NOM)));
                prod.setDescription(c.getString(c.getColumnIndex(COLUMN_DESCRIPTION)));
                prod.setPrix(c.getFloat(c.getColumnIndex(COLUMN_PRIX)));
                prod.setCategory(c.getInt(c.getColumnIndex(COLUMN_CATEGORY)));

                // adding to user list
                products.add(prod);
            } while (c.moveToNext());
        }

        Log.e(LOG,String.valueOf(products));
        return products;
    }


}

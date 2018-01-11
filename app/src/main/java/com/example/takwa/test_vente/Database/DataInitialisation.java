package com.example.takwa.test_vente.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.takwa.test_vente.DAO.DAOCategory;
import com.example.takwa.test_vente.DAO.DAOProduct;
import com.example.takwa.test_vente.Model.Category;

/**
 * Created by takwa on 10/01/2018.
 */

public class DataInitialisation
{

    static void initiateCategories(SQLiteDatabase database, Context context)
    {
        // initiate categories
        ContentValues values;
        for (int i = 0; i < DAOCategory.LIST_CATEGORIS.length; i++)
        {
            values = new ContentValues();
            values.put(DAOCategory.COLUMN_LABEL, DAOCategory.LIST_CATEGORIS[i]);
            // insert row
            database.insert(DAOCategory.TABLE_CATEGORY, null, values);
        }

    }


    static void initiateProducts(SQLiteDatabase database, Context context)
    {

        ContentValues valuesProduct;

        Category first = DAOCategory.getCategoryByLabel(DAOCategory.LIST_CATEGORIS[0],database);
        int id_category = first.getId();
        // initiate products
        for (int i = 0; i < 10; i++) {
            valuesProduct = new ContentValues();
            valuesProduct.put(DAOProduct.COLUMN_REFERENCE, "moteur"+i);
            valuesProduct.put(DAOProduct.COLUMN_NOM, "moteur");
            valuesProduct.put(DAOProduct.COLUMN_PRIX, 11.52);
            valuesProduct.put(DAOProduct.COLUMN_DESCRIPTION, "Moteur DC 5v");
            valuesProduct.put(DAOProduct.COLUMN_CATEGORY, id_category);

            // insert row
            database.insert(DAOProduct.TABLE_PRODUCT, null, valuesProduct);
        }

        Category second = DAOCategory.getCategoryByLabel(DAOCategory.LIST_CATEGORIS[1],database);
        int id_second = first.getId();
        // initiate products
        for (int i = 0; i < 10; i++) {
            valuesProduct = new ContentValues();
            valuesProduct.put(DAOProduct.COLUMN_REFERENCE, "carte"+i);
            valuesProduct.put(DAOProduct.COLUMN_NOM, "cartes");
            valuesProduct.put(DAOProduct.COLUMN_PRIX, 11.52);
            valuesProduct.put(DAOProduct.COLUMN_DESCRIPTION, "STM");
            valuesProduct.put(DAOProduct.COLUMN_CATEGORY, id_second);

            // insert row
            database.insert(DAOProduct.TABLE_PRODUCT, null, valuesProduct);
        }
    }

}

package com.example.takwa.test_vente.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.takwa.test_vente.Adapter.ProductAdapter;
import com.example.takwa.test_vente.DAO.DAOCategory;
import com.example.takwa.test_vente.DAO.DAOProduct;
import com.example.takwa.test_vente.Model.Category;
import com.example.takwa.test_vente.Model.Product;
import com.example.takwa.test_vente.R;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private List<Product> productList;
    private RecyclerView recyclerView;
    private ProductAdapter ProdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Category category = (Category) getIntent().getExtras().getSerializable(DAOCategory.TABLE_CATEGORY);

        Log.d("Product Activity ","oncreate ");
        //set Product  list
        DAOProduct productDAO = new DAOProduct(this);
        productList = productDAO.getAllProduct(category);

        //set recycler view
        ProdAdapter = new ProductAdapter(productList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.product_list);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(ProdAdapter);
    }
}

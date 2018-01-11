package com.example.takwa.test_vente.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.takwa.test_vente.Adapter.CategoriesAdapter;
import com.example.takwa.test_vente.Adapter.RecyclerItemClickListener;
import com.example.takwa.test_vente.DAO.DAOCategory;
import com.example.takwa.test_vente.Model.Category;
import com.example.takwa.test_vente.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private List<Category> categoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoriesAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //set categories list
        DAOCategory categorieDAO = new DAOCategory(this);
        categoryList = categorieDAO.getAllCategoris();

        //set recycler view
        cAdapter = new CategoriesAdapter(categoryList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.category_list);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
                        intent.putExtra(DAOCategory.TABLE_CATEGORY, categoryList.get(position));
//                        Toast.makeText(CategoryActivity.this, "test "+categoryList.get(position).getId(), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                })
        );


    }

}

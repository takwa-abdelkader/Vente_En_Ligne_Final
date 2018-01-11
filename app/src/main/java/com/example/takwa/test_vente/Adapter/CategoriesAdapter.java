package com.example.takwa.test_vente.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.takwa.test_vente.R;
import com.example.takwa.test_vente.Model.Category;

import java.util.List;

/**
 * Created by takwa on 10/01/2018.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {

    private List<Category> categoriesList;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView label;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            label = (TextView) view.findViewById(R.id.category_label);
        }
    }

    //Constructor
    public CategoriesAdapter(List<Category> categoriesList)
    {
        this.categoriesList = categoriesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_row, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category category = categoriesList.get(position);
        holder.label.setText(category.getLabel());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
}

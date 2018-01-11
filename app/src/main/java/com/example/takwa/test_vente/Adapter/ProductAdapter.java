package com.example.takwa.test_vente.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.takwa.test_vente.R;
import com.example.takwa.test_vente.Model.Product;

import java.util.List;

/**
 * Created by takwa on 10/01/2018.
 */

public class  ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>
{

private List<Product> ProductList;
private String Log ;

public class MyViewHolder extends RecyclerView.ViewHolder
{
    public TextView Reference ;
    public TextView Nom;
    public TextView prix ;

    public MyViewHolder(View view)
    {
        super(view);
        Reference = (TextView) view.findViewById(R.id.TV_reference);
        Nom=(TextView) view.findViewById(R.id.TV_nom);
        prix=(TextView) view.findViewById(R.id.TV_prix);

    }
}
    //Constructor
    public ProductAdapter(List<Product> ProductList)
    {
        this.ProductList = ProductList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Product product = ProductList.get(position);
        holder.Reference.setText(product.getReference());
        holder.Nom.setText(product.getNom());
        holder.prix.setText(String.valueOf( product.getPrix()));
    }

    @Override
    public int getItemCount()
    {
        return ProductList.size();
    }

}


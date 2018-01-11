package com.example.takwa.test_vente.Adapter;

/**
 * Created by takwa on 11/01/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import com.example.takwa.test_vente.Model.Post;
import com.example.takwa.test_vente.R;

public class PostAdapteur extends RecyclerView.Adapter <PostAdapteur.ViewHoler> {
    public static class ViewHoler extends RecyclerView.ViewHolder {
        TextView ref,nom,prix,qt;
        public ViewHoler(View itemView) {
            super(itemView);
            ref = (TextView) itemView.findViewById(R.id.ref) ;
            nom = (TextView) itemView.findViewById(R.id.nom) ;
            prix = (TextView) itemView.findViewById(R.id.prix) ;
            qt = (TextView) itemView.findViewById(R.id.quantite) ;
        }        }
    private Context context;
    private List<Post> posts ;
    public PostAdapteur (Context c, List<Post> postList){
        this.context=c;
        posts =postList ;
    }
    @Override
    public PostAdapteur.ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=  LayoutInflater.from(context).inflate(R.layout.item_post,parent,false);

        return new ViewHoler(v);
    }
    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        Post p =posts.get(position);
        holder.ref.setText(p.getRef());
        holder.nom.setText(p.getNom());
        holder.prix.setText(p.getPrix());
        holder.qt.setText(p.getQt());
    }
    @Override
    public int getItemCount() {
        return posts.size();
    }


}
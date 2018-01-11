package com.example.takwa.test_vente.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.takwa.test_vente.Adapter.PostAdapteur;
import com.example.takwa.test_vente.Model.Post;
import com.example.takwa.test_vente.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class Affichier_Panier extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private PostAdapteur postAdapteur ;
    private ArrayList<Post> posts ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichier__panier);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        posts = new ArrayList<>() ;
        for (int i = 0; i < 10; i++){
            posts.add(new Post("reference"+ i ,"nom"+ i ,"prix" +i,"quantite"+i)) ;
        }
        postAdapteur = new PostAdapteur(this,posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;
        recyclerView.setAdapter(postAdapteur);

    }
}

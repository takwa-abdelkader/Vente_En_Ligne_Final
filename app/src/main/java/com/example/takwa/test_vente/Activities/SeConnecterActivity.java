package com.example.takwa.test_vente.Activities;

import com.example.takwa.test_vente.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.example.takwa.test_vente.Database.DataBaseHelper;
import com.example.takwa.test_vente.Model.Client;

import java.util.ArrayList;



public class SeConnecterActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_connecter);
        email = (EditText) findViewById(R.id.adresse);
        password = (EditText) findViewById(R.id.pass);
    }

    public void connecter(View view) {
        DataBaseHelper db = new DataBaseHelper(getApplicationContext());
        String mail =email.getText().toString();
        String pass= password.getText().toString();
        ArrayList<Client> lst=new ArrayList<Client>();
        if((email.equals(lst.get(5)))&&(password.equals(lst.get(4)))) {
            Intent i=new Intent(this,CategoryActivity.class);
            startActivity(i);
        }
    }


    public void inscrire(View view) {
        Intent intent = new Intent(SeConnecterActivity.this, SInscrireActivity.class);
        startActivity(intent);
    }
}
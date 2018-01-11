package com.example.takwa.test_vente.Activities;

import com.example.takwa.test_vente.DAO.DOAClient;
import com.example.takwa.test_vente.Database.DataBaseHelper;
import com.example.takwa.test_vente.Model.Client;
import com.example.takwa.test_vente.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SInscrireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinscrire);
    }

    public void inscrire (View view) {
        int i=1;
        DOAClient doaClient = new DOAClient(getApplicationContext());
        EditText email = (EditText) findViewById(R.id.tv_email);
        EditText password = (EditText) findViewById(R.id.tv_pm);
        EditText nom= (EditText) findViewById(R.id.tv_name);
        EditText prenom= (EditText) findViewById(R.id.tv_prenom);
        EditText phone= (EditText) findViewById(R.id.tv_pm);

        String mail =email.getText().toString();
        String pass= password.getText().toString();
        String name =email.getText().toString();
        String pre_name= password.getText().toString();
        int telephone= Integer.parseInt(phone.getText().toString());
        Client cl=new Client('i',name,pre_name,telephone,pass,mail);
        doaClient.addClient(cl);
        i++;
        List<Client> lst=new ArrayList<Client>();
        Toast.makeText(this, "ajouter  client  avec succes", Toast.LENGTH_LONG).show();
    }
}

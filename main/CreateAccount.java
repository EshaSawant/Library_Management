package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener{
    private LibraryDatabase Accdb;
    private List<Account> accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        View button1=findViewById(R.id.login);
        button1.setOnClickListener(this);
        Accdb=LibraryDatabase.getInstance(this);
    }

    @Override
    public void onClick(View view) {
        EditText inputUsername;
        EditText inputPassword;
        String username;
        String password;

        if(view.getId()==R.id.login){
            inputUsername=findViewById(R.id.username);
            inputPassword=findViewById(R.id.password);
            username=inputUsername.getText().toString();
            password=inputPassword.getText().toString();

            int flag=0;
            accountList=Accdb.account().getAll();
            for(int i = 0;i< accountList.size();i++) {
                if (username.equals(accountList.get(i).getUsername())) {
                    Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
            }
            if (username.equals("!admin2")) {
                Toast.makeText(this, "Username reserved for admin", Toast.LENGTH_SHORT).show();
                flag = 1;
            }
            if(username.isEmpty() && password.isEmpty()){
                Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show();
                flag=1;
            }
            if(username.isEmpty() && !password.isEmpty()){
                Toast.makeText(this,"Username can't be empty", Toast.LENGTH_SHORT).show();
                flag=1;
            }
            if(!username.isEmpty() && password.isEmpty()){
                Toast.makeText(this,"Password can't be empty", Toast.LENGTH_SHORT).show();
                flag=1;
            }
            if(flag==0) {
                Accdb.insert(username, password);
                Toast.makeText(this, "Account Created: "+username, Toast.LENGTH_SHORT).show();
                Accdb.insert("Account Created: "+username);
                Intent main=new Intent(this,MainActivity.class);
                startActivity(main);
            }
        }
    }
}
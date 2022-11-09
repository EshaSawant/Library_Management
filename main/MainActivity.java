package com.example.librarysystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.librarysystem.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityMainBinding binding;
    private LibraryDatabase Accdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Accdb=LibraryDatabase.getInstance(this);
        Accdb.populateInitialData();
        Accdb.populateBookData();

        View button1=findViewById(R.id.create_account);
        button1.setOnClickListener(this);
        View button2=findViewById(R.id.place_hold);
        button2.setOnClickListener(this);
        View button3=findViewById(R.id.manage_system);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.create_account){
            Intent create=new Intent(this,CreateAccount.class);
            startActivity(create);
        }
        else if(view.getId()==R.id.place_hold){
            Intent hold=new Intent(this,Genre.class);
            startActivity(hold);
        }
        else if(view.getId()==R.id.manage_system){
            Intent manage=new Intent(this,ManageSystem.class);
            startActivity(manage);
        }
    }
}
package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Genre extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        View button1=findViewById(R.id.memoir);
        button1.setOnClickListener(this);
        View button2=findViewById(R.id.computer_sci);
        button2.setOnClickListener(this);
        View button3=findViewById(R.id.fiction);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.memoir){
            Intent login1=new Intent(this, Memoir.class);
            startActivity(login1);
        }
        if(view.getId()==R.id.computer_sci){
            Intent login2=new Intent(this, CS.class);
            startActivity(login2);
        }
        if(view.getId()==R.id.fiction){
            Intent login3=new Intent(this,Fiction.class);
            startActivity(login3);
        }
    }
}
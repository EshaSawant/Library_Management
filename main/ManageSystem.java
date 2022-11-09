package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ManageSystem extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_hold);
        View button1=findViewById(R.id.login_place);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText inputusername;
        EditText inputpassword;
        String username;
        String password;

        if(view.getId()==R.id.login_place){
            inputusername=findViewById(R.id.username);
            inputpassword=findViewById(R.id.password);
            username=inputusername.getText().toString();
            password=inputpassword.getText().toString();

            if(username.equals("!admin2") && password.equals("!admin2")){
                Intent placeHold= new Intent(this,AdminScreen.class);
                startActivity(placeHold);
            }
            else{
                Toast.makeText(this,"Username or Password not correct",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
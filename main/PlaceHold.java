package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PlaceHold extends AppCompatActivity implements View.OnClickListener{
    private LibraryDatabase db;
    private List<Account> accountList;
    private List<Transaction> transList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_hold);
        View button1=findViewById(R.id.login_place);
        button1.setOnClickListener(this);
        View button2=findViewById(R.id.backToMain);
        button2.setOnClickListener(this);
        db=LibraryDatabase.getInstance(this);
    }

    @Override
    public void onClick(View view) {
        EditText inputusername;
        EditText inputpassword;
        TextView accName = findViewById(R.id.username_name);
        TextView bookName = findViewById(R.id.book_title);
        TextView reservationNo = findViewById(R.id.reservation);
        String username;
        String password;
        String title = "";

        Bundle name=getIntent().getExtras();
        if(name!=null) {
            title = name.getString("Title");
        }
//        Log.d("Title",title);
        if (view.getId() == R.id.login_place) {

            inputusername = findViewById(R.id.username);
            inputpassword = findViewById(R.id.password);
            username = inputusername.getText().toString();
            password = inputpassword.getText().toString();
            bookName.setText(title);
            accountList = db.account().getAll();
            for (int i = 0; i < accountList.size(); i++) {
                if (username.equals(accountList.get(i).getUsername()) && password.equals(accountList.get(i).getPassword())) {
                    accName.setText(username);
                    db.book().deleteByTitle(title);
                    db.transact().AddTransact(new Transaction("Reservation: " + username + ": " + title));
                    transList = db.transact().getAllTransact();
                    for (int a = 0; a < transList.size(); a++) {
                        if (transList.get(a).getInfo().equals("Reservation: " + username + ": " + title)) {
                            String id = String.valueOf((transList.get(a).getId()));
                            reservationNo.setText(id);
                        }
                    }
                }
            }
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Username or password can't be empty", Toast.LENGTH_SHORT).show(); }
        }

        if(view.getId()==R.id.backToMain){
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
        }
    }

}
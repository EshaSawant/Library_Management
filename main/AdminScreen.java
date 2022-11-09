package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AdminScreen extends AppCompatActivity implements View.OnClickListener{
    private ListView transaction;
    private LibraryDatabase db;
    private List<Transaction> transactionList;
    private List<String> transact= new ArrayList<>();
    private ArrayAdapter<Transaction> TransAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);

        View button1 = findViewById(R.id.add_question);
        button1.setOnClickListener(this);
        View button2 = findViewById(R.id.no_add);
        button2.setOnClickListener(this);

        transaction = findViewById(R.id.transaction_list);
        db = LibraryDatabase.getInstance(this);
        transactionList = db.transact().getAllTransact();
        for (int i = 0; i < transactionList.size(); i++) {
            String trans = transactionList.get(i).getInfo();
            transact.add(trans);
        }

        TransAdapter = new ArrayAdapter(this, R.layout.all_transaction, R.id.transactionlist, transact);
        transaction.setAdapter(TransAdapter);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.add_question){
            Intent addQ=new Intent(this, AddQuestion.class);
            startActivity(addQ);
        }
        if(view.getId()==R.id.no_add){
            Intent main=new Intent(this,MainActivity.class);
            startActivity(main);
        }
    }
}
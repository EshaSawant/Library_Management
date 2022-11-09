package com.example.librarysystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.librarysystem.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class CS extends AppCompatActivity implements View.OnClickListener{
    private ListView csBooks;
    private LibraryDatabase db;
    private List<Book> bookList;
    private List<String> comp_sci=new ArrayList<>();
    private ArrayAdapter<Book> CSAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);
        View button1=findViewById(R.id.cs_back);
        button1.setOnClickListener(this);
        csBooks=findViewById(R.id.cs_list);
        db=LibraryDatabase.getInstance(this);
        bookList=db.book().getAllBook();
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getGenre().equals("Computer Science")){
                String book=bookList.get(i).getBookName();
                comp_sci.add(book);
            }
        }
        if(bookList.size()==0){
            String num="No Book Available";
            comp_sci.add(num);
        }
        CSAdapter=new ArrayAdapter(this,R.layout.cs_books,R.id.csbookslist,comp_sci);
        csBooks.setAdapter(CSAdapter);
        csBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                Intent Login = new Intent(CS.this,PlaceHold.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("Title",selected);
                Login.putExtras(extraInfo);
                startActivity(Login);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.cs_back){
            finish();
        }
    }
}
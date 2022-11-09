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

public class Memoir extends AppCompatActivity implements View.OnClickListener{
    private ListView memoirBooks;
    private LibraryDatabase db;
    private List<Book> bookList;
    private List<String> memoir=new ArrayList<>();
    private ArrayAdapter<Book> memoirAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoir);
        View button1=findViewById(R.id.mem_back);
        button1.setOnClickListener(this);
        memoirBooks=findViewById(R.id.memoir_list);
        db=LibraryDatabase.getInstance(this);
        bookList=db.book().getAllBook();
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getGenre().equals("Memoir")){
                String book=bookList.get(i).getBookName();
                memoir.add(book);
            }
        }
        if(bookList.size()==0){
            String num="No Book Available";
            memoir.add(num);
        }
        memoirAdapter=new ArrayAdapter(this,R.layout.memoir_books,R.id.memoirbookslist,memoir);
        memoirBooks.setAdapter(memoirAdapter);
        memoirBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                Intent Login = new Intent(Memoir.this,PlaceHold.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("Title",selected);
                Login.putExtras(extraInfo);
                startActivity(Login);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.mem_back){
            finish();
        }
    }
}
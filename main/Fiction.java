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

public class Fiction extends AppCompatActivity implements View.OnClickListener{
    private ListView ficBooks;
    private LibraryDatabase db;
    private List<Book> bookList;
    private List<String> fiction=new ArrayList<>();
    private ArrayAdapter<Book> fictAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction);
        View button1=findViewById(R.id.fic_back);
        button1.setOnClickListener(this);
        ficBooks=findViewById(R.id.fiction_list);
        db=LibraryDatabase.getInstance(this);
        bookList=db.book().getAllBook();
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getGenre().equals("Fiction")){
                String book=bookList.get(i).getBookName();
                fiction.add(book);
            }
        }
        if(bookList.size()==0){
            String num="No Book Available";
            fiction.add(num);
        }
        fictAdapter=new ArrayAdapter(this,R.layout.fiction_books,R.id.fictionbookslist,fiction);
        ficBooks.setAdapter(fictAdapter);
        ficBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                Intent Login = new Intent(Fiction.this,PlaceHold.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("Title",selected);
                Login.putExtras(extraInfo);
                startActivity(Login);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.fic_back){
            finish();
        }
    }
}
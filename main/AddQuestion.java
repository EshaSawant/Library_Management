package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddQuestion extends AppCompatActivity implements View.OnClickListener {

    private LibraryDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        View button1=findViewById(R.id.addIntoDb);
        button1.setOnClickListener(this);
//        View button2=findViewById(R.id.back_button);
//        button2.setOnClickListener(this);
        db=LibraryDatabase.getInstance(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.addIntoDb) {
            EditText inBook = findViewById(R.id.add_book);
            EditText inGenre = findViewById(R.id.add_genre);
            EditText inAuthor = findViewById(R.id.add_author);
            String book, genre, author;
            book= inBook.getText().toString();
            genre=inGenre.getText().toString();
            author=inAuthor.getText().toString();
            int flag=0;
            if(book.isEmpty()){
                Toast.makeText(this, "The book title can't be empty", Toast.LENGTH_SHORT).show();
                flag=1;
            }
            if(genre.isEmpty()){
                Toast.makeText(this, "The book genre can't be empty", Toast.LENGTH_SHORT).show();
                flag=1;
            }
            if(author.isEmpty()){
                Toast.makeText(this, "The Author name can't be empty",Toast.LENGTH_SHORT).show();
                flag=1;
            }
            if(flag==0){
                db.book().AddBook(new Book(book,author,genre));
                Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

//        if(view.getId()==R.id.back_button){
//            finish();
//        }
    }
}
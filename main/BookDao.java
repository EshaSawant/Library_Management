package com.example.librarysystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void AddBook(Book book);

    @Delete
    void delete(Book book);

    @Query("SELECT COUNT(*) FROM Book")
    int countBook();

    @Query("SELECT * FROM Book")
    List<Book> getAllBook();

    @Query("delete from Book where Book_Title= :taskString")
    void deleteByTitle(String taskString);


}


package com.example.librarysystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.*;
@Dao
public interface QueryDao {
    @Insert
    void AccountCreate(Account account);

    @Query("SELECT COUNT(*) FROM Account")
    int count();

    @Query("SELECT * FROM Account")
    List<Account> getAll();

    @Delete
    void delete(Account account);
}

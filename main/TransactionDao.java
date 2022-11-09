package com.example.librarysystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionDao {
    @Insert
    void AddTransact(Transaction transaction);

    @Query("SELECT COUNT(*) FROM `Transaction`")
    int countTransact();

    @Query("SELECT * FROM `Transaction`")
    List<Transaction> getAllTransact();

    @Delete
    void delete(Transaction transaction);
}


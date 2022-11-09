package com.example.librarysystem;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Transaction")
public class Transaction{
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="Transactions")
    String info;

    public Transaction(String info) {
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

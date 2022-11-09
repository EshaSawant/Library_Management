package com.example.librarysystem;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Account.class,Book.class,Transaction.class},version=19,exportSchema = false)
public abstract class LibraryDatabase extends RoomDatabase {

    public abstract QueryDao account();
    public abstract BookDao book();
    public abstract TransactionDao transact();
    private static LibraryDatabase sInstance;

    public static synchronized LibraryDatabase getInstance(Context context){
        if(sInstance==null){
            sInstance= Room.databaseBuilder(context.getApplicationContext(),LibraryDatabase.class,"account.db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
            sInstance= Room.databaseBuilder(context.getApplicationContext(),LibraryDatabase.class,"book.db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
            sInstance= Room.databaseBuilder(context.getApplicationContext(),LibraryDatabase.class,"transact.db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return sInstance;
    }

    public void populateInitialData(){
        if(account().count()==0){
            runInTransaction(()->{
                account().AccountCreate(new Account("anton","t3nn1sch@mp22"));
                account().AccountCreate(new Account("bernie","k3ralaf@n"));
                account().AccountCreate(new Account("shirleybee","carmel12chicago"));
            });
        }
    }
    public void populateBookData(){
        if(book().countBook()==0){
            runInTransaction(()->{
                book().AddBook(new Book("Angela's Ashes","Frank McCourt","Memoir"));
                book().AddBook(new Book("The IDA Pro Book","Chris Eagle","Computer Science"));
                book().AddBook(new Book("Frankenstein","Mark Shelley","Fiction"));
            });
        }
    }
    public void insert(String username, String password){
        account().AccountCreate(new Account(username,password));
    }
    public void insert(String transaction){
        transact().AddTransact(new Transaction(transaction));
    }
}
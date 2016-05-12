package com.example.dafi.registerapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.params.StreamConfigurationMap;

public class DateBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD= "password";
    private static final String COLUMN_AGE = "age";

    private static final String CREATE_TABLE ="create table users (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
            "name text unique not null, username text not null, password text not null, age integer not null)";

    SQLiteDatabase db;

    public DateBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_TABLE);
            this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query  = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public String searchPass(String username){
         db = this.getReadableDatabase();

         String query = "SELECT username , password FROM  " + TABLE_NAME;
         Cursor cursor = db.rawQuery(query, null);
         String un, pass;
         pass = "not found";
        if(cursor.moveToFirst()){
            do{
                un = cursor.getString(0);

                if(un.equals(username)){
                    pass = cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        db.close();
        return  pass;
    }

    public  void insertUser(User user){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

//        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_AGE, user.getAge());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}

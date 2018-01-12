package com.example.erika.sqlitetest.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.erika.sqlitetest.Data.User;
import com.example.erika.sqlitetest.Helpers.SqliteHelper;
import com.example.erika.sqlitetest.Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erika on 11/01/2018.
 */

public class UserController {
    private SqliteHelper connection;

    public UserController(Context context){
        connection = new SqliteHelper(context, "test1", null, 1);
    }

    public boolean addUser(User user){
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilities.CAMPO_ID, user.getId());
        values.put(Utilities.CAMPO_NAME, user.getName());
        values.put(Utilities.CAMPO_PHONE_NUMBER, user.getPhone_number());

        long idResult = db.insert(Utilities.USER_TABLE, Utilities.CAMPO_ID, values);

        if(idResult == 0){
            return false;
        }
        return true;
    }

    public User getUser(String id){
        SQLiteDatabase db = connection.getWritableDatabase();
        String[] params ={id};
        String[] data = {Utilities.CAMPO_ID, Utilities.CAMPO_NAME, Utilities.CAMPO_PHONE_NUMBER};
        Cursor cursor = db.query(Utilities.USER_TABLE, data, Utilities.CAMPO_ID+"=?",params,null,null,null);
        cursor.moveToFirst();

        return new User(Integer.parseInt(cursor.getString(0)),cursor.getColumnName(1), cursor.getString(2));

    }

    public boolean updateUser(User user, String id){
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilities.CAMPO_ID, user.getId());
        values.put(Utilities.CAMPO_NAME, user.getName());
        values.put(Utilities.CAMPO_PHONE_NUMBER, user.getPhone_number());
        String[] params = {id};

        try{
            db.update(Utilities.USER_TABLE, values, Utilities.CAMPO_ID+"=?",params);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteUser(String id){
        SQLiteDatabase db =  connection.getWritableDatabase();
        String[] params = {id};
        try{
            db.delete(Utilities.USER_TABLE, Utilities.CAMPO_ID+"=?",params);
            db.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> list = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(Utilities.ALL_USERS, null);
            while(cursor.moveToNext()){
                list.add(new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }
            return list;
        }catch (Exception e){
            return null;
        }
    }
}

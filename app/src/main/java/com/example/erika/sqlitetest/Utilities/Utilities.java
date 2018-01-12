package com.example.erika.sqlitetest.Utilities;

/**
 * Created by erika on 11/01/2018.
 */

public class Utilities {

    //constantes tabla users
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NAME = "name";
    public static final String CAMPO_PHONE_NUMBER = "phone_number";
    public static final String USER_TABLE = "users";
    public static final String CREATE_TABLE_USERS = "CREATE TABLE "+ USER_TABLE +
            "("+ CAMPO_ID +" INTEGER, "+ CAMPO_NAME +" TEXT, "+ CAMPO_PHONE_NUMBER +" TEXT)";
    public static final String ALL_USERS = "SELECT * FROM "+USER_TABLE;
}

package com.example.contactmanagementsystem.SqlLiteD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Cms.db";
    private static final String TABLE_NAME = "users";
    private static final String U_ID = "_id";
    private static final String U_NAME = "name";
    private static final String U_MOBILE = "mobile";
    private static final String PASS = "password";
    private static final int DB_VERSION = 1;
    private static final String USER_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + U_NAME + " VARCHAR(255), " + U_MOBILE + " VARCHAR(255), " + PASS + " VARCHAR(255));";
    private static final String EMG_CON_TABLE = "CREATE TABLE emg_con ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR(32), phone_no VARCHAR(255), name VARCHAR(32), address VARCHAR(255));";
    private static final String EMP_LIST = "CREATE TABLE emp_details ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(255), mobile VARCHAR(32), email VARCHAR(55), designation VARCHAR(55), profile_pic VARCHAR(55));";
    private static final String SETTING = "CREATE TABLE setting ( _id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(255), logo VARCHAR(255), address VARCHAR(255), email VARCHAR(55), phone VARCHAR(32));";
    private static final String FATCH_BY_MOBILE = "SELECT * FROM " + TABLE_NAME + " WHERE " + U_MOBILE + " = ";
    private Context context;

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(USER_TABLE);
            Toast.makeText(context, " OnCreate is Called ", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, " Exception " + e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //    Data Insert Method Here

    public long addData(String mobileNo, String pass, String username){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(U_MOBILE, mobileNo);
        contentValues.put(PASS, pass);
        contentValues.put(U_NAME, username);

        long rowId  = db.insert(TABLE_NAME,null, contentValues);
        return rowId;

    }


    public boolean login(String mobile, String password) {

        // array of columns to fetch
        String[] columns = {U_MOBILE,U_NAME,U_ID};
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = U_MOBILE + " = ? AND " + PASS + " = ?" ;

        // selection argument
        String[] selectionArgs = {mobile,password};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        // SELECT mobileNo FROM users WHERE mobileNo = 0171767750
        Cursor cursor = db.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
}

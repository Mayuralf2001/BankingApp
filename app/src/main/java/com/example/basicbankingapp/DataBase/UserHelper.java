package com.example.basicbankingapp.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DataBase.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(122001,'Mayur Tawade', 'mayurt@gmail.com','7584','7887512558', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(122009,'Simran Tathe', 'simrant@gmail.com','1258','7057869899', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(122004,'Shubham More', 'shubham@gmail.com','8896','8321452388', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(122011,'Pratiksha Tapkir', 'pratikshat@gmail.com','7752','7620932110', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(122015,'Prathmesh Shewale', 'prathmesh@gmail.com','3669','9370220886', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(122020,'Akriti Singh', 'akritis@gmail.com','9985','9305532718', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(122022,'Shantanu Paturkar', 'shantanu@gmail.com','1207','8897640215', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(122025,'Akanksha Bandgar', 'akanksha@gmail.com','4522','7499534533', 9500)");
        db.execSQL("insert into " + TABLE_NAME + " values(122029,'Viraj Shitole', 'viraj@gmail.com','6582','7512450086', 11500)");
        db.execSQL("insert into " + TABLE_NAME + " values(122032,'Aryan Srivastav', 'aryan@gmail.com','5450','8726663922', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(122035,'Richa Singh', 'richa@gmail.com','2656','9579389470', 7600)");
        db.execSQL("insert into " + TABLE_NAME + " values(122039,'Anirudh Bora', 'anirudh@gmail.com','1203','7666954221', 14000)");
        db.execSQL("insert into " + TABLE_NAME + " values(122042,'Tanishka Sharma', 'tanishka@gmail.com','5566','7985025896', 1100)");
        db.execSQL("insert into " + TABLE_NAME + " values(122045,'Omkar Salunke', 'omkar@gmail.com','2236','7712555831', 4000)");
        db.execSQL("insert into " + TABLE_NAME + " values(122050,'Sonali Sonawane', 'sonali@gmail.com','6692','9851292156', 2500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
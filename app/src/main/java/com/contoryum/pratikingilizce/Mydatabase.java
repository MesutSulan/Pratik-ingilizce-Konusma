package com.contoryum.pratikingilizce;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Mydatabase {


    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static Mydatabase instance;

    private Mydatabase(Context context) {
        this.openHelper = new Data(context);
    }

    public static Mydatabase getInstance(Context context) {
        if (instance == null) {
            instance = new Mydatabase(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    public List<String> getQuotes() {
        ArrayList<String> list = new ArrayList<>();
        list.clear();
        int g0=OptionActivity.getposition();

        Cursor cursor;

        cursor = database.rawQuery("SELECT * FROM aa", null);

        if (g0==0){
            cursor.moveToFirst();
        }else if (g0==1){
            cursor.moveToPosition(21);
        }else if (g0==2){
            cursor.moveToPosition(41);
        }else if (g0==3){
            cursor.moveToPosition(61);
        }else if (g0==4){
            cursor.moveToPosition(81);
        }else if (g0==5){
            cursor.moveToPosition(101);
        }else if (g0==6){
            cursor.moveToPosition(121);
        }else if (g0==7){
            cursor.moveToPosition(141);
        }else if (g0==8){
            cursor.moveToPosition(161);
        }else if (g0==9){
            cursor.moveToPosition(179);
        }
        try {

            while (cursor != null) {

                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
                list.add(cursor.getString(3));
                list.add(cursor.getString(4));
                cursor.moveToNext();




            }
            cursor.close();



        }catch (Exception e){

        }

        return list;
    }

    public List<String> getcvp() {
        ArrayList<String> listcvp = new ArrayList<>();
        listcvp.clear();
        int g0=OptionActivity.getposition();

        Cursor cursor;

        cursor = database.rawQuery("SELECT * FROM aa", null);

        if (g0==0){
            cursor.moveToFirst();
        }else if (g0==1){
            cursor.moveToPosition(21);
        }else if (g0==2){
            cursor.moveToPosition(41);
        }else if (g0==3){
            cursor.moveToPosition(61);
        }else if (g0==4){
            cursor.moveToPosition(81);
        }else if (g0==5){
            cursor.moveToPosition(101);
        }else if (g0==6){
            cursor.moveToPosition(121);
        }else if (g0==7){
            cursor.moveToPosition(141);
        }else if (g0==8){
            cursor.moveToPosition(161);
        }else if (g0==9){
            cursor.moveToPosition(179);
        }
        try {

            while (cursor != null) {

                listcvp.add(cursor.getString(5));
                cursor.moveToNext();

            }
            cursor.close();



        }catch (Exception e){

        }

        return listcvp;
    }
}

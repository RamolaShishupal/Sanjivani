package com.example.sanjivani;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MyDbHelper extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase db,db1;

    MyDbHelper(Context context)
    {
        super(context,"donor",null,1);
        this.context=context;
        db=this.getWritableDatabase();
        
//        super(context,"hospital",null,1);
//        this.context=context;
//        db1=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q="create table donor (dname text,dpass text,duname text primary key,dbg text,dadd text,dage integer)";
        db.execSQL(q);
        String q1="create table hospital(hname text,hpass text,huname text primary key,haname text,hadd text)";
        db.execSQL(q1);
        
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1){

    }
    public  void  addDonor(String dname ,String dpass ,String duname,String dbg,String dadd,int age)
    {
        ContentValues  cv =new ContentValues();

        cv.put("dname",dname);
        cv.put("dpass",dpass);
        cv.put("duname",duname);
        cv.put("dbg",dbg);
        cv.put("dadd",dadd);
        cv.put("dage",age);



        long rid=db.insert("donor",null,cv);
        if (rid<0){
            Toast.makeText(context,"error --", LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"1 record inserted ", LENGTH_SHORT).show();
        }


        
    }
    public  void  addHospital(String hname ,String hpass ,String huname,String haname,String hadd)
    {
        ContentValues  cv =new ContentValues();

        cv.put("hname",hname);
        cv.put("hpass",hpass);
        cv.put("huname",huname);
        cv.put("haname",haname);
        cv.put("hadd",hadd);



        long rid1=db.insert("hospital",null,cv);
        if (rid1<0){
            Toast.makeText(context,"error --", LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"1 record inserted ", LENGTH_SHORT).show();
        }



    }
}

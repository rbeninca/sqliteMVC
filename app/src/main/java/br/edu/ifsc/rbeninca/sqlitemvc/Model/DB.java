package br.edu.ifsc.rbeninca.sqlitemvc.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DB {
    SQLiteDatabase database;
    Context mContext;
    public DB (Context c){
        mContext=c;
        database = c.openOrCreateDatabase("imax",Context.MODE_PRIVATE,null);
    }



}

package br.edu.ifsc.rbeninca.sqlitemvc.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class FrutaDao extends DB {
    public  final String tabela="frutas";


    public FrutaDao(Context c) {
        super(c);
        this.createTable();
    }

    private  void  createTable(){
        this.database.execSQL("CREATE TABLE IF NOT EXISTS frutas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR," +
                " TIPO VARCHAR ); ") ;
    }


    public int insere(Fruta f) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome",f.getNome());
        contentValues.put("tipo",f.getTipo());

        return (int) this.database.insert("frutas",null,contentValues );

    }

    public ArrayList<Fruta> listaFrutas(){
        ArrayList<Fruta> listFrutaResult=new ArrayList<Fruta>();
        Cursor dataSetCursor=this.database.rawQuery("SELECT * FROM frutas",null);
        dataSetCursor.moveToFirst();
        while(!dataSetCursor.isAfterLast()){
            listFrutaResult.add(new Fruta(
                                    dataSetCursor.getInt(dataSetCursor.getColumnIndex("id")),
                                    dataSetCursor.getString(dataSetCursor.getColumnIndex("nome")),
                                    dataSetCursor.getString(dataSetCursor.getColumnIndex("TIPO"))
                                        )
                                );
            dataSetCursor.moveToNext();
        }

        return listFrutaResult;
    }
}

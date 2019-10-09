package br.edu.ifsc.rbeninca.sqlitemvc.Model;

import android.content.ContentValues;
import android.content.Context;

public class FrutaDao extends DB {

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
}

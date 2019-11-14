package br.edu.ifsc.rbeninca.sqlitemvc.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.sql.Array;
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
                "tipo VARCHAR ); ") ;
    }


    public Fruta insere(Fruta f) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome",f.getNome());
        contentValues.put("tipo",f.getTipo());
        int i =(int) this.database.insert("frutas",null,contentValues );
        return  this.getFruta(i);
    }

    public int delete_fruta(Fruta  f) {
        if(f!=null) {
            return this.database.delete(
                    "frutas",
                    "id=?",
                    new String[]{Integer.toString(f.getId())});
        }
        return -1;
    }
    public Fruta  getFruta (Integer i){
        Cursor cursor=this.database.query("frutas", new String[]{"id","nome","tipo"} ,"id=?",new String[]{i.toString()},null,null,null);
        cursor.moveToFirst();
            return new Fruta(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("tipo"))
            );
    }
    public int atualiza_fruta(Fruta f){
        if(f!=null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nome", f.nome);
            contentValues.put("tipo", f.nome);
            return this.database.update("frutas", contentValues, "id=?", new String[]{f.id.toString()});
        }
        return  -1 ;
    }
    public ArrayList<Fruta> listaFrutas(){
        ArrayList<Fruta> listFrutaResult=new ArrayList<Fruta>();
        Cursor dataSetCursor=this.database.rawQuery("SELECT * FROM frutas",null);
        dataSetCursor.moveToFirst();
        while(!dataSetCursor.isAfterLast()){
            listFrutaResult.add(new Fruta(
                                    dataSetCursor.getInt(dataSetCursor.getColumnIndex("id")),
                                    dataSetCursor.getString(dataSetCursor.getColumnIndex("nome")),
                                    dataSetCursor.getString(dataSetCursor.getColumnIndex("tipo"))
                                        )
                                );
            dataSetCursor.moveToNext();
        }

        return listFrutaResult;
    }


}

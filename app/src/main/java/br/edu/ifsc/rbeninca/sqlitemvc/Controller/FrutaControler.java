package br.edu.ifsc.rbeninca.sqlitemvc.Controller;
import android.content.Context;


import java.util.ArrayList;
import java.util.Iterator;

import br.edu.ifsc.rbeninca.sqlitemvc.Model.*;
public class FrutaControler {
    Context mContext;
    FrutaDao frutaDao;
    public FrutaControler(Context c) {
        this.mContext = c;
        frutaDao = new FrutaDao(this.mContext);
    }
    public  int excluir_fruta(int i ){
        if (i>0) {
            return frutaDao.delete_fruta(frutaDao.getFruta(i));
        }
        return -1;
    }
    public  Fruta cadastrar_fruta(Fruta f){
        if (f.getNome().length()>=3)
            return frutaDao.insere(f);
        return  null;

    }

    public int  atualizarFruta(Fruta f){
        return     this.frutaDao.atualiza_fruta(f);
    }

    public Fruta getFruta(int id){
        return frutaDao.getFruta(id);

    }

    public int excluir_fruta(Fruta f){
        return   excluir_fruta(f);
    };


    public ArrayList<Fruta> listaFrutas(){
        return  frutaDao.listaFrutas();
    };


    public ArrayList<String> listaNomesFrutas(){
        ArrayList<String> listaNomesFrutasResult= new ArrayList<String>();

        for (Fruta fruta: this.listaFrutas() ){
            listaNomesFrutasResult.add(fruta.getNome());
        }

        Iterator<Fruta> it = this.listaFrutas().iterator();
        while (it.hasNext()){
            Fruta fruta = it.next();
            listaNomesFrutasResult.add(fruta.getNome());
        }
        return  listaNomesFrutasResult;
    }



}

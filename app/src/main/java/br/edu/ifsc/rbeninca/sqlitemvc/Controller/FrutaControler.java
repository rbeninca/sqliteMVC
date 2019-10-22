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
    public  boolean cadastrar_fruta(Fruta f){
        if (frutaDao.insere(f) >0)
            return true;
        else
            return  false;
    }

    public ArrayList<Fruta> listaFrutas(){
        return  frutaDao.listaFrutas();
    };

    public ArrayList<String> listaNomesFrutas(){
        ArrayList<String> listaNomesFrutasResult= new ArrayList<String>();

        Iterator<Fruta> it = this.listaFrutas().iterator();
        while (it.hasNext()){
            Fruta fruta = it.next();
            listaNomesFrutasResult.add(fruta.getNome());
        }
        return  listaNomesFrutasResult;
    }

}

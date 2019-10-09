package br.edu.ifsc.rbeninca.sqlitemvc.Controller;

import android.content.Context;

import br.edu.ifsc.rbeninca.sqlitemvc.Model.*;

public class FrutaControler {
    Context mContext;
    FrutaDao frutaDao;

    public FrutaControler(Context c) {
        this.mContext = c;
        frutaDao = new FrutaDao(this.mContext);
    }


    public  boolean cadastrar_fruta(Fruta f){
        if (frutaDao.insere( f) >0)
            return  true;
        else
            return false;

    }
}

package br.edu.ifsc.rbeninca.sqlitemvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsc.rbeninca.sqlitemvc.Controller.FrutaControler;
import br.edu.ifsc.rbeninca.sqlitemvc.Model.Fruta;

public class MainActivity extends AppCompatActivity {
    EditText id, nome , tipo;
    FrutaControler frutaControler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.id=findViewById(R.id.editText_id);
        this.nome=findViewById(R.id.editText_nome);
        this.tipo=findViewById(R.id.editText_tipo);

        this.frutaControler = new FrutaControler( getApplicationContext());

    }

    public  void salvar(View v){

        if (frutaControler.cadastrar_fruta( new Fruta(null,nome.getText().toString(), tipo.getText().toString()) ))
            Toast.makeText(this,"Fruta Salva",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Falha ao Salvar",Toast.LENGTH_LONG).show();


    }
}

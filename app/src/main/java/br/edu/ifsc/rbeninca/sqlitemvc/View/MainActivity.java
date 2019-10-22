package br.edu.ifsc.rbeninca.sqlitemvc.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import br.edu.ifsc.rbeninca.sqlitemvc.Controller.FrutaControler;
import br.edu.ifsc.rbeninca.sqlitemvc.Model.Fruta;
import br.edu.ifsc.rbeninca.sqlitemvc.R;

public class MainActivity extends AppCompatActivity {
    EditText id, nome , tipo;
    ListView listView ;
    FrutaControler frutaControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.id=findViewById(R.id.editText_id);
        this.nome=findViewById(R.id.editText_nome);
        this.tipo=findViewById(R.id.editText_tipo);
        this.listView=findViewById(R.id.list_view);

        this.frutaControler = new FrutaControler( getApplicationContext());
        loadListagem();

    }

    public  void salvar(View v){

        if (frutaControler.cadastrar_fruta( new Fruta(null,nome.getText().toString(), tipo.getText().toString()) ))
            Toast.makeText(this,"Fruta Salva",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Falha ao Salvar",Toast.LENGTH_LONG).show();
        loadListagem();
    }

    public  void loadListagem(){
         /*
            Configurando o listView
         */
        ArrayAdapter<String> adapter =  new ArrayAdapter(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                frutaControler.listaNomesFrutas()
        );

        listView.setAdapter(adapter);

    }
}

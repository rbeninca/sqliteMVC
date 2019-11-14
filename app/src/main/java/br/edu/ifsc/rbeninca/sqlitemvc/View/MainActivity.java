package br.edu.ifsc.rbeninca.sqlitemvc.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.ifsc.rbeninca.sqlitemvc.Controller.FrutaControler;
import br.edu.ifsc.rbeninca.sqlitemvc.Model.Fruta;
import br.edu.ifsc.rbeninca.sqlitemvc.R;
import br.edu.ifsc.rbeninca.sqlitemvc.Util.AdapterFrutaListagem;
import br.edu.ifsc.rbeninca.sqlitemvc.Util.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {
    EditText id, nome , tipo;
    RecyclerView  recyclerView ;
    FrutaControler frutaControler;
    Button buttonSalvar;
    ArrayList<Fruta> frutaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.frutaControler = new FrutaControler( getApplicationContext());

        this.id=findViewById(R.id.editText_id);
        this.nome=findViewById(R.id.editText_nome);
        this.tipo=findViewById(R.id.editText_tipo);
        this.recyclerView=findViewById(R.id.recyclerView);
        this.buttonSalvar=findViewById(R.id.buttonSalvar);

        this.recyclerView.addOnItemTouchListener(recyclerItemClickListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadListagem();
    }

    public RecyclerItemClickListener recyclerItemClickListener= new RecyclerItemClickListener(
                    getBaseContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Fruta f=frutaControler.getFruta(frutaArrayList.get(position).getId());
                            id.setText(f.getId().toString());
                            nome.setText(f.getNome());
                            tipo.setText(f.getTipo());
                            Toast.makeText(getApplicationContext(),Integer.toString(f.getId()),Toast.LENGTH_LONG).show();
                        }
                        @Override
                        public void onLongItemClick(View view, int position) { }
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) { }
                    });


    public ListView.OnItemClickListener clickItemListView = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long ide) {
            Fruta f=frutaControler.getFruta(position);
            id.setText(f.getId().toString());
            nome.setText(f.getNome());
            tipo.setText(f.getTipo());
            Toast.makeText(getApplicationContext(),Integer.toString(position),Toast.LENGTH_LONG).show();
        }
    };

    public  void salvar(View v){
        String resultado;
        if (!id.getText().toString().trim().isEmpty()){
            frutaControler.atualizarFruta(new Fruta(Integer.parseInt(id.getText().toString()),nome.getText().toString(), tipo.getText().toString()) );
        }else{
            frutaControler.cadastrar_fruta(new Fruta(nome.getText().toString(), tipo.getText().toString())  );
        }
        loadListagem();
    }

    public  void loadListagem(){
         /*  Configurando o listView  */

        frutaArrayList =this.frutaControler.listaFrutas();
        AdapterFrutaListagem adapterFrutaListagem = new AdapterFrutaListagem(
                getApplicationContext(),
                R.layout.layout_item_lista,
                frutaArrayList
        );
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); //new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        recyclerView.getContext(),
                        DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapterFrutaListagem);
    }
}

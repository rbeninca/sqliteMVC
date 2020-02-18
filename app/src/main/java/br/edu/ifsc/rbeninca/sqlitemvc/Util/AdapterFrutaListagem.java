package br.edu.ifsc.rbeninca.sqlitemvc.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.ifsc.rbeninca.sqlitemvc.Model.Fruta;
import br.edu.ifsc.rbeninca.sqlitemvc.R;

public class AdapterFrutaListagem extends RecyclerView.Adapter<AdapterFrutaListagem.MyViewHolder> {
    Context mContext;
    int mResource;
    ArrayList<Fruta> mArrayListFruta;

    public AdapterFrutaListagem(Context context, int resource, ArrayList<Fruta> frutaArrayList) {
        mContext=context;
        mResource=resource;
        mArrayListFruta=frutaArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.layout_item_lista,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Fruta f=mArrayListFruta.get(position);

        holder.textViewId.setText(f.getId().toString());
        holder.textViewNome.setText(f.getNome());
        holder.textViewTipo.setText(f.getTipo());

    }

    @Override
    public int getItemCount() {
        return mArrayListFruta.size();
    }

    public  class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView textViewId;
        TextView textViewNome;
        TextView textViewTipo;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewId=itemView.findViewById(R.id.textViewId);
            this.textViewNome=itemView.findViewById(R.id.textViewNome);
            this.textViewTipo=itemView.findViewById(R.id.textViewTipo);
        }
    }
}

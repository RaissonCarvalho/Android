package com.example.raiss.hemocentro.adapters;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raiss.hemocentro.R;
import com.example.raiss.hemocentro.modelos.Doador;

import java.util.List;

/**
 * Created by raiss on 29/03/2017.
 */

public class ListaDoadoresRVAdapter extends RecyclerView.Adapter<ListaDoadoresRVAdapter.ViewHolder> {


    private final Context context;
    private final List<Doador> listDoadores;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_doadores, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Doador doador = this.listDoadores.get(position);

        holder.tvDoadorNome.setText(doador.getNome());
        holder.tvDoadorTipoSanguineo.setText(doador.getTipoSanguineo());


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                MenuInflater menuInflater = popupMenu.getMenuInflater();

                menuInflater.inflate(R.menu.popup_menu_lista_doadores, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        if(menuItem.getItemId() == R.id.item_remover_doador){
                            doador.delete();
                            ListaDoadoresRVAdapter.this.notifyItemRemoved(position);
                            Toast.makeText(context,"Removido", Toast.LENGTH_SHORT).show();

                        }

                        return false;
                    }
                });

                popupMenu.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDoadores.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView tvDoadorNome;
        protected TextView tvDoadorTipoSanguineo;



        public ViewHolder(View itemView) {
            super(itemView);

            tvDoadorNome = (TextView) itemView.findViewById(R.id.tv_doador_nome);
            tvDoadorTipoSanguineo = (TextView) itemView.findViewById(R.id.tv_doador_tipoSanguineo);

        }
    }

    public ListaDoadoresRVAdapter(Context context, List<Doador> listDoadores){

        this.context = context;
        this.listDoadores = listDoadores;
    }
}

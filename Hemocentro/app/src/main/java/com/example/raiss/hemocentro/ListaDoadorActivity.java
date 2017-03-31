package com.example.raiss.hemocentro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.raiss.hemocentro.adapters.ListaDoadoresRVAdapter;
import com.example.raiss.hemocentro.modelos.Doador;

import java.util.List;

public class ListaDoadorActivity extends AppCompatActivity {
    private RecyclerView rvDoadores;
    private ListaDoadoresRVAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_doador);

        rvDoadores = (RecyclerView) findViewById(R.id.rv_doadores);


    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarDoadores();
    }

    private void carregarDoadores() {
        List<Doador> listDoadores = Doador.listAll(Doador.class);

        //Adapter
        ListaDoadoresRVAdapter adapter = new ListaDoadoresRVAdapter(this, listDoadores);
        rvDoadores.setAdapter(adapter);

        //LayoutManager
        rvDoadores.setLayoutManager(new LinearLayoutManager(this));
    }

    public void cadastrarDoador(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final View viewDialog = getLayoutInflater().inflate(R.layout.dialog_novo_doador, null);

        builder.setView(viewDialog)
                .setTitle("Novo doador")
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        EditText edDoadorNome = (EditText) viewDialog.findViewById(R.id.ed_doador_nome);
                        EditText edDoadorTipoSanguineo = (EditText) viewDialog.findViewById(R.id.ed_doador_tipoSanguineo);
                        EditText edDoadorIdade = (EditText) viewDialog.findViewById(R.id.ed_doador_idade);
                        EditText edDoadorSexo = (EditText) viewDialog.findViewById(R.id.ed_doador_sexo);

                        String nome = edDoadorNome.getText().toString();
                        String tipoSanguineo = edDoadorTipoSanguineo.getText().toString();
                        String sexo = edDoadorSexo.getText().toString();
                        int idade = Integer.valueOf(edDoadorIdade.getText().toString());

                        Doador doador = new Doador(nome, tipoSanguineo, sexo, idade);
                        doador.save();

                        carregarDoadores();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();

    }
}

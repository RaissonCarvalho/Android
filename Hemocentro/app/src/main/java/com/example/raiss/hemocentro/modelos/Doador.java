package com.example.raiss.hemocentro.modelos;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.List;

/**
 * Created by raiss on 29/03/2017.
 */

public class Doador extends SugarRecord {
    private String nome;
    private String tipoSanguineo;
    private int idade;
    private String sexo;

    @Ignore
    private List<Doador> listDoadores;



    public Doador() {

    }

    public Doador(String nome, String tipoSanguineo, String sexo, int idade) {
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {

        return this.nome;
    }

    public String getTipoSanguineo() {

        return this.tipoSanguineo;
    }

    public int getIdade() {

        return this.idade;
    }

    public String getSexo() {

        return this.sexo;
    }
}

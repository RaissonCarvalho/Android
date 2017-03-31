package com.example.raiss.hemocentro.modelos;

import com.orm.SugarRecord;

/**
 * Created by raiss on 29/03/2017.
 */

public class Doacao extends SugarRecord{
    private Doador doador;
    private int qtdDeBolsas;

    public Doacao() {

    }

    public Doacao(Doador doador, int qtdDeBolsas) {
        this.doador = doador;
        this.qtdDeBolsas = qtdDeBolsas;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

import ServiceBet.models.Odd;
import ServiceBet.views.OddView;

/**
 *
 * @author Perez_25
 */
public class OddController extends Controller {

    private Odd modelo;
    private final OddView view;

    public OddController(Odd modelo, OddView view) {
        this.modelo = modelo;
        this.view = view;
    }

    public void setModelo(Odd modelo) {
        this.modelo = modelo;
    }

    public void atualizaOdds(float odd1, float odd2, float odd3) {
        this.modelo.actualiza(odd1, odd3, odd2);
    }

    public float getOdd1() {
        return this.modelo.getOdd1();
    }

    public float getOdd2() {
        return this.modelo.getOdd2();
    }

    public float getOddx() {
        return this.modelo.getOddx();
    }

    public Odd cria(float odd1, float odd2, float oddx) {
        this.view.viewCria();
        this.modelo.actualiza(odd1, oddx, odd2);
        this.view.viewCriaSucesso();
        return this.modelo;
    }

    public void mostra() {
        this.view.viewMostra(this.modelo.toString());
    }

    public void apaga() {
        this.view.viewApaga();
    }

    public Odd atualiza(float odd1, float oddx, float odd2) {
        this.view.viewAtualiza();
        this.atualizaOdds(odd1, odd2, odd2);
        this.view.viewAtualizaSucesso();
        return this.modelo;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

import ServiceBet.models.Aposta;
import ServiceBet.models.Apostador;
import ServiceBet.models.Evento.Resultado;
import ServiceBet.models.Odd;
import ServiceBet.views.ApostaView;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Perez_25
 */
public class ApostaController extends Controller {

    private Aposta modelo;
    private ApostaView view;

    public ApostaController(Aposta modelo, ApostaView view) {
        this.modelo = modelo;
        this.view = view;
    }

    public void setId(int id) {
        this.modelo.setId(id);
    }

    public void setApostador(Apostador apostador) {
        this.modelo.setApostador(apostador);
    }

    public void setMAposta(float mAposta) {
        this.modelo.setMAposta(mAposta);
    }

    public void setOddFixada(Odd oddFixada) {
        this.modelo.setOddFixada(oddFixada);
    }

    public void setResultado(Resultado resultado) {
        this.modelo.setResultado(resultado);
    }

    public Apostador getApostador() {
        return this.modelo.getApostador();
    }

    public float getMAposta() {
        return this.modelo.getMAposta();
    }

    public Resultado getResultado() {
        return this.modelo.getResultado();
    }

    public Aposta cria(Apostador apostador) {
        this.view.viewCria();
        String readinput = this.view.getString();
        String[] tokens = readinput.split(",");
        this.modelo.defineMontanteEResultadoDeAposta(Float.parseFloat(tokens[0]), tokens[1]);
        this.setApostador(apostador);
        apostador.removeBetEssCoins(Double.valueOf(tokens[0]));
        return this.modelo;
    }

    public boolean actualiza() {
        this.view.viewAtualiza();
        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");
        this.modelo.defineMontanteEResultadoDeAposta(Float.parseFloat(tokens[0]), tokens[1]);
        this.view.viewAtualizaSucesso();
        return true;
    }

    public void mostra() {
        this.view.viewMostra(String.valueOf(this.modelo.getResultado()), String.valueOf(this.modelo.getMAposta()));
    }

    public boolean apaga(HashMap<Integer, Aposta> listaApostas) {
        this.view.viewApaga();
        if (listaApostas.containsKey(this.modelo.getId())) {
            this.view.viewApagaSucesso();
            return listaApostas.remove(this.modelo.getId(), this.modelo);
        }
        this.view.viewApagaErro();
        return false;
    }

    public int geraIdEvento(Map<Integer, Aposta> listaApostas) {
        return listaApostas.size() + 1;
    }

}

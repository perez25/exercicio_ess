/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

import ServiceBet.Observer.Observer;
import ServiceBet.models.Apostador;
import ServiceBet.views.ApostadorView;
import java.util.HashMap;

/**
 *
 * @author Perez_25
 */
public class ApostadorController extends Controller implements Observer {

    private final ApostadorView view;
    private Apostador modelo;

    public ApostadorController(ApostadorView view, Apostador modelo) {
        this.view = view;
        this.modelo = modelo;
    }

    public void setApostador(Apostador apostador) {
        this.modelo = apostador;
    }

    public void setNomeDeApostador(String nome) {
        this.modelo.setNome(nome);
    }

    public String getNomeDeApostador() {
        return this.modelo.getNome();
    }

    public void setEmailDeApostador(String email) {
        this.modelo.setEmail(email);
    }

    public String getEmailDeApostador() {
        return this.modelo.getEmail();
    }

    public void setBetEssCoins(double betEssCoins) {
        this.modelo.setBetESScoins(betEssCoins);
    }

    public double getBetEssCoinsDeApostador() {
        return this.modelo.getBetESScoins();
    }

    public void adicionaBetEssCoinsAoSaldoDeApostador(double montante) {
        this.setBetEssCoins(this.getBetEssCoinsDeApostador() + montante);
    }

    public boolean verificaSeExisteApostador(String email, HashMap<String, Apostador> listaApostadores) {
        return listaApostadores.containsKey(email);
    }

    public Apostador cria(HashMap<String, Apostador> listaApostadores) {
        this.view.viewCria();

        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");

        this.setNomeDeApostador(tokens[0]);
        this.setEmailDeApostador(tokens[1]);
        this.setBetEssCoins(Double.parseDouble(tokens[2]));

        if (!verificaSeExisteApostador(tokens[1], listaApostadores)) {
            listaApostadores.put(tokens[1], this.modelo);
            this.view.viewCriaSucesso();
            return this.modelo;
        }
        this.view.viewJaExisteApostador(tokens[1]);
        return null;
    }

    public boolean atualiza() {

        this.view.viewAtualiza();
        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");
        this.setNomeDeApostador(tokens[0]);
        this.setEmailDeApostador(tokens[1]);
        this.setBetEssCoins(Double.parseDouble(tokens[2]));
        return true;
    }

    public void lista() {
        this.view.viewMostra(this.getNomeDeApostador(), this.getEmailDeApostador(), (float) this.getBetEssCoinsDeApostador());
    }

    public boolean apaga(String email, HashMap<String, Apostador> listaApostadores) {
        for (Apostador apostador : listaApostadores.values()) {
            if (apostador.getEmail().equals(email)) {
                listaApostadores.remove(email);
                this.view.viewApagaSucesso();
                return true;
            }
        }
        this.view.viewApagaErro();
        return false;
    }

    @Override
    public void update(String notificacao) {
        this.view.viewActualizaNotificacao(notificacao, this.getNomeDeApostador());

    }

}

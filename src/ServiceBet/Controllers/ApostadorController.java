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
        this.modelo.adicionaBetEssCoins(montante);
    }

    public void removeBetEssCoinsAoSaldoDeApostadoe(double montante) {
      this.modelo.removeBetEssCoins(montante);
    }

    public boolean verificaSeExisteApostador(HashMap<String, Apostador> listaApostadores) {
        return listaApostadores.containsKey(this.modelo.getEmail());
    }

    public Apostador cria(HashMap<String, Apostador> listaApostadores) {
        this.view.viewCria();

        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");

        this.setNomeDeApostador(tokens[0]);
        this.setEmailDeApostador(tokens[1]);
        this.setBetEssCoins(Double.parseDouble(tokens[2]));

        if (!verificaSeExisteApostador(listaApostadores)) {
            listaApostadores.put(tokens[1], this.modelo);
            this.view.viewCriaSucesso();
            return this.modelo;
        }
        this.view.viewJaExisteApostador(tokens[1]);
        return null;
    }

    public boolean atualiza(HashMap<String,Apostador> listaApostadores) {
        if(listaApostadores.containsKey(this.getEmailDeApostador())){
        this.view.viewAtualiza();
        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");
        this.setNomeDeApostador(tokens[0]);
        this.setEmailDeApostador(tokens[1]);
        this.setBetEssCoins(Double.parseDouble(tokens[2]));
        return true;
        }
        return false;
    }

    public void lista() {
        this.view.viewMostra(this.getNomeDeApostador(), this.getEmailDeApostador(), (float) this.getBetEssCoinsDeApostador());
    }

    public boolean apaga(HashMap<String, Apostador> listaApostadores) {
        for (Apostador apostador : listaApostadores.values()) {
            if (apostador.getEmail().equals(this.modelo.getEmail())) {
                listaApostadores.remove(this.modelo.getEmail());
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

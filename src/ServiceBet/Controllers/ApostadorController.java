/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

import ServiceBet.models.Apostador;
import ServiceBet.models.Input;
import ServiceBet.views.ApostadorView;
import java.util.HashMap;

/**
 *
 * @author Perez_25
 */
public class ApostadorController {

    private ApostadorView view;
    private Apostador modelo;

    public ApostadorController(ApostadorView view, Apostador modelo) {
        this.view = view;
        this.modelo = modelo;
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

    public boolean verificaSeExisteApostador(String email, HashMap<String, Apostador> listaApostadores) {
        return listaApostadores.containsKey(email);
    }

    public Apostador criaApostador(HashMap<String, Apostador> listaApostadores) {
        this.view.viewCriaApostador();
        Input in = new Input();
        String readinput = this.view.getString();
        String[] tokens = readinput.split(",");

        this.setNomeDeApostador(tokens[0]);
        this.setEmailDeApostador(tokens[1]);
        this.setBetEssCoins(Double.parseDouble(tokens[2]));

        if (!verificaSeExisteApostador(tokens[1], listaApostadores)) {
            listaApostadores.put(tokens[1], this.modelo);
            this.view.viewSucessoCriaApostador();
            return this.modelo;
        }
        this.view.viewJaExisteApostador(tokens[2]);
        return null;
    }

    public boolean updateApostador() {
        this.view.viewActualizeApostador(this.modelo.getNome(), this.modelo.getEmail(), (float) this.modelo.getBetESScoins());
        String readinput = this.view.getString();
        String[] tokens = readinput.split(",");
        this.setNomeDeApostador(tokens[0]);
        this.setEmailDeApostador(tokens[1]);
        this.setBetEssCoins(Double.parseDouble(tokens[2]));
        return true;
    }

    public void listaApostador() {
        this.view.viewApostador(this.getNomeDeApostador(), this.getEmailDeApostador(), (float) this.getBetEssCoinsDeApostador());
    }

    public boolean apagaApostador(String email, HashMap<String, Apostador> listaApostadores) {
        for (Apostador apostador : listaApostadores.values()) {
            if (apostador.getEmail().equals(email)) {
                   listaApostadores.remove(email);
                   this.view.viewSucessoApagarApostador(email);
                   return true;
            }
        }

        return false;
    }

}

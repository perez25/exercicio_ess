/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

import ServiceBet.Observer.Observer;
import ServiceBet.models.Bookie;
import ServiceBet.views.BookieView;
import java.util.HashMap;

/**
 *
 * @author Perez_25
 */
public class BookieController extends Controller implements Observer {

    private Bookie modelo;
    private final BookieView view;

    public BookieController(Bookie modelo, BookieView view) {
        this.modelo = modelo;
        this.view = view;
    }

    public int getNumeroDeEventosCriadosPorBookie() {
        return this.modelo.getListaIdsEventosCriados().size();
    }

    public void setBookie(Bookie bookie) {
        this.modelo = bookie;
    }

    public void adicionaEventoABookie(int idEvento) {
        this.modelo.adicionaEventoABookie(idEvento);
    }

    public void removeEventoABookie(int idEvento) {
        this.modelo.removeEventoABookie(idEvento);
    }

    public String getUsernameDeBookie() {
        return this.modelo.getUsername();
    }

    public String getPasswordDeBookie() {
        return this.modelo.getPassword();
    }

    public void setPasswordDeBookie(String password) {
        this.modelo.setPassword(password);
    }

    public void setUsernameDeBookie(String username) {
        this.modelo.setUsername(username);
    }

    public Bookie adicionaBookie(HashMap<String, Bookie> listaBookies) {
        this.view.viewCria();
        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");
        this.setUsernameDeBookie(tokens[0]);
        this.setPasswordDeBookie(tokens[1]);
        if (listaBookies.containsKey(tokens[0])) {
            return null;
        }
        listaBookies.put(tokens[0], modelo);
        return modelo;

    }

    public boolean actualizaBookie(HashMap<String, Bookie> listaBookies) {

        if (listaBookies.containsKey(this.getUsernameDeBookie())) {
            this.view.viewAtualiza();
            String readinput = this.view.getString();
            String[] tokens = this.splitStringPorToken(readinput, ",");
            this.setUsernameDeBookie(tokens[0]);
            this.setPasswordDeBookie(tokens[1]);
        } else {
            this.view.viewAtualizaErro();
            return false;
        }
        this.view.viewAtualizaSucesso();
        return true;
    }

    public void mostraBookie() {
        this.view.viewMostraBookie(this.getUsernameDeBookie(), this.getPasswordDeBookie(), String.valueOf(this.getNumeroDeEventosCriadosPorBookie()));
    }

    public boolean apagaBookie(HashMap<String, Bookie> listaBookies) {
        this.view.viewApaga();
        if (listaBookies.containsKey(this.modelo.getUsername())) {
            listaBookies.remove(this.modelo.getUsername());
            return true;
        }
        this.view.viewApagaErro();
        return false;
    }

    @Override
    public void update(String notificacao) {
        this.view.viewMostraNotificacao(notificacao);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.models;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Perez_25
 */
public class Bookie {

    private String username;
    private String password;
    private Set<Integer> listaIdsEventosCriados;

    public Bookie(String username, String password) {
        this.username = username;
        this.password = password;
        this.listaIdsEventosCriados = new HashSet<>();

    }

    public Bookie() {
        this.username = "";
        this.password = "";
        this.listaIdsEventosCriados = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Integer> getListaIdsEventosCriados() {
        return listaIdsEventosCriados;
    }

    public void setListaIdsEventosCriados(Set<Integer> listaIdsEventosCriados) {
        this.listaIdsEventosCriados = listaIdsEventosCriados;
    }

    public void adicionaEventoABookie(int idEvento) {
        this.listaIdsEventosCriados.add(idEvento);
    }

    public void removeEventoABookie(int idEvento) {
        this.listaIdsEventosCriados.remove(idEvento);
    }

    public boolean verificaSeBookieCriouEvento(int idEvento) {
        return this.listaIdsEventosCriados.contains(idEvento);
    }

}

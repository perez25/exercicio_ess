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

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the listaIdsEventosCriados
     */
    public Set<Integer> getListaIdsEventosCriados() {
        return listaIdsEventosCriados;
    }

    /**
     * @param listaIdsEventosCriados the listaIdsEventosCriados to set
     */
    public void setListaIdsEventosCriados(Set<Integer> listaIdsEventosCriados) {
        this.listaIdsEventosCriados = listaIdsEventosCriados;
    }

    /**
     *  adiciona um evento a um bookie 
     * @param idEvento
     */
    public void adicionaEventoABookie(int idEvento) {
        this.listaIdsEventosCriados.add(idEvento);
    }

    /**
     * remove um evento a um bookie
     * @param idEvento
     */
    public void removeEventoABookie(int idEvento) {
        this.listaIdsEventosCriados.remove(idEvento);
    }
    /**
     * Verifica se o bookie segue um evento
     * @param idEvento
     * @return boolean
     */
    public boolean verificaSeBookieSegueEvento(int idEvento) {
        return this.listaIdsEventosCriados.contains(idEvento);
    }

}

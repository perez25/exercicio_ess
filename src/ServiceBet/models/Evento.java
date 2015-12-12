package ServiceBet.models;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Evento {

    public enum Resultado {

        VITORIA, DERROTA, EMPATE
    }

    private static AtomicInteger idUnico = new AtomicInteger();
    private int id;
    private String equipa1;
    private String equipa2;
    private Resultado resultadoFinal;
    private Date dataEvento;

    private HashMap<Integer, Aposta> listaApostas;
    private boolean estadoEvento;
    private Odd odds;

    public Evento(String equipa1, String equipa2, Date data) {
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.estadoEvento = false;
        this.resultadoFinal = null;
        this.dataEvento = data;
        this.id = idUnico.getAndIncrement();
        this.odds = new Odd();
        this.listaApostas = new HashMap<>();
    }

    public Evento() {
        this.equipa1 = null;
        this.equipa2 = null;
        this.estadoEvento = false;
        this.resultadoFinal = null;
        this.dataEvento = null;
        this.id = idUnico.getAndIncrement();
        this.odds = new Odd();
        this.listaApostas = new HashMap<>();
    }

    public static AtomicInteger getIdUnico() {
        return idUnico;
    }

    public static void setIdUnico(AtomicInteger idUnico) {
        Evento.idUnico = idUnico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipa1() {
        return equipa1;
    }

    public void setEquipa1(String equipa1) {
        this.equipa1 = equipa1;
    }

    public String getEquipa2() {
        return equipa2;
    }

    public void setEquipa2(String equipa2) {
        this.equipa2 = equipa2;
    }

    public Resultado getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(Resultado resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public HashMap<Integer, Aposta> getListaApostas() {
        return listaApostas;
    }

    public void setListaApostas(HashMap<Integer, Aposta> listaApostas) {
        this.listaApostas = listaApostas;
    }

    public boolean isEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(boolean estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public Odd getOdds() {
        return odds;
    }

    public void setOdds(Odd odds) {
        this.odds = odds;
    }

   
    public boolean actualizaOdd(int odd1, int oddx, int odd2) {
        this.odds.setOddx(oddx);
        this.odds.setOdd1(odd1);
        this.odds.setOdd2(odd2);
        return true;
    }

  
}

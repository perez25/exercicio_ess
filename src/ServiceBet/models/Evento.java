package ServiceBet.models;

import java.util.*;

public class Evento {

    public enum Resultado {

        VITORIA, DERROTA, EMPATE
    }

    private int id;
    private String equipa1;
    private String equipa2;
    private Resultado resultadoFinal;
    private Date dataEvento;
    private Bookie bookie;
    private Map<Integer, Aposta> listaApostas;
    private boolean estaAberto;
    private Odd odds;
    private Set<Bookie> listaBookiesASeguir;

    public Evento(String equipa1, String equipa2, Date data, Bookie bookie) {
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.estaAberto = true;
        this.resultadoFinal = null;
        this.dataEvento = data;
        this.id = 0;
        this.odds = new Odd();
        this.listaApostas = new HashMap<>();
        this.bookie = bookie;
        this.listaBookiesASeguir = new HashSet<>();
    }

    public Evento(Bookie bookie) {
        this.equipa1 = "";
        this.equipa2 = "";
        this.estaAberto = true;
        this.resultadoFinal = null;
        this.dataEvento = null;
        this.id = 0;
        this.odds = new Odd();
        this.listaApostas = new HashMap<>();
        this.bookie = bookie;
        this.listaBookiesASeguir = new HashSet<>();
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
        return this.resultadoFinal;

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

    public Map<Integer, Aposta> getListaApostas() {
        return listaApostas;
    }

    public void setListaApostas(HashMap<Integer, Aposta> listaApostas) {
        this.listaApostas = listaApostas;
    }

    public Odd getOdds() {
        return odds;
    }

    public void setOdds(Odd odds) {
        this.odds = odds;
    }

    /**
     * @return the estaAberto
     */
    public boolean isEstaAberto() {
        return estaAberto;
    }

    /**
     * @param estaAberto the estaAberto to set
     */
    public void setEstaAberto(boolean estaAberto) {
        this.estaAberto = estaAberto;
    }

    /**
     * @return the bookie
     */
    public Bookie getBookie() {
        return bookie;
    }

    /**
     * @param bookie the bookie to set
     */
    public void setBookie(Bookie bookie) {
        this.bookie = bookie;
    }

    public Set<Bookie> getListaBookiesASeguir() {
        return listaBookiesASeguir;
    }

    public void setListaBookiesASeguir(Set<Bookie> listaBookiesASeguir) {
        this.listaBookiesASeguir = listaBookiesASeguir;
    }

    public void adicionaAposta(Aposta aposta) {
        this.listaApostas.put(aposta.getId(), aposta);
    }

    public void removeAposta(Aposta aposta) {
        this.listaApostas.remove(aposta.getId());

    }

    public boolean actualizaOdd(int odd1, int oddx, int odd2) {
        this.odds.setOddx(oddx);
        this.odds.setOdd1(odd1);
        this.odds.setOdd2(odd2);
        return true;
    }

    public void defineResultadoFinal(char resultadoFinal) {
        switch (resultadoFinal) {
            case '1':
                this.resultadoFinal = Evento.Resultado.VITORIA;
                break;
            case 'x':
                this.resultadoFinal = Evento.Resultado.EMPATE;
                break;
            case '2':
                this.resultadoFinal = Evento.Resultado.DERROTA;
                break;
        }
        this.setEstaAberto(false);

    }

    public boolean adicionaBookieASeguir(Bookie bookie) {
        if (this.listaBookiesASeguir.contains(bookie)) {
            return false;
        }
        this.listaBookiesASeguir.add(bookie);
        return true;

    }

    public boolean removeBookieASeguir(Bookie bookie) {
        return this.listaBookiesASeguir.remove(bookie);
    }

    public boolean bookieEstaASeguirEvento(Bookie bookie) {
        return this.listaBookiesASeguir.contains(bookie);

    }

}

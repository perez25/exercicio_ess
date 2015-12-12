package ServiceBet.models;

import ServiceBet.Observer.Observer;

public class Apostador implements Observer {

    private String email;
    private double betESScoins;
    private String nome;

    public Apostador(String name, String email, double betESScoins) {
        this.email = email;
        this.nome = name;
        this.betESScoins = betESScoins;

    }

    public Apostador() {
        this.email = "";
        this.nome = "";
        this.betESScoins = 0.0;
    }

    public String getEmail() {
        return email;
    }

    public double getBetESScoins() {
        return betESScoins;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBetESScoins(double betESScoins) {
        this.betESScoins = betESScoins;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String notificacao) {

    }
}

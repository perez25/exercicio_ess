package ServiceBet.models;

public class Apostador {

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

    public void adicionaBetEssCoins(double montante) {
        this.betESScoins += montante;
    }

    public void removeBetEssCoins(double montante) {
        this.betESScoins -= montante;
    }

    public boolean temSaldoParaApostar(double montante) {
        return montante <= this.betESScoins;

    }

}

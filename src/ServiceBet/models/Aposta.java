package ServiceBet.models;

public class Aposta {

    private int id;
    private Apostador apostador;
    private float montanteAposta;
    private Evento.Resultado resultado;
    private Odd oddFixada;

    public Aposta() {
        this.id = -1;
        this.apostador = null;
        this.montanteAposta = 0;
        this.resultado = null;
        this.oddFixada = null;

    }

    public Aposta(int id, Apostador apostador, float m_aposta, String resultado, Odd odd_actual) {
        this.id = id;
        this.apostador = apostador;
        defineMontanteEResultadoDeAposta(m_aposta, resultado);
        this.oddFixada = odd_actual.clone();

    }

    public Aposta(Aposta aposta) {
        this.id = aposta.getId();
        this.apostador = aposta.getApostador();
        this.montanteAposta = aposta.getMAposta();
        this.resultado = aposta.getResultado();
        this.oddFixada = aposta.getOddFixada();

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Apostador getApostador() {
        return apostador;
    }

    public Evento.Resultado getResultado() {
        return resultado;
    }

    public float getMAposta() {
        return montanteAposta;
    }

    public Odd getOddFixada() {
        return oddFixada;
    }

    public void setOddFixada(Odd oddFixada) {
        this.oddFixada = oddFixada.clone();
    }

    public void setMAposta(float mAposta) {
        this.montanteAposta = mAposta;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    public void setResultado(Evento.Resultado resultado) {
        this.resultado = resultado;
    }

    public void defineMontanteEResultadoDeAposta(float montante, String resultado) {

        switch (resultado) {
            case "1":
                this.setResultado(Evento.Resultado.VITORIA);
                break;
            case "x":
                this.setResultado(Evento.Resultado.EMPATE);
                break;
            case "2":
                this.setResultado(Evento.Resultado.DERROTA);
                break;
        }

        this.setMAposta(montante);

    }

    public int calculaPremioDeOdd1() {

        return (int) (this.getMAposta() * this.getOddFixada().getOdd1());
    }

    public int calculaPremioDeOdd2() {

        return (int) (this.getMAposta() * this.getOddFixada().getOdd2());
    }

    public int calculaPremioDeOddx() {

        return (int) (this.getMAposta() * this.getOddFixada().getOddx());
    }

    public int devolvePremio() {
        int premio = 0;
        switch (this.getResultado()) {
            case VITORIA:
                premio = this.calculaPremioDeOdd1();
                break;
            case EMPATE:
                premio = this.calculaPremioDeOddx();
                ;
                break;
            case DERROTA:
                premio = this.calculaPremioDeOdd2();
                ;
                break;
        }
        return premio;
    }

    @Override
    public Aposta clone() {
        return new Aposta(this);
    }

}

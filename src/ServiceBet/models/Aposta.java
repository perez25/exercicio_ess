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

    public Aposta(int id, Apostador apostador, float m_aposta, char resultado, Odd odd_actual) {
        this.id = id;
        this.apostador = apostador;
        this.montanteAposta = m_aposta;
        this.defineResultado(resultado);
        this.oddFixada = odd_actual.clone();

    }

    public void defineResultado(char resultado) {

        switch (resultado) {
            case '1':
                this.resultado = Evento.Resultado.VITORIA;
                break;
            case 'x':
                this.resultado = Evento.Resultado.EMPATE;
                break;
            case '2':
                this.resultado = Evento.Resultado.DERROTA;
                break;
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /*getter and setters*/

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

    public void aposta(float montante, String resultado) {

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

}

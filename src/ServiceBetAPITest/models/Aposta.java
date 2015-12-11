package ServiceBetAPITest.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Aposta {

    private Apostador apostador;
    private float m_aposta;
    private Evento.Resultado resultado;
    private Odd odd_fixada;
    private BufferedReader in;
    private PrintStream out;

    public Aposta() {
        this.apostador = null;
        this.m_aposta = 0;
        this.resultado = null;
        this.odd_fixada = null;
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
    }

    public Aposta(Apostador apostador, float m_aposta, char resultado, Odd odd_actual) {
        this.apostador = apostador;
        this.m_aposta = m_aposta;
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
        this.odd_fixada = odd_actual.clone();
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
    }

	// getter and setters
    public Apostador getApostador() {
        return apostador;
    }

    public Evento.Resultado getResultado() {
        return resultado;
    }

    public float getM_aposta() {
        return m_aposta;
    }

    public Odd getOdd_fixada() {
        return odd_fixada;
    }

    public void setOdd_fixada(Odd odd_fixada) {
        this.odd_fixada = odd_fixada.clone();
    }

    public void setM_aposta(float m_aposta) {
        this.m_aposta = m_aposta;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    public void setResultado(Evento.Resultado resultado) {
        this.resultado = resultado;
    }

//	Views para Apostador
    public void viewCreateAposta() {
        String readinput;
        this.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");

            switch (tokens[1]) {
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

            this.setM_aposta(Float.parseFloat(tokens[0]));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

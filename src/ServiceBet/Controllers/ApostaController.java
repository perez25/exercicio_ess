/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

import ServiceBet.models.Aposta;
import ServiceBet.models.Apostador;
import ServiceBet.models.Evento.Resultado;
import ServiceBet.models.Odd;
import ServiceBet.views.ApostaView;

/**
 *
 * @author Perez_25
 */
public class ApostaController {

    private Aposta modelo;
    private ApostaView view;

    public ApostaController(Aposta modelo, ApostaView view) {
        this.modelo = modelo;
        this.view = view;
    }

    public void setApostador(Apostador apostador) {
        this.modelo.setApostador(apostador);
    }

    public void setMAposta(float mAposta) {
        this.modelo.setMAposta(mAposta);
    }

    public void setOddFixada(Odd oddFixada) {
        this.modelo.setOddFixada(oddFixada);
    }

    public void setResultado(Resultado resultado) {
        this.modelo.setResultado(resultado);
    }

    public Apostador getApostador() {
        return this.modelo.getApostador();
    }

    public float getMAposta() {
        return this.modelo.getMAposta();
    }

    public Resultado getResultado() {
        return this.modelo.getResultado();
    }

    public void defineResultado(char resultado) {
        this.modelo.defineResultado(resultado);
    }

    public void aposta(Apostador apostador,char resultado) {
        this.view.viewCriaAposta();
        String readinput = this.view.getString();
        String[] tokens = readinput.split(",");
        this.modelo.aposta(Float.parseFloat(tokens[0]), tokens[1]);
        this.setApostador(apostador);
        this.defineResultado(resultado);
        
       
    }

    public void updateAposta() {

    }

}

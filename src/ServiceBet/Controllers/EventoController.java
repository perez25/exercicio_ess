/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

import ServiceBet.models.Aposta;
import ServiceBet.models.Apostador;
import ServiceBet.models.Evento;
import ServiceBet.models.Odd;
import ServiceBet.views.EventoView;
import java.time.Instant;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;

/**
 *
 * @author Perez_25
 */
public class EventoController {

    private EventoView view;
    private Evento evento;

    public EventoController(EventoView view, Evento evento) {
        this.view = view;
        this.evento = evento;
    }

    public String getEquipa1() {
        return this.evento.getEquipa1();
    }

    public String getEquipa2() {
        return this.evento.getEquipa2();
    }

    public void setEquipa1(String equipa1) {
        this.evento.setEquipa1(equipa1);
    }

    public void setEquipa2(String equipa2) {
        this.evento.setEquipa2(equipa2);
    }

    public void setOdd(int odd1, int odd2, int oddX) {
        this.evento.actualizaOdd(odd1, oddX, odd2);
    }

    public Odd getOddDeEvento() {
        return this.evento.getOdds();
    }

    public void adicionaApostaAEvento(Aposta aposta) {
        this.evento.getListaApostas().put(aposta.getId(), aposta);
    }

    public void setResultadoFinalDeEvento(char resultado) {
      //  this.evento.fechaEvento(resultado);
    }

    public String getResultadoFinalDeEvento() {
        return this.evento.getResultadoFinal().toString();
    }

    public void setDataDoEvento(Date data) {
        this.evento.setDataEvento(data);
    }

    public void removeApostaDeEvento() {
    }

    public void criaEvento() {

    }

    public boolean registaApostaDeEvento(HashMap<Integer, Evento> listaEventos, Apostador apostador) {
        this.view.viewCriaEvento();
        String readinput = this.view.getString();
        String[] tokens = readinput.split(",");
        this.setEquipa2(tokens[1]);
        this.setEquipa1(tokens[0]);
        this.setDataDoEvento(Date.from(Instant.now()));
        listaEventos.put(this.evento.getId(), this.evento);
        return true;
    }

    public void listaEvento() {
        this.view.mostraEvento(this.getEquipa1(), this.getEquipa2(), this.getResultadoFinalDeEvento(), null, null, null);
    }

    public boolean actualizaEvento() {
        String readinput = this.view.getString();
        String[] tokens = readinput.split(",");
        this.setEquipa2(tokens[1]);
        this.setEquipa1(tokens[0]);
        this.setDataDoEvento(Date.from(Instant.now()));
        return true;
    }
    
      public void notifyApostadores() {
        int premio = 0;
        if (!this.isOpen) {
            Enumeration<Aposta> lista_apostas = this.listaApostas.elements();
            while (lista_apostas.hasMoreElements()) {
                Aposta aposta = lista_apostas.nextElement();

                if (this.resultado_final == aposta.getResultado()) {

                    switch (aposta.getResultado()) {
                        case VITORIA:
                            premio = (int) (aposta.getMAposta() * aposta.getOddFixada().getOdd1());
                            break;
                        case EMPATE:
                            premio = (int) (aposta.getMAposta() * aposta.getOddFixada().getOddx());
                            ;
                            break;
                        case DERROTA:
                            premio = (int) (aposta.getMAposta() * aposta.getOddFixada().getOdd2());
                            ;
                            break;
                    }
                }
                aposta.getApostador().update(premio + "");
            }
        }
    }
    
      public boolean fechaEvento(char resultadofinal) {

        switch (resultadofinal) {
            case '1':
                this.resultado_final = Evento.Resultado.VITORIA;
                break;
            case 'x':
                this.resultado_final = Evento.Resultado.EMPATE;
                break;
            case '2':
                this.resultado_final = Evento.Resultado.DERROTA;
                break;
        }
        this.isOpen = false;
        this.notifyApostadores();
        return true;
    }
      
        public void viewDeleteApostador() {
        this.out.println("Remover Apostador" + this.viewEvento());

    }
        
        

}

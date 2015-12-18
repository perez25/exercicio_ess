/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

import ServiceBet.Observer.Subject;
import ServiceBet.models.Aposta;
import ServiceBet.models.Bookie;
import ServiceBet.models.Evento;
import ServiceBet.models.Odd;
import ServiceBet.views.ApostadorView;
import ServiceBet.views.BookieView;
import ServiceBet.views.EventoView;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Perez_25
 */
public class EventoController extends Controller implements Subject {

    private EventoView view;
    private Evento evento;

    public EventoController(EventoView view, Evento evento) {
        this.view = view;
        this.evento = evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setView(EventoView view) {
        this.view = view;
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
        this.fechaEvento(resultado);
    }

    public Evento.Resultado getResultadoFinalDeEvento() {
        return this.evento.getResultadoFinal();
    }

    public void setDataDoEvento(Date data) {
        this.evento.setDataEvento(data);
    }

    public Date getDataDeEvento() {
        return this.evento.getDataEvento();
    }

    public Bookie getBookieDeEvento() {
        return this.evento.getBookie();
    }

    public boolean eventoEstaAberto() {
        return this.evento.isEstaAberto();
    }

    public void removeApostaDeEvento(Evento evento, Aposta aposta) {
        evento.getListaApostas().remove(aposta);
    }

    public Evento criaEvento(HashSet<Evento> listaEventos) {
        int id = 0;
        if (listaEventos.size() > 0) {
            id = listaEventos.size() + 1;
        }
        this.view.viewCria();
        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");
        this.setEquipa2(tokens[1]);
        this.setEquipa1(tokens[0]);
        this.setDataDoEvento(Date.from(Instant.now()));
        this.adicionaObserver(this.evento.getBookie());
        this.evento.setId(id);
        listaEventos.add(this.evento);
        return this.evento;
    }

    public boolean registaApostaDeEvento(Aposta aposta) {
        if (this.evento.getListaApostas().containsKey(aposta.getId()) && this.eventoEstaAberto()) {

            return false;
        }
        ApostaController apostaController = new ApostaController(aposta, null);
        apostaController.setOddFixada(evento.getOdds());
        evento.getListaApostas().put(aposta.getId(), aposta);
        return true;
    }

    public void listaEvento() {
        String estado = null;
        if (this.evento.isEstaAberto() == false) {
            estado = "Fechado";
        } else {
            estado = "Aberto";
        }
        this.view.mostraEvento(this.getEquipa1(), this.getEquipa2(), String.valueOf(this.getResultadoFinalDeEvento()), estado, this.getDataDeEvento().toString(), this.getOddDeEvento().toString());
    }

    public boolean actualizaEvento() {
        this.view.viewAtualiza();
        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");
        this.setEquipa2(tokens[1]);
        this.setEquipa1(tokens[0]);
        this.setDataDoEvento(Date.from(Instant.now()));
        this.view.viewAtualizaSucesso();
        return true;
    }

    @Override
    public void notificaApostadores() {
        int premio = 0;

        if (!this.evento.isEstaAberto()) {

            for (Aposta aposta : this.evento.getListaApostas().values()) {

                if (this.evento.getResultadoFinal() == aposta.getResultado()) {

                    switch (aposta.getResultado()) {
                        case VITORIA:
                            premio = aposta.calculaPremioDeOdd1();
                            break;
                        case EMPATE:
                            premio = aposta.calculaPremioDeOdd2();
                            ;
                            break;
                        case DERROTA:
                            premio = aposta.calculaPremioDeOddx();
                            ;
                            break;
                    }
                }
                ApostadorView apostadorView = new ApostadorView();
                ApostadorController apostadorController = new ApostadorController(apostadorView, aposta.getApostador());
                apostadorController.update("Ganhou o seguinte montante " + premio + " ");

            }
        }
    }

    public double calculaSaldoDeEvento() {
        double saldo = 0;
        for (Aposta aposta : this.evento.getListaApostas().values()) {

            if (this.evento.getResultadoFinal() == aposta.getResultado()) {

                switch (aposta.getResultado()) {
                    case VITORIA:
                        saldo -= aposta.calculaPremioDeOdd1();
                        break;
                    case EMPATE:
                        saldo -= aposta.calculaPremioDeOddx();
                        ;
                        break;
                    case DERROTA:
                        saldo -= aposta.calculaPremioDeOdd2();
                        ;
                        break;
                }
            } else {
                saldo += aposta.getMAposta();
            }
        }
        return saldo;
    }

    public boolean fechaEvento(char resultadoFinal) {

        if (resultadoFinal != 'x' && resultadoFinal != '1' && resultadoFinal != '2') {
            this.view.viewFecharEventoErro();
            return false;
        }

        if (!this.eventoEstaAberto()) {
            this.view.viewActualizaOddEventoErro();
            return false;
        }

        this.evento.defineResultadoFinal(resultadoFinal);
        this.notificaApostadores();
        this.notificaBookies();
        this.view.viewFecharEventoSucesso();
        return true;
    }

    public boolean apaga(HashSet<Evento> listaEventos) {
        for (Evento ev : listaEventos) {
            if (ev.getId() == evento.getId()) {
                listaEventos.remove(ev);
                return true;
            }
        }
        return false;
    }

    public boolean actualizaOddsDeEvento(Evento evento, int odd1, int odd2, int oddx) {

        if (evento.isEstaAberto() == true) {
            this.view.viewActualizaOddEventoSucesso();
            return evento.actualizaOdd(odd1, oddx, odd2);
        } else {
            this.view.viewActualizaOddEventoErro();
            return false;
        }
    }

    @Override
    public void adicionaObserver(Bookie bookie) {
        this.evento.adicionaBookieASeguir(bookie);
    }

    @Override
    public void notificaBookies() {
        BookieView bookieView = new BookieView();

        BookieController bookieController = new BookieController(this.getBookieDeEvento(), bookieView);
        bookieController.update("O evento que criou com o id = " + this.evento.getId() + " terminou com o resultado = " + String.valueOf(this.getResultadoFinalDeEvento()));
        for (Bookie bookie : this.evento.getListaBookiesASeguir()) {
            bookieController.setBookie(bookie);
            bookieController.update("O evento que estava a seguir com o id = " + this.evento.getId() + " terminou com o resultado = " + String.valueOf(this.getResultadoFinalDeEvento()));
        }

    }

    public HashMap<Integer, Aposta> devolveApostasDeEvento() {
        HashMap<Integer, Aposta> res = new HashMap<>();
        for (Aposta aposta : this.evento.getListaApostas().values()) {
            res.put(aposta.getId(), aposta.clone());
        }
        return res;
    }

    public boolean bookieEstaASeguir(Bookie bookie) {
        return this.evento.bookieEstaASeguirEvento(bookie);
    }

    @Override
    public void removeObserver(Bookie bookie) {
        this.evento.removeBookieASeguir(bookie);
    }

}

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
import ServiceBet.views.ApostaView;
import ServiceBet.views.ApostadorView;
import ServiceBet.views.BookieView;
import ServiceBet.views.EventoView;
import ServiceBet.views.OddView;
import java.time.Instant;
import java.util.Date;
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

    public void removeApostaDeEvento(Aposta aposta) {
        evento.getListaApostas().remove(aposta);
    }

    public int geraIdEvento(HashSet<Evento> listaEventos) {
        return listaEventos.size() + 1;
    }

    public Evento criaEvento(HashSet<Evento> listaEventos) {

        this.view.viewCria();
        String readinput = this.view.getString();
        String[] tokens = this.splitStringPorToken(readinput, ",");
        this.setEquipa2(tokens[1]);
        this.setEquipa1(tokens[0]);
        this.setDataDoEvento(Date.from(Instant.now()));
        this.adicionaObserver(this.evento.getBookie());
        this.evento.setId(geraIdEvento(listaEventos));
        listaEventos.add(this.evento);
        return this.evento;
    }

    public boolean registaApostaDeEvento(Aposta aposta) {
        ApostaView apostaView = new ApostaView();
        if (this.evento.getListaApostas().containsKey(aposta.getId()) || !this.eventoEstaAberto()) {
            apostaView.viewCriaErro();
            return false;
        }
        ApostaController apostaController = new ApostaController(aposta, apostaView);
        apostaController.setOddFixada(evento.getOdds());
        apostaController.setId(apostaController.geraIdEvento(this.evento.getListaApostas()));
        evento.getListaApostas().put(aposta.getId(), aposta);
        apostaView.viewCriaSucesso();
        return true;
    }

    public boolean verificaSeEventoExisteNoSistema(HashSet<Evento> listaEventos) {
        return listaEventos.contains(this.evento);
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
        int premio;

        if (!this.evento.isEstaAberto()) {
            for (Aposta aposta : this.evento.getListaApostas().values()) {
                if (this.evento.getResultadoFinal() == aposta.getResultado()) {
                    premio = aposta.devolvePremio();
                } else {
                    premio = 0;
                }
                ApostadorView apostadorView = new ApostadorView();
                ApostadorController apostadorController = new ApostadorController(apostadorView, aposta.getApostador());
                apostadorController.update("Ganhou o seguinte montante " + premio + " ");
                apostadorController.adicionaBetEssCoinsAoSaldoDeApostador(premio);

            }
        }
    }

    public double calculaSaldoDeEvento() {
        return this.evento.calculaSaldoDeEvento();
    }

    public boolean fechaEvento(char resultadoFinal) {

        if (resultadoFinal != 'x' && resultadoFinal != '1' && resultadoFinal != '2') {
            this.view.viewFecharEventoErro();
            return false;
        }

        if (!this.eventoEstaAberto()) {
            this.view.viewFecharEventoErro();
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

    public boolean actualizaOddsDeEvento(int odd1, int odd2, int oddx) {
        OddView oddView = new OddView();
        if (evento.isEstaAberto()) {

            OddController oddController = new OddController(this.getOddDeEvento(), oddView);
            oddController.atualiza(odd1, oddx, odd2);
            return true;
        } else {
            oddView.viewAtualizaErro();
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

    public boolean bookieEstaASeguir(Bookie bookie) {
        return this.evento.bookieEstaASeguirEvento(bookie);
    }

    @Override
    public void removeObserver(Bookie bookie) {
        this.evento.removeBookieASeguir(bookie);
    }

}

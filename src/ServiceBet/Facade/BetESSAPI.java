package ServiceBet.Facade;

import ServiceBet.Controllers.ApostaController;
import ServiceBet.Controllers.ApostadorController;
import ServiceBet.Controllers.BookieController;
import ServiceBet.Controllers.EventoController;
import ServiceBet.Controllers.OddController;
import ServiceBet.models.Aposta;
import ServiceBet.models.Apostador;
import ServiceBet.models.Bookie;
import ServiceBet.models.Evento;
import ServiceBet.models.Odd;
import ServiceBet.views.ApostaView;
import ServiceBet.views.ApostadorView;
import ServiceBet.views.BetEssAPIView;
import ServiceBet.views.BookieView;
import ServiceBet.views.EventoView;
import ServiceBet.views.OddView;
import java.util.*;

public class BetESSAPI {

    private HashSet<Evento> listaEventos;
    private HashMap<String, Apostador> listaApostadores;
    private HashMap<String, Bookie> listaBookies;
    private double betESStotal;
    private String nome;

    public BetESSAPI() {
        this.betESStotal = 0;
        this.listaEventos = new HashSet<>();
        this.listaApostadores = new HashMap<>();
        this.listaBookies = new HashMap<>();
        this.nome = "BetESSAPI";
    }

    public void actualizaBetEssTotal(double montante) {
        this.betESStotal = this.betESStotal + montante;
    }

    public void actualizaNomeDeBetEssAPI(String nome) {
        this.nome = nome;
    }

    public double devolveSaldoTotal() {
        return betESStotal;
    }

    public void mostraBetEssService() {
        BetEssAPIView betView = new BetEssAPIView();
        betView.viewMostra(this.nome, String.valueOf(this.betESStotal), String.valueOf(getNumeroDeApostadores()), String.valueOf(getNumeroDeEventos()), String.valueOf(getNumBookiesSistema()));
    }

    public Aposta registaAposta(Apostador apostador, Evento evento) {
        EventoView viewEvento = new EventoView();
        EventoController eventoController = new EventoController(viewEvento, evento);

        if (eventoController.verificaSeEventoExisteNoSistema(this.listaEventos)) {

            ApostaView viewAposta = new ApostaView();
            ApostaController apostaController = new ApostaController(new Aposta(), viewAposta);
            Aposta aposta = apostaController.cria(apostador);

            if (eventoController.registaApostaDeEvento(aposta)) {
                return aposta;
            }
        }
        return null;
    }

    public boolean actualizaAposta(Aposta aposta) {
        ApostaView viewAposta = new ApostaView();
        ApostaController apostaController = new ApostaController(aposta, viewAposta);
        return apostaController.actualiza();
    }

    public void mostraAposta(Aposta aposta) {
        ApostaView viewAposta = new ApostaView();
        ApostaController apostaController = new ApostaController(aposta, viewAposta);
        apostaController.mostra();
    }
    
    public void removeAposta(Evento evento,Aposta aposta){
        EventoController eventoController = new EventoController(null, evento);
        eventoController.removeApostaDeEvento(aposta);
    }

    public Evento registaEvento(Bookie bookie) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, new Evento(bookie));
        return eventoController.criaEvento(listaEventos);
    }

    public boolean fechaEvento(Evento evento, char resultado) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        boolean res = eventoController.fechaEvento(resultado);
        this.actualizaBetEssTotal(eventoController.calculaSaldoDeEvento());
        return res;
    }

    public void listarEventos() {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, null);
        for (Evento evento : this.listaEventos) {
            eventoController.setEvento(evento);
            eventoController.listaEvento();
        }
    }

    public boolean atualizaEvento(Evento evento) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        return eventoController.actualizaEvento();
    }

    public boolean apagaEvento(Evento evento) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        return eventoController.apaga(listaEventos);
    }

    public int getNumeroDeEventos() {
        return this.listaEventos.size();
    }

    public int getNumeroDeApostadores() {
        return this.listaApostadores.size();
    }

    public void listarApostadores() {
        ApostadorView viewApostador = new ApostadorView();
        for (Apostador apostador : this.listaApostadores.values()) {
            ApostadorController apostadorController = new ApostadorController(viewApostador, apostador);
            apostadorController.lista();
        }
    }

    public Apostador registaApostador() {
        ApostadorView viewApostador = new ApostadorView();
        ApostadorController apostadorController = new ApostadorController(viewApostador, new Apostador());
        return apostadorController.cria(listaApostadores);
    }

    public boolean actualizaApostador(Apostador apostador) {
        ApostadorView viewApostador = new ApostadorView();
        ApostadorController apostadorController = new ApostadorController(viewApostador, apostador);
        return apostadorController.atualiza(this.listaApostadores);
    }

    public boolean apagaApostador(Apostador apostadorl) {
        ApostadorView viewApostador = new ApostadorView();
        ApostadorController apostadorController = new ApostadorController(viewApostador, apostadorl);
        return apostadorController.apaga(listaApostadores);
    }

    public Bookie criaBookie() {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(new Bookie(), view);
        return bookieController.adicionaBookie(listaBookies);
    }

    public void mostraBookie(Bookie bookie) {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(new Bookie(), view);
        bookieController.mostraBookie();
    }

    public void listaBookies() {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(null, view);
        for (Bookie bookie : this.listaBookies.values()) {
            bookieController.setBookie(bookie);
            bookieController.mostraBookie();
        }
    }

    public boolean apagaBookie(Bookie bookie) {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(bookie, view);
        return bookieController.apagaBookie(listaBookies);
    }

    public boolean actualizaBookie(Bookie bookie) {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(bookie, view);
        return bookieController.actualizaBookie(listaBookies);
    }

    public int getNumBookiesSistema() {
        return this.listaBookies.size();
    }

    public void addBookieASeguirEv(Evento evento, Bookie bookie) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        eventoController.adicionaObserver(bookie);
    }

    public void rmBookieASeguirEv(Evento evento, Bookie bookie) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        eventoController.removeObserver(bookie);
    }

    public boolean bookieASeguirEv(Evento evento, Bookie bookie) {
        EventoController eventoController = new EventoController(null, evento);
        return eventoController.bookieEstaASeguir(bookie);
    }

    public Odd criaOdd(float odd1, float odd2, float oddx) {
        OddView oddView = new OddView();
        OddController oddController = new OddController(new Odd(), oddView);
        return oddController.cria(odd1, odd2, oddx);
    }

    public boolean actualizaOddEvento(Evento evento, int odd_1, int odd_x, int odd_2) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        return eventoController.actualizaOddsDeEvento(odd_1, odd_2, odd_x);
    }

    public void listaOdd(Odd odd1) {
        OddView oddView = new OddView();
        OddController oddController = new OddController(odd1, oddView);
        oddController.mostra();
    }
}

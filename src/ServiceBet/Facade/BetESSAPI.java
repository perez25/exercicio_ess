package ServiceBet.Facade;

import ServiceBet.Controllers.ApostaController;
import ServiceBet.Controllers.ApostadorController;
import ServiceBet.Controllers.BookieController;
import ServiceBet.Controllers.EventoController;
import ServiceBet.models.Aposta;
import ServiceBet.models.Apostador;
import ServiceBet.models.Bookie;
import ServiceBet.models.Evento;
import ServiceBet.views.ApostaView;
import ServiceBet.views.ApostadorView;
import ServiceBet.views.BookieView;
import ServiceBet.views.EventoView;
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

    /**
     * Actualiza o saldo da casa de apostas
     *
     * @param montante
     */
    public void actualizaBetEssTotal(double montante) {
        this.betESStotal = this.betESStotal + montante;
    }

    /**
     * Actualiza o nome da casa de apostas
     *
     * @param nome
     */
    public void actualizaNomeDeBetEssAPI(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve saldo obtido pela casa de apostas
     *
     * @return
     */
    public double devolveSaldoTotal() {
        return betESStotal;
    }

    /**
     * Método responsável por registar a aposta de um apostador sobre um evento
     *
     * @param apostador
     * @param evento
     * @return boolean
     */
    public Aposta registaAposta(Apostador apostador, Evento evento) {

        ApostaView viewAposta = new ApostaView();
        ApostaController apostaController = new ApostaController(new Aposta(), viewAposta);
        Aposta aposta = apostaController.cria(apostador);

        EventoView viewEvento = new EventoView();
        EventoController eventoController = new EventoController(viewEvento, evento);

        if (eventoController.registaApostaDeEvento(aposta)) {
            return aposta;
        }
        return null;
    }

    /**
     * *
     * Actualiza uma aposta sobre um evento
     *
     * @param aposta
     *
     */
    public void actualizaAposta(Aposta aposta) {
        ApostaView viewAposta = new ApostaView();
        ApostaController apostaController = new ApostaController(aposta, viewAposta);

    }

    /**
     * Mostra os dados de uma aposta
     *
     * @param aposta
     */
    public void mostraAposta(Aposta aposta) {
        ApostaView viewAposta = new ApostaView();
        ApostaController apostaController = new ApostaController(aposta, viewAposta);
        apostaController.mostra();
    }

    /**
     * Actualiza as odds de um evento
     *
     * @param evento
     * @param odd_1
     * @param odd_x
     * @param odd_2
     * @return boolean
     */
    public boolean actualizaOdd(Evento evento, int odd_1, int odd_x, int odd_2) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        return eventoController.actualizaOddsDeEvento(evento, odd_1, odd_2, odd_x);
    }

    /**
     * Dá por fechado um evento
     *
     * @param evento
     * @param resultado
     * @return boolean
     */
    public boolean fechaEvento(Evento evento, char resultado) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        boolean res = eventoController.fechaEvento(resultado);
        this.actualizaBetEssTotal(eventoController.calculaSaldoDeEvento());
        return res;
    }

    /**
     * Lista todos os eventos existentes
     */
    public void listarEventos() {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, null);
        for (Evento evento : this.listaEventos) {
            eventoController.setEvento(evento);
            eventoController.listaEvento();
        }
    }

    /**
     * Apaga um evento existente no sistema
     *
     * @param evento
     * @return
     */
    public boolean apagaEvento(Evento evento) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        return eventoController.apaga(listaEventos);
    }

    /**
     * Devolve o numero de eventos existentes no sistema
     *
     * @return Integer
     */
    public int devolveNumeroDeEventos() {
        return this.listaEventos.size();
    }

    /**
     * Devolve o numero de apostadores existentes no sistema
     *
     * @return Integer
     */
    public int devolveNumeroDeApostadores() {
        return this.listaApostadores.size();
    }

    /**
     *
     * Regista um evento no sistema
     *
     * @param bookie
     * @return Evento
     */
    public Evento registaEvento(Bookie bookie) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, new Evento(bookie));
        return eventoController.criaEvento(listaEventos);
    }

    /**
     * Lista os apostadores existentes no sistema
     */
    public void listarApostadores() {
        ApostadorView viewApostador = new ApostadorView();
        for (Apostador apostador : this.listaApostadores.values()) {
            ApostadorController apostadorController = new ApostadorController(viewApostador, apostador);
            apostadorController.lista();
        }
    }

    /**
     * Regista um apostador no sistema Caso o utilizador insira um email já
     * existente a inserção é cancelada
     *
     * @return boolean
     */
    public Apostador registaApostador() {
        ApostadorView viewApostador = new ApostadorView();
        ApostadorController apostadorController = new ApostadorController(viewApostador, new Apostador());
        return apostadorController.cria(listaApostadores);
    }

    /**
     * Actualiza a informação de um apostador através do email
     *
     * @param email
     */
    public void actualizaApostador(String email) {
        ApostadorView viewApostador = new ApostadorView();
        ApostadorController apostadorController = new ApostadorController(viewApostador, new Apostador());
        apostadorController.atualiza();
    }

    /**
     * Apaga um utilizador do sistema. Caso o email passado por argumento não
     * esteja inserido, o método devolverá false
     *
     * @param email
     * @return boolean
     */
    public boolean apagaApostador(String email) {

        ApostadorView viewApostador = new ApostadorView();
        ApostadorController apostadorController = new ApostadorController(viewApostador, null);
        return apostadorController.apaga(email, listaApostadores);
    }

    /**
     * Adiciona um bookie ao sistema
     *
     * @return Bookie
     */
    public Bookie criaBookie() {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(new Bookie(), view);
        return bookieController.adicionaBookie(listaBookies);
    }

    /**
     * Lista um bookie
     *
     * @param bookie
     */
    public void mostraBookie(Bookie bookie) {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(new Bookie(), view);
        bookieController.mostraBookie();
    }

    /**
     * Lista os bookies existentes no sistema
     */
    public void listaBookies() {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(null, view);
        for (Bookie bookie : this.listaBookies.values()) {
            bookieController.setBookie(bookie);
            bookieController.mostraBookie();
        }
    }

    /**
     * Apaga um bookie existente no sistema
     *
     * @param bookie
     * @return
     */
    public boolean apagaBookie(Bookie bookie) {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(bookie, view);
        return bookieController.apagaBookie(listaBookies);

    }

    /**
     * Actualiza os dados de um bookie
     *
     * @param bookie
     * @return
     */
    public boolean actualizaBookie(Bookie bookie) {
        BookieView view = new BookieView();
        BookieController bookieController = new BookieController(bookie, view);
        return bookieController.actualizaBookie(listaBookies);

    }

    /**
     * Devolve o número de bookies do sistema
     *
     * @return Integer
     */
    public int devolveNumeroDeBookiesDoSistema() {
        return this.listaBookies.size();
    }
    
    /**
     * Coloca um bookie a seguir um evento
     * @param evento
     * @param bookie 
     */
    public void adicionaBookieASeguirEvento(Evento evento, Bookie bookie) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        eventoController.adicionaObserver(bookie);
    }
    
    /**
     * Remove um bookie 
     * @param evento
     * @param bookie 
     */
    public void removeBookieASeguirPorEvento(Evento evento, Bookie bookie) {
        EventoView view = new EventoView();
        EventoController eventoController = new EventoController(view, evento);
        eventoController.removeObserver(bookie);
    }
    
    
}

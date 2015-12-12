package ServiceBet.Facade;

import ServiceBet.Controllers.ApostadorController;
import ServiceBet.models.Apostador;
import ServiceBet.models.Evento;
import ServiceBet.views.ApostadorView;
import java.time.Instant;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BetESSAPI {

    private Vector<Evento> listaEventos;
    private HashMap<String, Apostador> listaApostadores;
    private double betESStotal;
    private String name;

    private final BufferedReader in;
    private final PrintStream out;

    public BetESSAPI() {
        this.betESStotal = 0;
        this.listaEventos = new Vector<Evento>();
        this.listaApostadores = new HashMap<String, Apostador>();
        this.name = "BetESSAPI";
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
    }

    public void registaAposta(Apostador apostador, Evento evento) {
        evento.registaAposta(apostador);
    }

    // Interface sobre Eventos
    public boolean actualizaOdd(Evento evento, int odd_1, int odd_x, int odd_2) {

        return evento.actualizaOdd(odd_1, odd_x, odd_2);
    }

    public boolean fechaEvento(Evento evento, char resultado) {
        return evento.fechaEvento(resultado);
    }

    public void viewEventos() {

        ListIterator<Evento> listIterator = this.listaEventos.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().viewEvento());
        }
    }

    public Evento registaEvento(String equipa1, String equipa2) {
         Evento aposta = new Evento(equipa1, equipa2, Date.from(Instant.now()));
        this.listaEventos.add(aposta);
        return aposta;
    }

    public Evento registaEvento() {
        Evento newevento = new Evento();
        newevento.viewCreateEvento();
        this.listaEventos.add(newevento);
        return newevento;
    }

  
    /**
     * Lista os apostadores existentes no sistema
     */
    public void listarApostadores() {
        ApostadorView viewApostador = new ApostadorView();
        for (Apostador apostador : this.listaApostadores.values()) {
            ApostadorController apostadorController = new ApostadorController(viewApostador, apostador);
            apostadorController.listaApostador();
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
        return apostadorController.criaApostador(listaApostadores);
    }

    /**
     * Actualiza a informação de um apostador através do email
     *
     * @param email
     */
    public void actualizaApostador(String email) {
        ApostadorView viewApostador = new ApostadorView();
        ApostadorController apostadorController = new ApostadorController(viewApostador, new Apostador());
        apostadorController.updateApostador();
    }

    /**
     * Apaga um utilizador do sistema. 
     * Caso o email passado por argumento não esteja inserido, o método devolverá false
     * @param email
     * @return boolean
     */
    public boolean deleteApostador(String email) {
        
        ApostadorView viewApostador = new ApostadorView();
        ApostadorController apostadorController = new ApostadorController(viewApostador, null);
        return apostadorController.apagaApostador(email, listaApostadores);
    }

    // Interface sobre Bookies
    // TO-DO
    // Objects view
    

}

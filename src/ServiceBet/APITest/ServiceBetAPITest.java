package ServiceBet.APITest;

import ServiceBet.Facade.BetESSAPI;
import ServiceBet.models.Apostador;
import ServiceBet.models.Evento;

public class ServiceBetAPITest {

    public static void main(String[] args) {

        // criar casa de apostas
        BetESSAPI casaApostas = new BetESSAPI();

        // Criar dois eventos na casa de apostas
        Evento evento1 = casaApostas.registaEvento();
        casaApostas.actualizaOdd(evento1, 1, 2, 3);
        Evento evento2 = casaApostas.registaEvento();
        casaApostas.actualizaOdd(evento2,1, 5, 3);


        Evento evento3 = casaApostas.registaEvento();
        evento3.actualizaOdd(1, 5, 3);
        
        Apostador apostador1 = casaApostas.registaApostador();
        Apostador apostador2 = casaApostas.registaApostador();
        casaApostas.listarApostadores();
        
        
        
        /*
        // Registar dois apostadores
        Apostador apostador1 = casaApostas.registaApostador();
        casaApostas.actualizaApostador(apostador1);
        casaApostas.viewApostadores();
        casaApostas.deleteApostador(apostador1);
        casaApostas.viewApostadores();

        casaApostas.viewEventos();
        casaApostas.viewApostadores();

        // Registar apostas
        casaApostas.registaAposta(apostador1, evento1);
        casaApostas.registaAposta(apostador1, evento2);

        // fechar eventos
        casaApostas.fechaEvento(evento1, 'x');
        casaApostas.fechaEvento(evento2, 'x');

        // regsitar bookies
        // TODO - implementar funcionalidades de bookie
        // Bokkie bookie1 = casaApostas.registaBookie();
        // Evento evento1 = casaApostas.registaEvento(bookie1);
        // casaApostas.fechaEvento(bookie, evento1);
                */



    }

}

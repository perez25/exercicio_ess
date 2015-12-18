package ServiceBet.APITest;

import ServiceBet.Facade.BetESSAPI;
import ServiceBet.models.Aposta;
import ServiceBet.models.Apostador;
import ServiceBet.models.Bookie;
import ServiceBet.models.Evento;

public class ServiceBetAPITest {

    int numeroTestesComSucessoBookie;
    int numeroTestesComInSucessoBookie;
    int numeroTestesComSucessoEvento;
    int numeroTestesComInSucessoEvento;
    int numeroTestesComSucessoAposta;
    int numeroTestesComInsucessoAposta;
    int numeroTestesComSucessoApostador;
    int numeroTestesComInsucessoApostador;

    public ServiceBetAPITest() {
        this.numeroTestesComInSucessoBookie = 0;
        this.numeroTestesComSucessoBookie = 0;
        this.numeroTestesComInSucessoEvento = 0;
        this.numeroTestesComSucessoEvento = 0;
        this.numeroTestesComSucessoAposta = 0;
        this.numeroTestesComInsucessoAposta = 0;
        this.numeroTestesComInsucessoApostador = 0;
        this.numeroTestesComSucessoApostador = 0;
    }

    public int devolveNumeroDeTestesBokie() {
        return (this.numeroTestesComInSucessoBookie + this.numeroTestesComSucessoBookie);
    }

    public int devoleNumeroDeTestesEvento() {
        return (this.numeroTestesComInSucessoEvento + this.numeroTestesComSucessoEvento);
    }

    public int devolveNumeroDeTestesApostador() {
        return (this.numeroTestesComInsucessoApostador + this.numeroTestesComSucessoApostador);
    }

    public int devolveNumeroDeTestesAposta() {
        return (this.numeroTestesComInsucessoAposta + this.numeroTestesComSucessoAposta);
    }

    public void listaResultadoDeTestes() {
        System.out.println("Resultados dos testes ");
        System.out.println(" ------ Bookies --------");
        System.out.println("o   Testes com sucesso  - " + this.numeroTestesComSucessoBookie + " em " + devolveNumeroDeTestesBokie());
        System.out.println("o    Testes sem sucesso  - " + this.numeroTestesComInSucessoBookie + " em " + devolveNumeroDeTestesBokie());

        System.out.println(" ------ Eventos --------");
        System.out.println("o   Testes com sucesso  - " + this.numeroTestesComSucessoEvento + " em " + devoleNumeroDeTestesEvento());
        System.out.println("o   Testes sem sucesso  - " + this.numeroTestesComInSucessoEvento + " em " + devoleNumeroDeTestesEvento());

        System.out.println(" ------ Apostadores --------");
        System.out.println("o   Testes com sucesso  - " + this.numeroTestesComSucessoApostador + " em " + devolveNumeroDeTestesApostador());
        System.out.println("o   Testes sem sucesso  - " + this.numeroTestesComInsucessoApostador + " em " + devolveNumeroDeTestesApostador());

        System.out.println(" ------ Apostas --------");
        System.out.println("o   Testes com sucesso  - " + this.numeroTestesComSucessoAposta + " em " + devolveNumeroDeTestesAposta());
        System.out.println("o   Testes sem sucesso  - " + this.numeroTestesComInsucessoAposta + " em " + devolveNumeroDeTestesAposta());

    }

    public void testesSoftware(BetESSAPI casaApostasAPI) {
        /**
         * CRIAR BOOKIE *
         */
        Bookie bookie1 = casaApostasAPI.criaBookie();
        Bookie bookie2 = casaApostasAPI.criaBookie();
        if (casaApostasAPI.devolveNumeroDeBookiesDoSistema() == 2 && bookie1 != null && bookie2 != null) {
            numeroTestesComSucessoBookie++;
        } else {
            numeroTestesComInSucessoBookie++;
        }
        /**
         * LISTAR BOOKIES *
         */
        casaApostasAPI.listaBookies();
        numeroTestesComSucessoBookie++;

        /**
         * APAGAR BOOKIE *
         */
        if (bookie2 != null) {
            casaApostasAPI.apagaBookie(bookie2);
        }

        /**
         * ACTUALIZAR BOOKIE NÃO EXISTENTE NO SISTEMA *
         */
        if (casaApostasAPI.actualizaBookie(bookie2)) {
            numeroTestesComInSucessoBookie++;
        } else {
            numeroTestesComSucessoBookie++;
        }

        casaApostasAPI.listaBookies();

        if (casaApostasAPI.actualizaBookie(bookie1)) {
            numeroTestesComSucessoBookie++;
        } else {
            numeroTestesComInSucessoBookie++;
        }

        casaApostasAPI.listaBookies();
        /**
         * CONTAR O NUMERO DE BOOKIES NO SISTEMA *
         */
        if (casaApostasAPI.devolveNumeroDeBookiesDoSistema() == 1) {
            numeroTestesComSucessoBookie++;

        } else {
            numeroTestesComInSucessoBookie++;
        }

        /**
         * CRIAR EVENTO *
         */
        Evento evento1 = casaApostasAPI.registaEvento(bookie1);
        Evento evento2 = casaApostasAPI.registaEvento(bookie1);
        Evento evento3 = casaApostasAPI.registaEvento(bookie1);

        if (evento1 != null && evento2 != null && evento3 != null) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;
        }

        /* ACTUALIZAR ODD DE EVENTO */
        
        if (casaApostasAPI.devolveNumeroDeEventos() == 3
                && casaApostasAPI.actualizaOdd(evento1, 1, 2, 3)
                && casaApostasAPI.actualizaOdd(evento2, 1, 5, 3)
                && casaApostasAPI.actualizaOdd(evento3, 1, 5, 3)) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;
        }

        /**
         * LISTAR EVENTOS *
         */
        casaApostasAPI.listarEventos();
        numeroTestesComSucessoEvento++;

        /**
         * CRIAR APOSTADOR
         */
        Apostador apostador1 = casaApostasAPI.registaApostador();
        Apostador apostador2 = casaApostasAPI.registaApostador();

        if (casaApostasAPI.devolveNumeroDeApostadores() == 2) {
            this.numeroTestesComSucessoApostador++;
        } else {
            this.numeroTestesComInsucessoApostador++;
        }
        
        /** LISTAR APOSTADORES **/
        casaApostasAPI.listarApostadores();
        this.numeroTestesComSucessoApostador++;
        
        /** REGISTAR UMA APOSTA **/
        Aposta aposta1 = casaApostasAPI.registaAposta(apostador2, evento3);
        if (aposta1 != null) {
            this.numeroTestesComSucessoAposta++;
        } else {
            this.numeroTestesComInsucessoApostador++;
        }

        /**
         * ADICIONAR BOOKIE A SEGUIR EVENTO
         */
        casaApostasAPI.adicionaBookieASeguirEvento(evento3, bookie1);

        /**
         * FECHAR EVENTO *
         */
        if (casaApostasAPI.fechaEvento(evento3, '1')) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;
        }
        /**
         * FECHAR EVENTO QUE JÁ TERMINOU *
         */
        if (casaApostasAPI.fechaEvento(evento3, '1')) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;
        }
    }
}



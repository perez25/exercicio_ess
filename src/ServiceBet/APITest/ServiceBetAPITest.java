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

    public int devolveNumeroDeTestesEfetuados() {
        return this.devoleNumeroDeTestesEvento() + this.devolveNumeroDeTestesAposta() + this.devolveNumeroDeTestesApostador() + this.devolveNumeroDeTestesBokie();
    }

    public void listaResultadoDeTestes() {
        System.out.println("Resultados dos testes ");
        System.out.println(" ------ Bookies --------");
        System.out.println(">   Testes com sucesso   = " + this.numeroTestesComSucessoBookie + " em " + devolveNumeroDeTestesBokie());
        System.out.println(">   Testes sem sucesso   = " + this.numeroTestesComInSucessoBookie + " em " + devolveNumeroDeTestesBokie());

        System.out.println(" ------ Eventos --------");
        System.out.println(">   Testes com sucesso   = " + this.numeroTestesComSucessoEvento + " em " + devoleNumeroDeTestesEvento());
        System.out.println(">   Testes sem sucesso   = " + this.numeroTestesComInSucessoEvento + " em " + devoleNumeroDeTestesEvento());

        System.out.println(" ------ Apostadores --------");
        System.out.println(">   Testes com sucesso  = " + this.numeroTestesComSucessoApostador + " em " + devolveNumeroDeTestesApostador());
        System.out.println(">   Testes sem sucesso  = " + this.numeroTestesComInsucessoApostador + " em " + devolveNumeroDeTestesApostador());

        System.out.println(" ------ Apostas --------");
        System.out.println(">   Testes com sucesso  = " + this.numeroTestesComSucessoAposta + " em " + devolveNumeroDeTestesAposta());
        System.out.println(">   Testes sem sucesso  = " + this.numeroTestesComInsucessoAposta + " em " + devolveNumeroDeTestesAposta());

        System.out.println("\nNumero total de testes efetuados  = " + devolveNumeroDeTestesEfetuados());

    }

    public void testesSoftware(BetESSAPI casaApostasAPI) {
        /**
         * CRIAR BOOKIE *
         */
        Bookie bookie1 = casaApostasAPI.criaBookie();
        Bookie bookie2 = casaApostasAPI.criaBookie();
        if (casaApostasAPI.getNumBookiesSistema() == 2 && bookie1 != null && bookie2 != null) {
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
        
        /** ACTUALIZAR BOOKIE EXISTENTE NO SISTEMA **/
        
        if (casaApostasAPI.actualizaBookie(bookie1)) {
            numeroTestesComSucessoBookie++;
        } else {
            numeroTestesComInSucessoBookie++;
        }

        casaApostasAPI.listaBookies();
        /**
         * CONTAR O NUMERO DE BOOKIES NO SISTEMA *
         */
        if (casaApostasAPI.getNumBookiesSistema() == 1) {
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
        if (casaApostasAPI.getNumeroDeEventos() == 3
                && casaApostasAPI.actualizaOddEvento(evento1, 1, 2, 3)
                && casaApostasAPI.actualizaOddEvento(evento2, 1, 5, 3)
                && casaApostasAPI.actualizaOddEvento(evento3, 1, 5, 3)) {
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

        if (casaApostasAPI.getNumeroDeApostadores() == 2) {
            this.numeroTestesComSucessoApostador++;
        } else {
            this.numeroTestesComInsucessoApostador++;
        }

        /**
         * LISTAR APOSTADORES *
         */
        casaApostasAPI.listarApostadores();
        this.numeroTestesComSucessoApostador++;

        /**
         * REGISTAR UMA APOSTA *
         */
        Aposta aposta1 = casaApostasAPI.registaAposta(apostador2, evento3);
        if (aposta1 != null) {
            this.numeroTestesComSucessoAposta++;
        } else {
            this.numeroTestesComInsucessoAposta++;
        }

        /**
         * LISTAR APOSTA *
         */
        casaApostasAPI.mostraAposta(aposta1);
        this.numeroTestesComSucessoAposta++;

        /**
         * ATUALIZAR APOSTA SOBRE EVENTO EM ABERTO
         */
        if (casaApostasAPI.actualizaAposta(aposta1)) {
            this.numeroTestesComSucessoAposta++;
        } else {
            this.numeroTestesComInsucessoAposta++;
        }

        /**
         * ADICIONAR BOOKIE A SEGUIR EVENTO
         */
        casaApostasAPI.addBookieASeguirEv(evento3, bookie1);
        if (casaApostasAPI.bookieASeguirEv(evento3, bookie1)) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;
        }

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
            numeroTestesComInSucessoEvento++;
        } else {
            numeroTestesComSucessoEvento++;
        }

        /**
         * APAGAR EVENTO *
         */
        if (casaApostasAPI.apagaEvento(evento2)) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;
        }

        /**
         * REGISTAR APOSTA DE EVENTO JÁ ELIMINADO DO SISTEMA *
         */
        Aposta aposta2 = casaApostasAPI.registaAposta(apostador2, evento2);
        if (aposta2 == null) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;

        }
        /**
         * REGISTAR APOSTA SOBRE EVENTO JÁ FECHADO
         */
        Aposta aposta3 = casaApostasAPI.registaAposta(apostador1, evento3);
        if (aposta3 == null) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;
        }

        /**
         * ELIMINAR APOSTADOR
         */
        casaApostasAPI.apagaApostador(apostador1);

        if (casaApostasAPI.getNumeroDeApostadores() == 1) {
            this.numeroTestesComSucessoApostador++;
        } else {
            this.numeroTestesComInsucessoApostador++;
        }

        /**
         * ATUALIZAR APOSTADOR
         */
        if (casaApostasAPI.actualizaApostador(apostador2)) {
            numeroTestesComSucessoApostador++;
        } else {
            numeroTestesComInsucessoApostador++;
        }

        /**
         * ATUALIZAR APOSTADOR JÁ ELIMINADO DO SISTEMA *
         */
        if (casaApostasAPI.actualizaApostador(apostador1)) {
            numeroTestesComInsucessoApostador++;
        } else {
            numeroTestesComSucessoApostador++;
        }

        Evento evento4 = casaApostasAPI.registaEvento(bookie1);

        /**
         * ATUALIZAR EVENTO *
         */
        if (casaApostasAPI.atualizaEvento(evento4)) {
            numeroTestesComSucessoEvento++;
        } else {
            numeroTestesComInSucessoEvento++;
        }
        
        
        Aposta aposta5 = casaApostasAPI.registaAposta(apostador2, evento4);
        casaApostasAPI.mostraAposta(aposta5);
        
        /** REMOVER APOSTA DE EVENTO **/
        casaApostasAPI.removeAposta(evento4, aposta5);
        this.numeroTestesComSucessoAposta++;
        
        /**
         * LISTAR SERVIÇO BETESS
         */
        casaApostasAPI.mostraBetEssService();

    }
}

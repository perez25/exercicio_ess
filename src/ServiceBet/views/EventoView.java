/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.views;

/**
 *
 * @author Perez_25
 */
public class EventoView extends View {

    public void viewCriaEvento() {
        System.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");

    }

    public void viewUpdateEvento() {
        System.out.println("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
    }

    public void viewDeleteEvento() {

    }

    public void mostraEvento(String equipa1, String equipa2, String resultado_final, String estadoJogo, String data, String odd) {
        System.out.print("Evento{"
                + "equipa1='" + equipa1 + '\''
                + ", equipa2='" + equipa2 + '\''
                + ", resultado_final=" + resultado_final
                + ", estado=" + estadoJogo
                + ", data da aposta" + data
                + ", ultima odd" + odd
                + '}');

    }

}

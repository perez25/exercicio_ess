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
public class EventoView extends View implements MetodosView {

    @Override
    public void viewCria() {
        System.out.println("Criar Evento");
        System.out.println("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)");

    }

    @Override
    public void viewAtualiza() {
        System.out.println("Atualizar Evento");
        System.out.println("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)");
    }

    public void viewActualizaOddEvento() {
        System.out.println("Introduza as novas odds (od1,odx,od2)");
    }

    public void viewActualizaOddEventoSucesso() {
        System.out.println("Odd actualizada com Sucesso !");
    }

    public void viewActualizaOddEventoErro() {
        System.out.println("Evento já se encontra fechado !");
    }

    @Override
    public void viewApagaErro() {
        System.out.println("Erro ao apagar evento!");
    }

    public void viewFecharEventoErro() {
        System.out.println("Resultado inserido não existe !");
    }

    public void viewFecharEventoSucesso() {
        System.out.println("Resultado inserido com sucesso !");
    }

    public void mostraEvento(String equipa1, String equipa2, String resultado_final, String estadoJogo, String data, String odd) {
        System.out.print("\n" + "Evento{"
                + "equipa1 : '" + equipa1 + '\''
                + ", equipa2 : '" + equipa2 + '\''
                + ", resultado_final : " + resultado_final
                + ", estado = " + estadoJogo
                + ", data da aposta : " + data
                + ", ultima odd :" + odd
                + '}' + "\n");

    }

    @Override
    public void viewApaga() {
        System.out.println("Apagar evento!");
    }

    @Override
    public void viewCriaSucesso() {
        System.out.println("Evento criado com sucesso !");
    }

    @Override
    public void viewCriaErro() {
        System.out.println("Erro ao criar evento !");
    }

    @Override
    public void viewApagaSucesso() {
        System.out.println("Evento apagado com sucesso !");
    }

    @Override
    public void viewAtualizaSucesso() {
        System.out.println("Evento atualizado com sucesso !");
    }

    @Override
    public void viewAtualizaErro() {
        System.out.println("Erro ao atualizar Evento  !");
    }

}

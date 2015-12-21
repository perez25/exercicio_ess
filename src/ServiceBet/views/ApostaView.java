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
public class ApostaView extends View implements MetodosView {

    @Override
    public void viewCria() {
           System.out.println("Criar aposta !");
        System.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
    }

    @Override
    public void viewAtualiza() {
        System.out.println("Atualizar aposta !");
        System.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
    }

    public void viewMostra(String aposta, String montante) {
        System.out.println("Apostou no resultado = " + aposta + " o montante =" + montante);
    }

    @Override
    public void viewApaga() {
       System.out.println("Remover aposta !");
    }

    @Override
    public void viewCriaSucesso() {
        System.out.println("Aposta criada com sucesso!");
    }

    @Override
    public void viewCriaErro() {
        System.out.println("Erro ao  criar a aposta!");
    }

    @Override
    public void viewApagaErro() {
        System.out.println("Erro ao remover aposta !");
    }

    @Override
    public void viewApagaSucesso() {
        System.out.println("Aposta removida com sucesso !");
    }

    @Override
    public void viewAtualizaSucesso() {
        System.out.println("Aposta atualizada com sucesso!");
    }

    @Override
    public void viewAtualizaErro() {
        System.out.println("Erro ao atualizar a aposta!");
    }

}

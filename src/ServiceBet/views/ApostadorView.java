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
public class ApostadorView extends View implements MetodosView {

    public void viewActualizaNotificacao(String notificacao, String nome) {
        System.out.println("\nApostador(" + nome + "):" + notificacao + "\n");
    }

    @Override
    public void viewCria() {
        System.out.println("Cria apostador");
        System.out.println("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
    }

    @Override
    public void viewAtualiza() {
        System.out.println("Introduza os novos dados de Apostador: (Nome, email, montante betESScoins\n");
    }

    public void viewMostra(String nome, String email, Float betESSCoins) {
        System.out.println("Apostador{ email=" + email + "  betESScoins=" + betESSCoins + ", name=" + nome + "}");
    }

    @Override
    public void viewApaga() {
        System.out.println("Apagar apostador");
    }

    public void viewJaExisteApostador(String email) {
        System.out.println("Já existe um apostador com o email = " + email);
    }

    
    @Override
    public void viewCriaSucesso() {
        System.out.println("Sucesso na criação do apostador !");
    }

    @Override
    public void viewCriaErro() {
        System.out.println("Erro ao criar apostador!");
    }

    @Override
    public void viewApagaErro() {
        System.out.println("Erro ao apagar apostador!");
    }

    @Override
    public void viewApagaSucesso() {
        System.out.println("Sucesso ao apagar apostador!");
    }

    @Override
    public void viewAtualizaSucesso() {
        System.out.println("Sucesso ao atualizar apostador!");
    }

    @Override
    public void viewAtualizaErro() {
        System.out.println("Erro ao atualizar apostador!");
    }

}

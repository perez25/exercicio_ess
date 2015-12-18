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
public class BookieView extends View implements MetodosView {

    @Override
    public void viewCria() {
        System.out.println("Criar Bookie");
        System.out.println("Introduza os dados de registo (username, password)");
    }

    @Override
    public void viewAtualiza() {
        System.out.println("Actualizar Bookie");
        System.out.println("Introduza os novos dados de registo (username, password)");
    }

    public void viewMostraBookie(String username, String password, String jogosASeguir) {
        System.out.println("{Username: " + username + ", password: " + password + ", jogos a seguir:" + jogosASeguir + "  }\n\n");
    }

    @Override
    public void viewApaga() {
        System.out.println("Apagar bookie");
    }

    @Override
    public void viewCriaSucesso() {
        System.out.println("Bookie criado!");
    }

    @Override
    public void viewCriaErro() {
        System.out.println("Erro ao criar Bookie");
    }

    @Override
    public void viewApagaErro() {
        System.out.println("Bookie não existe no sistema");
    }

    @Override
    public void viewApagaSucesso() {
        System.out.println("Bookie não existe no sistema!");
    }

    @Override
    public void viewAtualizaSucesso() {
        System.out.println("Bookie atualizado !");
    }

    @Override
    public void viewAtualizaErro() {
        System.out.println("Bookie não existe no sistema");
    }

    public void viewMostraNotificacao(String notificacao) {
        System.out.println("| NOTIFICAÇÃO |  -  "+notificacao);
    }
}

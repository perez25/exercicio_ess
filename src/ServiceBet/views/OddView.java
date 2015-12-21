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
public class OddView extends View implements MetodosView {

    @Override
    public void viewApaga() {
        System.out.println("Apagar odd !");
    }

    @Override
    public void viewCria() {
        System.out.println("Criar odd !");
    }

    @Override
    public void viewAtualiza() {
        System.out.println("Atualizar odd !");
    }

    @Override
    public void viewCriaSucesso() {
        System.out.println("Odd criada com sucesso ! ");
    }

    @Override
    public void viewCriaErro() {
        System.out.println("Erro ao criar odd ! ");
    }

    @Override
    public void viewApagaErro() {
        System.out.println("Erro ao apagar odd !");
    }

    @Override
    public void viewApagaSucesso() {
        System.out.println("Sucesso ao apagar odd !");
    }

    @Override
    public void viewAtualizaSucesso() {
        System.out.println("Sucesso ao atualizar odd !");
    }

    @Override
    public void viewAtualizaErro() {
        System.out.println("Erro ao atualizar odd !");
    }

    public void viewMostra(String string) {
        System.out.println(string);
    }

}

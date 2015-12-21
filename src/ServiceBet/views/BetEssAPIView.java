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
public class BetEssAPIView extends View implements MetodosView {

    @Override
    public void viewApaga() {
        System.out.println(" Apagar  serviço BetESS !");

    }

    @Override
    public void viewCria() {
        System.out.println(" Criar um serviço BetESS !");
    }

    @Override
    public void viewAtualiza() {
        System.out.println("Atualizar o serviço BetESS !");

    }

    @Override
    public void viewCriaSucesso() {
         System.out.println("Sucesso ao criar o serviço BetESS !");

    }

    @Override
    public void viewCriaErro() {
        System.out.println("Erro ao criar serviço BetESS");
    }

    @Override
    public void viewApagaErro() {
        System.out.println("Erro ao apagar o serviço BetESS !");

    }

    @Override
    public void viewApagaSucesso() {
        System.out.println("Sucesso ao apagar o serviço BetESS !");

    }

    @Override
    public void viewAtualizaSucesso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewAtualizaErro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void viewMostra(String nome, String betEssCoins, String numeroApostadores, String numeroEventos, String numeroBookies) {
        System.out.println("Serviço BetESS  = " + nome);
        System.out.println("Saldo  = " + betEssCoins);
        System.out.println("Número de Apostadores  = " + numeroApostadores);
        System.out.println("Número de Eventos  = " + numeroEventos);
        System.out.println("Número de bookies  = " + numeroBookies);

    }

}

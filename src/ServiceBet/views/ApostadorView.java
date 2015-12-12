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
public class ApostadorView extends View {

    public void viewActualiza(String notificacao, String nome) {
        System.out.println("\nApostador(" + nome + "):" + notificacao + "\n");
    }

    public void viewCriaApostador() {
        System.out.println("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
    }

    public void viewActualizeApostador(String nome, String email, Float betESSCoins) {
        System.out.print("Os seus dados actuais são: (Nome(" + nome + "), email(" + email + "), montante betESScoins(" + betESSCoins + ")\n");
        System.out.println("Introduza os novos dados de Apostador: (Nome, email, montante betESScoins\n");
    }

    public void viewApostador(String nome, String email, Float betESSCoins) {
        System.out.println("Apostador{ email=" + email + "  betESScoins=" + betESSCoins + ", name=" + nome + "}");
    }

    public void viewApagaApostador() {
        System.out.println("Insira o nome do apostador :");
    }

    public void viewJaExisteApostador(String email) {
        System.out.println("Já existe um apostador com o email = " + email);
    }

    public void viewSucessoCriaApostador() {
        System.out.println("Sucesso na criação do apostador !");
    }
    
    public void viewSucessoApagarApostador(String email){
        System.out.println("Apostador com o email = "+email+" apagado do sistema !");
    }

   

}

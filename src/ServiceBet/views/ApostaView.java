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
public class ApostaView extends View {

    public void viewCriaAposta() {
        System.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
    }

    public void viewMostraAposta(char aposta, float montante) {
        System.out.println("Apostou no resultado" + aposta + " o montante :" + montante);
    }

}

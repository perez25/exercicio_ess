/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.Controllers;

/**
 *
 * @author Perez_25
 */
public abstract  class Controller {
    

    public String[] splitStringPorToken(String readinput, String token) {
        String[] tokens = readinput.split(token);
        return tokens;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.views;

import ServiceBet.models.Input;

/**
 *
 * @author Perez_25
 */
public class View {

    public String getString() {
        Input in = new Input();
        return in.lerString();
    }

    public double getDouble() {
        Input in = new Input();
        return in.readDouble();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Perez_25
 */
public class View {

    /**
     *
     * @return String
     */
    public String getString() {
        String res = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            res = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

 

}

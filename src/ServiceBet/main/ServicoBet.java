/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceBet.main;

import ServiceBet.APITest.ServiceBetAPITest;
import ServiceBet.Facade.BetESSAPI;

/**
 *
 * @author Perez_25
 */
public class ServicoBet {

    public static void main(String[] args) {
        ServiceBetAPITest testeBetEss = new ServiceBetAPITest();
        BetESSAPI casaApostasApi = new BetESSAPI();
        
        testeBetEss.testesSoftware(casaApostasApi);
        testeBetEss.listaResultadoDeTestes();
    }
}

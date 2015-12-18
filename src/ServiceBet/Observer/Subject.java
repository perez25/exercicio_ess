package ServiceBet.Observer;

import ServiceBet.models.Bookie;

public interface Subject {

    void notificaApostadores();

    void notificaBookies();

    void adicionaObserver(Bookie bookie);

    void removeObserver(Bookie bookie);

}

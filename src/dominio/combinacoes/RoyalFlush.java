package dominio.combinacoes;

import dominio.PokerHand;
import enuns.Valor;

public class RoyalFlush extends Combinacao {

    @Override
    public boolean eh() {
        final PokerHand hand = getPokerHand();

        if (!hand.getCarta(0).ehValor(Valor.Dez)) {
            return false;
        }

        if (!ehFlush()) {
            return false;
        }

        return ehSequencia();
    }

    // Royal flush sempre empata
    @Override
    public int desenpata(Combinacao combinacao) {
        if (!(combinacao instanceof RoyalFlush) ) {
            throw new RuntimeException("A outra combinação deve ser um Royal Flush");
        }


        return 0;
    }

    @Override
    public Combinacao clone() {
        return new RoyalFlush();
    }
}
package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;

import java.util.List;

public class Quadra extends Combinacao {

    @Override
    public boolean eh() {
        final PokerHand hand = getPokerHand();

        for (int i = 0; i < 2; i++) {
            final List<Carta> possivelQuadra = hand.procuraValor(hand.getCarta(i));

            if (possivelQuadra.size() == 4) {
                marcaCartasComoDaCombinacao(possivelQuadra);
                return true;
            }
        }

        return false;
    }

    @Override
    public int desenpata(Combinacao combinacao) {
        if (!(combinacao instanceof Quadra) ) {
            throw new RuntimeException("A outra combinação deve ser uma Quadra");
        }

        int desempateHigh = desempateHighCard(combinacao);

        if (desempateHigh != 0) {
            return desempateHigh;
        }

        return desempateKicker(combinacao);
    }

    @Override
    public Combinacao clone() {
        return new Quadra();
    }
}

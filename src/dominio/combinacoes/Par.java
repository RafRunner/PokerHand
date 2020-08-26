package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;

import java.util.List;

public class Par extends Combinacao {

    @Override
    public boolean eh() {
        final PokerHand hand = getPokerHand();

        for (int i = 0; i < 4; i++) {
            final List<Carta> possivelDupla = hand.procuraValor(hand.getCarta(i));

            if (possivelDupla.size() == 2) {
                marcaCartasComoDaCombinacao(possivelDupla);
                return true;
            }
        }

        return false;
    }

    @Override
    public int desenpata(final Combinacao combinacao) {
        if (!(combinacao instanceof Par) ) {
            throw new RuntimeException("A outra combinação deve ser um Par");
        }

        int desempateHigh = desempateHighCard(combinacao);

        if (desempateHigh != 0) {
            return desempateHigh;
        }

        return desempateKicker(combinacao);
    }

    @Override
    public Combinacao clone() {
        return new Par();
    }
}

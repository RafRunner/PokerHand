package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;

import java.util.List;

public class Trinca extends Combinacao {

    @Override
    public boolean eh() {
        final PokerHand hand = getPokerHand();

        for (int i = 0; i < 3; i++) {
            final List<Carta> cartasIguais = hand.procuraValor(hand.getCarta(i));

            if (cartasIguais.size() == 3) {
                marcaCartasComoDaCombinacao(cartasIguais);
                return true;
            }
        }

        return false;
    }

    @Override
    public int desenpata(final Combinacao combinacao) {
        if (!(combinacao instanceof Trinca) ) {
            throw new RuntimeException("A outra combinação deve ser uma Trinca");
        }

        return desempateKicker(combinacao);
    }

    @Override
    public Combinacao clone() {
        return new Trinca();
    }
}

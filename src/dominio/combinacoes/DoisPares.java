package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;

import java.util.List;

public class DoisPares extends Combinacao {

    @Override
    public boolean eh() {
        final PokerHand hand = getPokerHand();
        int quantidadeDePares = 0;

        for (int i = 0; i < 4; i++) {
            final List<Carta> possivelDupla = hand.procuraValor(hand.getCarta(i));

            if (possivelDupla.size() == 2) {
                marcaCartasComoDaCombinacao(possivelDupla);
                quantidadeDePares++;
                i++;
            }
        }

        return quantidadeDePares == 2;
    }

    @Override
    public int desenpata(Combinacao combinacao) {
        if (!(combinacao instanceof DoisPares) ) {
            throw new RuntimeException("A outra combinação deve ser Dois Pares");
        }

        int desempateHigh = desempateHighCard(combinacao);

        if (desempateHigh != 0) {
            return desempateHigh;
        }

        return desempateKicker(combinacao);
    }

    @Override
    public Combinacao clone() {
        return new DoisPares();
    }
}

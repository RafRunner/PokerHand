package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;

import java.util.List;

public class FullHouse extends Combinacao {

    private List<Carta> dupla;
    private List<Carta> trio;

    public List<Carta> getDupla() {
        return dupla;
    }

    public List<Carta> getTrio() {
        return trio;
    }

    @Override
    public boolean eh() {
        final PokerHand hand = getPokerHand();

        final List<Carta> menoresCartas = hand.procuraValor(hand.getCarta(0));
        int quantidadeMenorCarta = menoresCartas.size();

        if (quantidadeMenorCarta < 2) {
            return false;
        }
        if (quantidadeMenorCarta == 2) {
            dupla = menoresCartas;
            final List<Carta> maioresCartas = hand.procuraValor(hand.getCarta(2));
            trio = maioresCartas;

            return maioresCartas.size() == 3;
        }

        trio = menoresCartas;
        final List<Carta> maioresCartas = hand.procuraValor(hand.getCarta(3));
        dupla = maioresCartas;

        return maioresCartas.size() == 2;
    }

    @Override
    public int desenpata(Combinacao combinacao) {
        if (!(combinacao instanceof FullHouse) ) {
            throw new RuntimeException("A outra combinação deve ser um Full House");
        }

        int maiorTrio = trio.get(0).getValor().compareTo(((FullHouse) combinacao).getTrio().get(0).getValor());
        if (maiorTrio != 0) {
            return maiorTrio;
        }

        return dupla.get(0).getValor().compareTo(((FullHouse) combinacao).getDupla().get(0).getValor());
    }

    @Override
    public Combinacao clone() {
        return new FullHouse();
    }
}

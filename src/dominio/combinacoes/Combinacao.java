package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;
import enuns.Valor;

import java.util.ArrayList;
import java.util.List;

public abstract class Combinacao {

    private PokerHand pokerHand;
    private List<Carta> cartasForaDaCombinacao;
    private List<Carta> cartasCombinacao;

    public Combinacao setPokerHand(PokerHand pokerHand) {
        this.pokerHand = pokerHand;
        cartasCombinacao = pokerHand.getCartas();
        cartasForaDaCombinacao = new ArrayList<>();
        return this;
    }

    private List<Carta> getCartasForaDaCombinacao() {
        return cartasForaDaCombinacao;
    }

    private List<Carta> getCartasCombinacao() {
        return cartasCombinacao;
    }

    PokerHand getPokerHand() {
        return pokerHand;
    }

    static boolean ehSequencia(final PokerHand pokerHand) {
        final List<Carta> cartas = pokerHand.getCartas();
        Carta cartaAnterior = cartas.get(0);

        for (int i = 1; i < cartas.size(); i++) {
            final Carta cartaAtual = cartas.get(i);

            if (cartaAtual.getValor().ordinal() != cartaAnterior.getValor().ordinal() + 1) {
                return false;
            }
            cartaAnterior = cartaAtual;
        }

        return true;
    }

    static boolean ehFlush(final PokerHand pokerHand) {
        return pokerHand.procuraNaipe(pokerHand.getCarta(0)).size() == 5;
    }

    void marcaCartasComoDaCombinacao(final List<Carta> cartas) {
        if (cartasCombinacao.size() == 5) {
            cartasCombinacao = new ArrayList<>();
        }
        cartasCombinacao.addAll(cartas);

        for (Carta carta : pokerHand.getCartas()) {
            if (!cartas.contains(carta)) {
                cartasForaDaCombinacao.add(carta);
            }
        }
    }

    int desempateKicker(final Combinacao combinacao) {
        for (int i = cartasForaDaCombinacao.size() - 1; i >= 0; i--) {
           int resultado =  cartasForaDaCombinacao.get(i).getValor().compareTo(combinacao.getCartasForaDaCombinacao().get(i).getValor());

           if (resultado != 0) {
               return resultado;
           }
        }

        return 0;
    }

    int desempateHighCard(final Combinacao combinacao) {
        for (int i = cartasCombinacao.size() - 1; i >= 0; i--) {
            int resultado =  cartasCombinacao.get(i).getValor().compareTo(combinacao.getCartasCombinacao().get(i).getValor());

            if (resultado != 0) {
                return resultado;
            }
        }

        return 0;
    }

    public abstract boolean eh();

    public abstract int desenpata(final Combinacao combinacao);

    public abstract Combinacao clone();
}

package dominio;

import java.util.ArrayList;
import java.util.List;

public class ResultadoComparacao {

    private PokerHand pokerHand;
    private List<Carta> cartasForaDaCombinacao;
    private List<Carta> cartasCombinacao;

    public ResultadoComparacao(final PokerHand pokerHand) {
        this.pokerHand = pokerHand;
        this.cartasForaDaCombinacao = pokerHand.getCartas();
        this.cartasCombinacao = new ArrayList<>();
    }

    public PokerHand getPokerHand() {
        return pokerHand;
    }

    public List<Carta> getCartasForaDaCombinacao() {
        return cartasForaDaCombinacao;
    }

    public List<Carta> getCartasCombinacao() {
        return cartasCombinacao;
    }

    void marcaCartasComoDaCombinacao(final List<Carta> cartas) {
        if (cartasCombinacao.size() == 5) {
            cartasCombinacao = new ArrayList<>();
        }
        cartasCombinacao.addAll(cartas);

        for (final Carta carta : pokerHand.getCartas()) {
            if (!cartas.contains(carta)) {
                cartasForaDaCombinacao.add(carta);
            }
        }
    }
}

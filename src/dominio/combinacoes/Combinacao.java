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

    public List<Carta> getCartasForaDaCombinacao() {
        return cartasForaDaCombinacao;
    }

    public List<Carta> getCartasCombinacao() {
        return cartasCombinacao;
    }

    public PokerHand getPokerHand() {
        return pokerHand;
    }

    protected boolean ehSequencia() {
        final List<Carta> cartas = pokerHand.getCartas();
        Carta cartaAnterior = cartas.get(0);

        for (int i = 1; i < cartas.size(); i++) {
            Carta cartaAtual = cartas.get(i);

            if (cartaAtual.getValor().ordinal() != cartaAnterior.getValor().ordinal() + 1 &&
                    !(cartaAnterior.ehValor(Valor.Cinco) && cartaAtual.ehValor(Valor.Ace))) {
                return false;
            }
            cartaAnterior = cartaAtual;
        }

        return true;
    }

    protected boolean ehFlush() {
        return pokerHand.procuraNaipe(pokerHand.getCarta(0)).size() == 5;
    }

    protected void marcaCartasComoDaCombinacao(List<Carta> cartas) {
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

    protected int desempateKicker(Combinacao combinacao) {
        for (int i = cartasForaDaCombinacao.size() - 1; i >= 0; i--) {
           int resultado =  cartasForaDaCombinacao.get(i).getValor().compareTo(combinacao.getCartasForaDaCombinacao().get(i).getValor());

           if (resultado != 0) {
               return resultado;
           }
        }

        return 0;
    }

    protected int desempateHighCard(Combinacao combinacao) {
        for (int i = cartasCombinacao.size() - 1; i >= 0; i--) {
            int resultado =  cartasCombinacao.get(i).getValor().compareTo(combinacao.getCartasCombinacao().get(i).getValor());

            if (resultado != 0) {
                return resultado;
            }
        }

        return 0;
    }

    public abstract boolean eh();

    public abstract int desenpata(Combinacao combinacao);

    public abstract Combinacao clone();
}

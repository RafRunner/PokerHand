package dominio;

import enuns.ECombinacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultadoVerificacao {

    private final ECombinacao combinacaoTestada;

    private PokerHand pokerHand;
    private Boolean sucesso;
    private List<Carta> cartasForaDaCombinacao;
    private List<Carta> cartasCombinacao;

    public ResultadoVerificacao(final PokerHand pokerHand, final ECombinacao combinacaoTestada) {
        this.combinacaoTestada = combinacaoTestada;
        this.pokerHand = pokerHand;
        this.sucesso = false;
        this.cartasForaDaCombinacao = new ArrayList<>(pokerHand.getCartas());
        this.cartasCombinacao = new ArrayList<>();
    }

    public ECombinacao getCombinacaoTestada() {
        return combinacaoTestada;
    }

    public PokerHand getPokerHand() {
        return pokerHand;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public List<Carta> getCartasForaDaCombinacao() {
        return cartasForaDaCombinacao;
    }

    public List<Carta> getCartasCombinacao() {
        return cartasCombinacao;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public void marcaCartasComoDaCombinacao(final List<Carta> cartas) {
        cartasCombinacao.addAll(cartas);
        cartasForaDaCombinacao = pokerHand.getCartas().stream().filter(carta1 -> cartasCombinacao.stream().noneMatch(carta2 -> carta2.equals(carta1))).collect(Collectors.toList());
    }
}

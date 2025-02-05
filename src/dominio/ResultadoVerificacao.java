package dominio;

import enuns.Combinacao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ResultadoVerificacao {

    private final Combinacao combinacaoTestada;
    private final PokerHand pokerHand;

    private Boolean sucesso;
    private List<Carta> cartasCombinacao;

    public ResultadoVerificacao(final PokerHand pokerHand, final Combinacao combinacaoTestada) {
        this.combinacaoTestada = combinacaoTestada;
        this.pokerHand = pokerHand;
        this.sucesso = false;
        this.cartasCombinacao = new ArrayList<>();
    }

    public Combinacao getCombinacaoTestada() {
        return combinacaoTestada;
    }

    public PokerHand getPokerHand() {
        return pokerHand;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public List<Carta> getCartasForaDaCombinacao() {
        final var setCartas = new TreeSet<>(cartasCombinacao);
        
        return pokerHand.getCartas()
            .stream()
            .filter((carta) -> !setCartas.contains(carta))
            .collect(Collectors.toList());
    }

    public List<Carta> getCartasCombinacao() {
        return cartasCombinacao;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public void marcaCartasComoDaCombinacao(final List<Carta> cartas) {
        cartasCombinacao.addAll(cartas);
    }
}

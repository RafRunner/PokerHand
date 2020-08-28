package dominio;

import enuns.ECombinacao;
import enuns.Naipe;
import enuns.Result;
import enuns.Valor;
import factories.CartaFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand implements Comparable<PokerHand> {

    private final List<Carta> cartas;

    // As cartas estarão sempre em ordem crescente
    public PokerHand(final List<Carta> cartas) {
        this.cartas = cartas;
        Collections.sort(this.cartas);
    }

    public PokerHand(final String mao) {
        this(Arrays.stream(mao.split(" ")).map(CartaFactory::fromRepresentacao).collect(Collectors.toList()));
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public Carta getCarta(int index) {
        return cartas.get(index);
    }

    private List<Carta> procuraNaipe(final Naipe naipe) {
        return cartas.stream().filter(carta -> carta.ehNaipe(naipe)).collect(Collectors.toList());
    }

    public List<Carta> procuraNaipe(final Carta carta) {
        return procuraNaipe(carta.getNaipe());
    }

    private List<Carta> procuraValor(final Valor valor) {
        return cartas.stream().filter(carta -> carta.ehValor(valor)).collect(Collectors.toList());
    }

    public List<Carta> procuraValor(final Carta carta) {
        return procuraValor(carta.getValor());
    }

    @Override
    public int compareTo(final PokerHand o) {
        final ResultadoVerificacao esseResultado = ECombinacao.getResultadoHand(this);
        final ResultadoVerificacao outroResultado = ECombinacao.getResultadoHand(o);

        if (esseResultado.getCombinacaoTestada().ordinal() == outroResultado.getCombinacaoTestada().ordinal()) {
            return esseResultado.getCombinacaoTestada().desenpata(esseResultado, outroResultado);
        }

        return Integer.compare(esseResultado.getCombinacaoTestada().ordinal(), outroResultado.getCombinacaoTestada().ordinal());
    }

    public Result compareWith(PokerHand o) {
        final int result = this.compareTo(o);

        if (result > 0) {
            return Result.WIN;
        }
        if (result == 0) {
            return Result.DRAW;
        }
        return Result.LOSS;
    }
}

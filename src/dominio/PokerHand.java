package dominio;

import enuns.ECombinacao;
import enuns.Naipe;
import enuns.Result;
import enuns.Valor;
import factories.CartaFactory;

import java.util.ArrayList;
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
        final List<Carta> cartas = new ArrayList<>();

        for (Carta carta : this.cartas) {
            if (carta.ehNaipe(naipe)) {
                cartas.add(carta);
            }
        }
        return cartas;
    }

    public List<Carta> procuraNaipe(final Carta carta) {
        return procuraNaipe(carta.getNaipe());
    }

    private List<Carta> procuraValor(final Valor valor) {
        final List<Carta> cartas = new ArrayList<>();

        for (Carta carta : this.cartas) {
            if (carta.ehValor(valor)) {
                cartas.add(carta);
            }
        }
        return cartas;
    }

    public List<Carta> procuraValor(final Carta carta) {
        return procuraValor(carta.getValor());
    }

    @Override
    public int compareTo(final PokerHand o) {
        final ECombinacao[] combinacoes = ECombinacao.values();

        ECombinacao essaECombinacao = ECombinacao.ENada;
        ECombinacao outraECombinacao = ECombinacao.ENada;
        ResultadoVerificacao esseResultado = essaECombinacao.eh(this);
        ResultadoVerificacao outroResultado = outraECombinacao.eh(o);

        for (int i = 1; i < combinacoes.length; i++) {
            final ECombinacao eCombinacao = combinacoes[i];
            ResultadoVerificacao esseResultadoParcial = eCombinacao.eh(this);
            ResultadoVerificacao outroResultadoParcial = eCombinacao.eh(o);

            if (esseResultadoParcial.getSucesso()) {
                esseResultado = esseResultadoParcial;
                essaECombinacao = eCombinacao;
            }
            if (outroResultadoParcial.getSucesso()) {
                outroResultado = outroResultadoParcial;
                outraECombinacao = eCombinacao;
            }
        }

        if (essaECombinacao.ordinal() == outraECombinacao.ordinal()) {
            return essaECombinacao.desenpata(esseResultado, outroResultado);
        }

        return Integer.compare(essaECombinacao.ordinal(), outraECombinacao.ordinal());
    }

    public Result compareWith(PokerHand o) {
        int result = this.compareTo(o);

        if (result > 0) {
            return Result.WIN;
        }
        if (result == 0) {
            return Result.DRAW;
        }
        return Result.LOSS;
    }
}

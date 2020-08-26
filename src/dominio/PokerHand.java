package dominio;

import dominio.combinacoes.Combinacao;
import dominio.combinacoes.Nada;
import enuns.ECombinacao;
import enuns.Naipe;
import enuns.Result;
import enuns.Valor;
import factories.CartaFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {

    private final List<Carta> cartas = new ArrayList<>();

    // As cartas estarão sempre em ordem crescente
    public PokerHand(final String mao) {
        final String[] cartasRepresentadas = mao.split(" ");

        for (final String c : cartasRepresentadas) {
            cartas.add(CartaFactory.fromRepresentacao(c.trim()));
        }

        Collections.sort(cartas);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public Carta getCarta(int index) {
        return cartas.get(index);
    }

    public List<Carta> procuraNaipe(final Naipe naipe) {
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

    public List<Carta> procuraValor(final Valor valor) {
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

        ECombinacao essaECombinacao = ECombinacao.Nada;
        ECombinacao outraECombinacao = ECombinacao.Nada;

        Combinacao essaCombinacao = new Nada();
        Combinacao outraCombinacao = new Nada();

        for (ECombinacao ec : combinacoes) {
            final Combinacao combinacao = ec.getCombinacao();
            if (combinacao.setPokerHand(this).eh()) {
                essaECombinacao = ec;
                essaCombinacao = combinacao;
            }

            final Combinacao oCombinacao = combinacao.clone();
            if (oCombinacao.setPokerHand(o).eh()) {
                outraECombinacao = ec;
                outraCombinacao = oCombinacao;
            }
        }

        if (essaECombinacao.ordinal() - outraECombinacao.ordinal() == 0) {
            return essaCombinacao.desenpata(outraCombinacao);
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

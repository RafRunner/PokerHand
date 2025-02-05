package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.Combinacao;

import java.util.ArrayList;
import java.util.List;

public class FullHouseUtil {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        final var resultado = new ResultadoVerificacao(pokerHand, Combinacao.FullHouse);

        final List<Carta> menoresCartas = pokerHand.procuraValor(pokerHand.getCarta(0));
        int quantidadeMenorCarta = menoresCartas.size();

        if (quantidadeMenorCarta < 2) {
            return resultado;
        }
        if (quantidadeMenorCarta == 2) {
            final List<Carta> maioresCartas = pokerHand.procuraValor(pokerHand.getCarta(2));

            if (maioresCartas.size() == 3) {
                resultado.marcaCartasComoDaCombinacao(pokerHand.getCartas());
                resultado.setSucesso(true);
            }

            return resultado;
        }

        final List<Carta> maioresCartas = pokerHand.procuraValor(pokerHand.getCarta(3));
        if (maioresCartas.size() == 2) {
            resultado.marcaCartasComoDaCombinacao(pokerHand.getCartas());
            resultado.setSucesso(true);
        }

        return resultado;
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        final var trio1 = new ArrayList<Carta>();
        final var trio2 = new ArrayList<Carta>();
        final var dupla1 = new ArrayList<Carta>();
        final var dupla2 = new ArrayList<Carta>();

        final PokerHand hand1 = resultado1.getPokerHand();
        final PokerHand hand2 = resultado2.getPokerHand();

        encontraTrioEDupla(hand1, trio1, dupla1);
        encontraTrioEDupla(hand2, trio2, dupla2);

        final int maiorTrio = trio1.get(0).compareTo(trio2.get(0));
        if (maiorTrio != 0) {
            return maiorTrio;
        }

        return dupla1.get(0).compareTo(dupla2.get(0));
    }

    private static void encontraTrioEDupla(final PokerHand hand, final List<Carta> trio, final List<Carta> dupla) {
        if (hand.procuraValor(hand.getCarta(0)).size() == 3) {
            trio.addAll(hand.getCartas().subList(0, 3));
            dupla.addAll(hand.getCartas().subList(3, 5));
        }
        else {
            trio.addAll(hand.getCartas().subList(2, 5));
            dupla.addAll(hand.getCartas().subList(0, 2));
        }
    }
}

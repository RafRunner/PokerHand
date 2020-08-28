package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.ECombinacao;
import enuns.Valor;

import java.util.List;

public class CombinacaoUtils {

    static ResultadoVerificacao ehSequencia(final PokerHand pokerHand, final ECombinacao combinacaoTestada) {
        final var resultado = new ResultadoVerificacao(pokerHand, combinacaoTestada);
        final List<Carta> cartas = pokerHand.getCartas();
        Carta cartaAnterior = cartas.get(0);

        for (int i = 1; i < cartas.size(); i++) {
            final Carta cartaAtual = cartas.get(i);

            if (cartaAtual.getValor().ordinal() != cartaAnterior.getValor().ordinal() + 1 &&
                    !(cartaAnterior.ehValor(Valor.Cinco) && cartaAtual.ehValor(Valor.Ace))) {
                return resultado;
            }
            cartaAnterior = cartaAtual;
        }

        resultado.setSucesso(true);
        resultado.marcaCartasComoDaCombinacao(cartas);
        return resultado;
    }

    static ResultadoVerificacao ehFlush(final PokerHand pokerHand, final ECombinacao combinacaoTestada) {
        final var resultado = new ResultadoVerificacao(pokerHand, combinacaoTestada);
        resultado.setSucesso(pokerHand.procuraNaipe(pokerHand.getCarta(0)).size() == 5);

        if (resultado.getSucesso()) {
            resultado.marcaCartasComoDaCombinacao(pokerHand.getCartas());
        }

        return resultado;
    }

    static int desempateKicker(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        for (int i = resultado1.getCartasForaDaCombinacao().size() - 1; i >= 0; i--) {
            int resultado = resultado1.getCartasForaDaCombinacao().get(i).compareValor(resultado2.getCartasForaDaCombinacao().get(i));

            if (resultado != 0) {
                return resultado;
            }
        }

        return 0;
    }

    static int desempateHighCard(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        for (int i = resultado1.getCartasCombinacao().size() - 1; i >= 0; i--) {
            int resultado = resultado1.getCartasCombinacao().get(i).compareValor(resultado2.getCartasCombinacao().get(i));

            if (resultado != 0) {
                return resultado;
            }
        }

        return 0;
    }
}

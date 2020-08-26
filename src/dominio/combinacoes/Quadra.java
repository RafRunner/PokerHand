package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;
import dominio.ResultadoVerificacao;

import java.util.List;

public class Quadra {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        final var resultado = new ResultadoVerificacao(pokerHand, false);

        for (int i = 0; i < 2; i++) {
            final List<Carta> possivelQuadra = pokerHand.procuraValor(pokerHand.getCarta(i));

            if (possivelQuadra.size() == 4) {
                resultado.marcaCartasComoDaCombinacao(possivelQuadra);
                resultado.setSucesso(true);
                return resultado;
            }
        }

        return resultado;
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        int desempateHigh = CombinacaoUtils.desempateHighCard(resultado1, resultado2);

        if (desempateHigh != 0) {
            return desempateHigh;
        }

        return CombinacaoUtils.desempateKicker(resultado1, resultado2);
    }
}

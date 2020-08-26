package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;

public class StraightFlush {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        final var resultado = CombinacaoUtils.ehFlush(pokerHand);
        if (!resultado.getSucesso()) {
            return resultado;
        }

        return CombinacaoUtils.ehSequencia(pokerHand);
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return CombinacaoUtils.desempateHighCard(resultado1, resultado2);
    }
}

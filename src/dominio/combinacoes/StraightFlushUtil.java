package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.Combinacao;

public class StraightFlushUtil {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        final var resultado = CombinacaoUtils.ehFlush(pokerHand, Combinacao.StraightFlush);
        if (!resultado.getSucesso()) {
            return resultado;
        }

        return CombinacaoUtils.ehSequencia(pokerHand, Combinacao.StraightFlush);
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return CombinacaoUtils.desempateHighCard(resultado1, resultado2);
    }
}

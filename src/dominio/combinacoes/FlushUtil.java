package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.Combinacao;

public class FlushUtil {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        return CombinacaoUtils.ehFlush(pokerHand, Combinacao.Flush);
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return CombinacaoUtils.desempateHighCard(resultado1, resultado2);
    }
}

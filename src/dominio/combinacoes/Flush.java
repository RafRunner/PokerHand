package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;

public class Flush {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        return CombinacaoUtils.ehFlush(pokerHand);
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return CombinacaoUtils.desempateHighCard(resultado1, resultado2);
    }
}

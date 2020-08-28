package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.ECombinacao;

public class Sequencia {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        return CombinacaoUtils.ehSequencia(pokerHand, ECombinacao.ESequencia);
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return CombinacaoUtils.desempateHighCard(resultado1, resultado2);
    }
}

package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.Combinacao;
import enuns.Valor;

public class RoyalFlushUtil {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        var resultado = new ResultadoVerificacao(pokerHand, Combinacao.RoyalFlush);

        if (!pokerHand.getCarta(0).ehValor(Valor.Dez)) {
            return resultado;
        }

        resultado = CombinacaoUtils.ehFlush(pokerHand, Combinacao.RoyalFlush);
        if (!resultado.getSucesso()) {
            return resultado;
        }

        return CombinacaoUtils.ehSequencia(pokerHand, Combinacao.RoyalFlush);
    }

    // Royal flush sempre empata
    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return 0;
    }
}

package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.ECombinacao;
import enuns.Valor;

public class RoyalFlush {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        var resultado = new ResultadoVerificacao(pokerHand, ECombinacao.ERoyalFlush);

        if (!pokerHand.getCarta(0).ehValor(Valor.Dez)) {
            return resultado;
        }

        resultado = CombinacaoUtils.ehFlush(pokerHand, ECombinacao.ERoyalFlush);
        if (!resultado.getSucesso()) {
            return resultado;
        }

        return CombinacaoUtils.ehSequencia(pokerHand, ECombinacao.ERoyalFlush);
    }

    // Royal flush sempre empata
    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return 0;
    }
}

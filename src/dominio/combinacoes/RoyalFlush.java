package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.Valor;

public class RoyalFlush {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        var resultado = new ResultadoVerificacao(pokerHand, false);

        if (!pokerHand.getCarta(0).ehValor(Valor.Dez)) {
            return resultado;
        }

        resultado = CombinacaoUtils.ehFlush(pokerHand);
        if (!resultado.getSucesso()) {
            return resultado;
        }

        return CombinacaoUtils.ehSequencia(pokerHand);
    }

    // Royal flush sempre empata
    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return 0;
    }
}

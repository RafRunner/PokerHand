package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.Combinacao;

public class NadaUtil {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        final var resultado = new ResultadoVerificacao(pokerHand, Combinacao.HighCard);
        resultado.marcaCartasComoDaCombinacao(pokerHand.getCartas());

        return resultado;
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return CombinacaoUtils.desempateHighCard(resultado1, resultado2);
    }
}

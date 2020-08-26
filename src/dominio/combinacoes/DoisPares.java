package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;
import dominio.ResultadoVerificacao;

import java.util.List;

public class DoisPares {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        final var resultado = new ResultadoVerificacao(pokerHand, false);
        int quantidadeDePares = 0;

        for (int i = 0; i < 4; i++) {
            final List<Carta> possivelDupla = pokerHand.procuraValor(pokerHand.getCarta(i));

            if (possivelDupla.size() == 2) {
                resultado.marcaCartasComoDaCombinacao(possivelDupla);
                quantidadeDePares++;
                i++;
            }
        }

        if (quantidadeDePares == 2) {
            resultado.setSucesso(true);
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

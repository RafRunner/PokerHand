package dominio.combinacoes;

import dominio.Carta;
import dominio.PokerHand;
import dominio.ResultadoVerificacao;

import java.util.List;

public class Trinca {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        final var resultado = new ResultadoVerificacao(pokerHand, false);

        for (int i = 0; i < 3; i++) {
            final List<Carta> cartasIguais = pokerHand.procuraValor(pokerHand.getCarta(i));

            if (cartasIguais.size() == 3) {
                resultado.marcaCartasComoDaCombinacao(cartasIguais);
                resultado.setSucesso(true);
                return resultado;
            }
        }

        return resultado;
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return CombinacaoUtils.desempateKicker(resultado1, resultado2);
    }
}

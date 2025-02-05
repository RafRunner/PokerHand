package dominio.combinacoes;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import enuns.Combinacao;
import enuns.Valor;

public class SequenciaUtil {

    public static ResultadoVerificacao eh(final PokerHand pokerHand) {
        return CombinacaoUtils.ehSequencia(pokerHand, Combinacao.Sequencia);
    }

    public static int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        final var cartas1 = resultado1.getCartasCombinacao();
        final var cartas2 = resultado2.getCartasCombinacao();

        // Testando a sequência mais baixa, de Às a Cinco
        if ((cartas1.get(4).ehValor(Valor.Ace) && cartas1.get(3).ehValor(Valor.Cinco))
            || (cartas2.get(4).ehValor(Valor.Ace) && cartas2.get(3).ehValor(Valor.Cinco))) {

                if (cartas1.get(4).ehValor(Valor.Ace)) {
                    if (cartas2.get(4).ehValor(Valor.Ace)) {
                        return 0;
                    } else {
                        return Valor.Cinco.ordinal() - cartas2.get(4).getValor().ordinal();
                    }
                } else {
                    return cartas1.get(4).getValor().ordinal() - Valor.Cinco.ordinal();
                }
        }

        return CombinacaoUtils.desempateHighCard(resultado1, resultado2);
    }
}

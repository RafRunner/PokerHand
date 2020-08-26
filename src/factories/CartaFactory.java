package factories;

import dominio.Carta;
import enuns.Naipe;
import enuns.Valor;

public class CartaFactory {

    public static Carta fromRepresentacao(final String representacao) {
        final String valorRepresentado = representacao.substring(0, 1);
        final String naipeRepresentado = representacao.substring(1, 2);

        final Valor valor = Valor.fromRepresentacao(valorRepresentado);
        final Naipe naipe = Naipe.fromRepresentacao(naipeRepresentado);

        return new Carta(valor, naipe);
    }
}

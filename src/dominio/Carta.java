package dominio;

import enuns.Naipe;
import enuns.Valor;

public class Carta implements Comparable<Carta> {

    private final Valor valor;
    private final Naipe naipe;

    public Carta(final Valor valor, final Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public Valor getValor() {
        return valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public boolean ehValor(final Valor valor) {
        return this.valor.equals(valor);
    }

    public boolean ehNaipe(final Naipe naipe) {
        return this.naipe.equals(naipe);
    }

    public int compareValor(final Carta o) {
        return this.valor.compareTo(o.getValor());
    }

    @Override
    public int compareTo(final Carta o) {
        final int comparacaoValor = this.valor.compareTo(o.getValor());

        return comparacaoValor != 0 ? comparacaoValor : this.naipe.compareTo(o.getNaipe());
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Carta)) {
            return false;
        }

        return compareTo((Carta) obj) == 0;
    }
}

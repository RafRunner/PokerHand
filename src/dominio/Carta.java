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

    @Override
    public int compareTo(final Carta o) {
        if (this.valor.compareTo(o.getValor()) < 0) {
            return -1;
        }
        if (this.valor.compareTo(o.getValor()) > 0) {
            return 1;
        }

        return this.naipe.compareTo(o.getNaipe());
    }
}

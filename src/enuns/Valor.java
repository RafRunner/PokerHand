package enuns;

public enum Valor {

    Dois("2"),
    Tres("3"),
    Quatro("4"),
    Cinco("5"),
    Seis("6"),
    Sete("7"),
    Oito("8"),
    Nove("9"),
    Dez("T"),
    Valete("J"),
    Rainha("Q"),
    Rei("K"),
    Ace("A");

    final String representacao;

    Valor(final String representacao) {
        this.representacao = representacao;
    }

    public static Valor fromRepresentacao(final String representacao) {
        Valor valor = null;
        for (Valor v : values()) {
            if (representacao.equals(v.representacao)) {
                valor = v;
            }
        }
        return valor;
    }
}

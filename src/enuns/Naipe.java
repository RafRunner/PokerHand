package enuns;

public enum Naipe {

    Espadas("S"),
    Copas("H"),
    Ouros("D"),
    Paus("C");

    final String representacao;

    Naipe(final String representacao) {
        this.representacao = representacao;
    }

    public static Naipe fromRepresentacao(final String representacao) {
        Naipe naipe = null;
        for (Naipe n : values()) {
            if (representacao.equals(n.representacao)) {
                naipe = n;
            }
        }
        return naipe;
    }
}

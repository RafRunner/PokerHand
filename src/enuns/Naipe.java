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
        for (Naipe n : values()) {
            if (representacao.equals(n.representacao)) {
                return n;
            }
        }

        throw new ParseException("A representação " + representacao + "não corresponde a nenhum Naipe");
    }
}

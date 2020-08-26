package enuns;

import dominio.combinacoes.*;

public enum ECombinacao {

    Nada(new Nada()),
    Par(new Par()),
    DoisPares(new DoisPares()),
    Trinca(new Trinca()),
    Sequencia(new Sequencia()),
    Flush(new Flush()),
    FullHouse(new FullHouse()),
    Quadra(new Quadra()),
    StraighFlush(new StraightFlush()),
    RoyalFlush(new RoyalFlush());

    private Combinacao combinacao;

    ECombinacao(Combinacao combinacao) {
        this.combinacao = combinacao;
    }

    public Combinacao getCombinacao() {
        return combinacao;
    }

}

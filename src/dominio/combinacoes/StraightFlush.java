package dominio.combinacoes;

public class StraightFlush extends Combinacao {

    @Override
    public boolean eh() {
        if (!ehFlush()) {
            return false;
        }

        return ehSequencia();
    }

    @Override
    public int desenpata(Combinacao combinacao) {
        if (!(combinacao instanceof StraightFlush) ) {
            throw new RuntimeException("A outra combinação deve ser um Straight Flush");
        }

        return desempateHighCard(combinacao);
    }

    @Override
    public Combinacao clone() {
        return new StraightFlush();
    }
}

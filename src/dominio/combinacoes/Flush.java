package dominio.combinacoes;

public class Flush extends Combinacao {

    @Override
    public boolean eh() {
        return ehFlush(getPokerHand());
    }

    @Override
    public int desenpata(final Combinacao combinacao) {
        if (!(combinacao instanceof Flush) ) {
            throw new RuntimeException("A outra combinação deve ser um Flush");
        }

        return desempateHighCard(combinacao);
    }

    @Override
    public Combinacao clone() {
        return new Flush();
    }
}

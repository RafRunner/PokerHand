package dominio.combinacoes;

import enuns.Valor;

public class Sequencia extends Combinacao {

    @Override
    public boolean eh() {
        return ehSequencia();
    }

    @Override
    public int desenpata(Combinacao combinacao) {
        if (!(combinacao instanceof Sequencia) ) {
            throw new RuntimeException("A outra combinação deve ser uma Sequência");
        }

        if (getPokerHand().getCarta(0).ehValor(Valor.Dois)) {
            getPokerHand().getCartas().remove(4);
        }

        if (combinacao.getPokerHand().getCarta(0).ehValor(Valor.Dois)) {
            combinacao.getPokerHand().getCartas().remove(4);
        }

        return desempateHighCard(combinacao);
    }

    @Override
    public Combinacao clone() {
        return new Sequencia();
    }
}

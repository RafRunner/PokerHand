package dominio.combinacoes;

public class Nada extends Combinacao {

    @Override
    public boolean eh() {
        return true;
    }

    @Override
    public int desenpata(Combinacao combinacao) {
        return desempateHighCard(combinacao);
    }

    @Override
    public Combinacao clone() {
        return new Nada();
    }
}

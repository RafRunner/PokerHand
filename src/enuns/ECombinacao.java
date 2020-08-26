package enuns;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import dominio.combinacoes.*;
import interfaces.Desempatavel;
import interfaces.Verificavel;

public enum ECombinacao {

    ENada(Nada::eh, Nada::desenpata),
    EPar(Par::eh, Par::desenpata),
    EDoisPares(DoisPares::eh, DoisPares::desenpata),
    ETrinca(Trinca::eh, Trinca::desenpata),
    ESequencia(Sequencia::eh, Sequencia::desenpata),
    EFlush(Flush::eh, Flush::desenpata),
    EFullHouse(FullHouse::eh, FullHouse::desenpata),
    EQuadra(Quadra::eh, Quadra::desenpata),
    EStraightFlush(StraightFlush::eh, StraightFlush::desenpata),
    ERoyalFlush(RoyalFlush::eh, RoyalFlush::desenpata);

    private Verificavel check;
    private Desempatavel desempate;

    ECombinacao(final Verificavel check, final Desempatavel desempate) {
        this.check = check;
        this.desempate = desempate;
    }

    public ResultadoVerificacao eh(final PokerHand pokerHand) {
        return check.eh(pokerHand);
    }

    public int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return desempate.desenpata(resultado1, resultado2);
    }
}

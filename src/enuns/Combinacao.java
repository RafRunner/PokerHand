package enuns;

import java.util.Arrays;
import java.util.Collections;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;
import dominio.combinacoes.*;
import interfaces.Desempatavel;
import interfaces.Verificavel;

public enum Combinacao implements Verificavel, Desempatavel {

    HighCard(NadaUtil::eh, NadaUtil::desenpata),
    Par(ParUtil::eh, ParUtil::desenpata),
    DoisPares(DoisParesUtil::eh, DoisParesUtil::desenpata),
    Trinca(TrincaUtil::eh, TrincaUtil::desenpata),
    Sequencia(SequenciaUtil::eh, SequenciaUtil::desenpata),
    Flush(FlushUtil::eh, FlushUtil::desenpata),
    FullHouse(FullHouseUtil::eh, FullHouseUtil::desenpata),
    Quadra(QuadraUtil::eh, QuadraUtil::desenpata),
    StraightFlush(StraightFlushUtil::eh, StraightFlushUtil::desenpata),
    RoyalFlush(RoyalFlushUtil::eh, RoyalFlushUtil::desenpata);

    private Verificavel check;
    private Desempatavel desempate;

    Combinacao(final Verificavel check, final Desempatavel desempate) {
        this.check = check;
        this.desempate = desempate;
    }

    public ResultadoVerificacao eh(final PokerHand pokerHand) {
        return check.eh(pokerHand);
    }

    public int desenpata(final ResultadoVerificacao resultado1, final ResultadoVerificacao resultado2) {
        return desempate.desenpata(resultado1, resultado2);
    }

    public static ResultadoVerificacao getResultadoHand(final PokerHand pokerHand) {
        final var valuesList = Arrays.asList(values());
        Collections.reverse(valuesList);
        
        return valuesList
            .stream()
            .map((combinacao) -> combinacao.eh(pokerHand))
            .filter((resultado) -> resultado.getSucesso())
            .findFirst()
            // Nunca acontece pois HighCard sempre tem sucesso
            .orElseThrow(() -> new IllegalStateException("Uma mão falhou em ser classificada. Pânico! Checar HighCard"));
    }
}

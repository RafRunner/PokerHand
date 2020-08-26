package interfaces;

import dominio.PokerHand;
import dominio.ResultadoVerificacao;

public interface Verificavel {

    ResultadoVerificacao eh(final PokerHand pokerHand);
}

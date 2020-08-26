package testes;

import dominio.*;
import enuns.ECombinacao;
import enuns.Result;

import java.util.Arrays;

public class Testes {

    public static void main(String[] args) {
        PokerHand nada = new PokerHand("KS 2H 5C JD TD");
        PokerHand royalFlush = new PokerHand("TH AH JH QH KH");
        PokerHand straighFlush = new PokerHand("5C 6C 7C 8C 9C");
        PokerHand quadra = new PokerHand("8C AD AS AC AH");
        PokerHand fullHouse = new PokerHand("TC TH KS KC KH");
        PokerHand flush = new PokerHand("3C 4C 6C 8C QC");
        PokerHand trica = new PokerHand("5C 8D JC JH JD");
        PokerHand doisPares = new PokerHand("TD TC 6S 6C KD");
        PokerHand par = new PokerHand("8S 6H 2D AH AS");

        Arrays.stream(ECombinacao.values()).forEach(eCombinacao -> { assert(!eCombinacao.eh(nada).getSucesso()); });

        System.out.println("1 - " + ECombinacao.ERoyalFlush.eh(royalFlush).getSucesso());
        System.out.println("2 - " + !ECombinacao.ERoyalFlush.eh(straighFlush).getSucesso());

        System.out.println("3 - " + ECombinacao.EStraightFlush.eh(straighFlush).getSucesso());
        System.out.println("4 - " + !ECombinacao.EStraightFlush.eh(quadra).getSucesso());

        System.out.println("5 - " + ECombinacao.EQuadra.eh(quadra).getSucesso());
        System.out.println("6 - " + !ECombinacao.EQuadra.eh(fullHouse).getSucesso());

        System.out.println("7 - " + ECombinacao.EFullHouse.eh(fullHouse).getSucesso());
        System.out.println("8 - " + !ECombinacao.EFullHouse.eh(quadra).getSucesso());
        System.out.println("9 - " + !ECombinacao.EFullHouse.eh(straighFlush).getSucesso());

        System.out.println("10 - " + ECombinacao.EFlush.eh(flush).getSucesso());
        System.out.println("11 - " + !ECombinacao.EFlush.eh(fullHouse).getSucesso());
        System.out.println("12 - " + !ECombinacao.EFlush.eh(quadra).getSucesso());

        System.out.println("13 - " + ECombinacao.ETrinca.eh(trica).getSucesso());
        System.out.println("14 - " + !ECombinacao.ETrinca.eh(doisPares).getSucesso());
        System.out.println("15 - " + !ECombinacao.ETrinca.eh(par).getSucesso());

        System.out.println("16 - " + ECombinacao.EDoisPares.eh(doisPares).getSucesso());
        System.out.println("17 - " + !ECombinacao.EDoisPares.eh(par).getSucesso());

        System.out.println("18 - " + ECombinacao.EPar.eh(par).getSucesso());

        System.out.println("19 - " + (new PokerHand("TC TH 5C 5H KH").compareWith(new PokerHand("9C 9H 5C 5H AC")) == Result.WIN));
        System.out.println("21 - " + (new PokerHand("TS TD KC JC 7C").compareWith(new PokerHand("JS JC AS KC TD")) == Result.LOSS));
        System.out.println("22 - " + (new PokerHand("7H 7C QC JS TS").compareWith(new PokerHand("7D 7C JS TS 6D")) == Result.WIN));
        System.out.println("23 - " + (new PokerHand("5S 5D 8C 7S 6H").compareWith(new PokerHand("7D 7S 5S 5D JS")) == Result.LOSS));
        System.out.println("24 - " + (new PokerHand("AS AD KD 7C 3D").compareWith(new PokerHand("AD AH KD 7C 4S")) == Result.LOSS));
        System.out.println("25 - " + (new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("AC AH AS AS KS")) == Result.WIN));
        System.out.println("26 - " + (new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("TC JS QC KS AC")) == Result.WIN));
        System.out.println("27 - " + (new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("QH QS QC AS 8H")) == Result.WIN));
        System.out.println("28 - " + (new PokerHand("AC AH AS AS KS").compareWith(new PokerHand("TC JS QC KS AC")) == Result.WIN));
        System.out.println("29 - " + (new PokerHand("AC AH AS AS KS").compareWith(new PokerHand("QH QS QC AS 8H")) == Result.WIN));
        System.out.println("30 - " + (new PokerHand("TC JS QC KS AC").compareWith(new PokerHand("QH QS QC AS 8H")) == Result.WIN));
        System.out.println("31 - " + (new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("JH JC JS JD TH")) == Result.WIN));
        System.out.println("32 - " + (new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("4H 5H 9H TH JH")) == Result.WIN));
        System.out.println("33 - " + (new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("7C 8S 9H TH JH")) == Result.WIN));
        System.out.println("34 - " + (new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("TS TH TD JH JD")) == Result.WIN));
        System.out.println("35 - " + (new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("JH JD TH TC 4C")) == Result.WIN));
        System.out.println("36 - " + (new PokerHand("JH JC JS JD TH").compareWith(new PokerHand("4H 5H 9H TH JH")) == Result.WIN));
        System.out.println("37 - " + (new PokerHand("JH JC JS JD TH").compareWith(new PokerHand("7C 8S 9H TH JH")) == Result.WIN));
        System.out.println("38 - " + (new PokerHand("JH JC JS JD TH").compareWith(new PokerHand("TS TH TD JH JD")) == Result.WIN));
        System.out.println("39 - " + (new PokerHand("JH JC JS JD TH").compareWith(new PokerHand("JH JD TH TC 4C")) == Result.WIN));
        System.out.println("40 - " + (new PokerHand("4H 5H 9H TH JH").compareWith(new PokerHand("7C 8S 9H TH JH")) == Result.WIN));
        System.out.println("41 - " + (new PokerHand("4H 5H 9H TH JH").compareWith(new PokerHand("TS TH TD JH JD")) == Result.LOSS));
        System.out.println("42 - " + (new PokerHand("4H 5H 9H TH JH").compareWith(new PokerHand("JH JD TH TC 4C")) == Result.WIN));
        System.out.println("43 - " + (new PokerHand("7C 8S 9H TH JH").compareWith(new PokerHand("TS TH TD JH JD")) == Result.LOSS));
        System.out.println("44 - " + (new PokerHand("7C 8S 9H TH JH").compareWith(new PokerHand("JH JD TH TC 4C")) == Result.WIN));
        System.out.println("45 - " + (new PokerHand("TS TH TD JH JD").compareWith(new PokerHand("JH JD TH TC 4C")) == Result.WIN));
    }
}

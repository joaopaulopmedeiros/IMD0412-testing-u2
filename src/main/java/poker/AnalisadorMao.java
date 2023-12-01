package poker;

import java.util.List;
import java.util.stream.IntStream;

public class AnalisadorMao {

    /**
     * Royal Straight Flush: Sequência de 10 ao Ás (10-J-Q-K-A) sendo todas do mesmo naipe
     * @param cartList
     * @return
     */
    public boolean isRoyalStraightFlush(List<Carta> cartList) {
        return containsSequence(cartList, new int[]{10,11,12,13,1}) && hasOnlyOneNaipe(cartList);
    }

    /**
     * Straight Flush: Sequência de 5 cartas todas do mesmo naipe
     * @param cartList
     * @return
     */
    public boolean isStraightFlush(List<Carta> cartList) {
        return isSequence(cartList) && hasOnlyOneNaipe(cartList);
    }

    /**
     * Quadra (Four of a kind): 4 cartas com mesmo valor
     * @param cartas
     * @return
     */
    public boolean isFourOfKind(List<Carta> cartList) {
        return cartList.stream()
                .mapToInt(c -> c.getValor())
                .distinct()
                .count() == 2;
    }

    /**
     * Full House: Um par (One pair )e Trinca (Three of a kind ) ao mesmo tempo
     * @param cartas
     * @return
     */
    public boolean isFullHouse(List<Carta> cartas) {
        return isOnePair(cartas) && isThreeOfKind(cartas);
    }

    /**
     * Trinca (Three of a kind): 3 cartas com mesmo valor
     * @param cartas
     * @return
     */
    public boolean isThreeOfKind(List<Carta> cartas) {
        return cartas.stream()
                .mapToInt(c -> c.getValor())
                .distinct()
                .count() == 3;
    }

    /**
     * Dois pares (Two Pairs): 2 cartas com um mesmo valor, e outras 2 cartas com outro
mesmo valor
     * @param cartas
     * @return
     */
    public boolean isTwoPairs(List<Carta> cartas) {
        return cartas.stream()
                .mapToInt(c -> c.getValor())
                .distinct()
                .count() == 3;
    }

    /**
     * Um par (One Pair): 2 cartas com o mesmo valoR
     * @param cartas
     * @return
     */
    public boolean isOnePair(List<Carta> cartas) {
        return cartas.stream()
                .mapToInt(c -> c.getValor())
                .distinct()
                .count() == 4;
    }

    boolean isSequence(List<Carta> cartList) {
        int[] values = cartList.stream()
                .mapToInt(c -> c.getValor())
                .toArray();

        return IntStream.range(0, values.length - 1)
                .allMatch(i -> values[i] + 1 == values[i + 1]);
    }

    public static boolean containsSequence(List<Carta> cartList, int[] sequence) {
        int[] values = cartList.stream()
                .mapToInt(c -> c.getValor())
                .toArray();

        return IntStream.range(0, values.length - sequence.length + 1)
                .anyMatch(i -> IntStream.range(0, sequence.length)
                        .allMatch(j -> values[i + j] == sequence[j]));
    }

    private boolean hasOnlyOneNaipe(List<Carta> cartas) {
        return cartas.stream().map(c -> c.getNaipe()).distinct().count() == 1;
    }

    /**
     * 5 cartas do mesmo naipe e que não formam uma sequência
     * @param cartas
     * @return
     */
    public boolean isFlush(List<Carta> cartas) {
        return hasOnlyOneNaipe(cartas) && !isSequence(cartas);
    }

}

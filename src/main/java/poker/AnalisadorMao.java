package poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnalisadorMao {

    /**
     * Royal Straight Flush: Sequência de 10 ao Ás (10-J-Q-K-A) sendo todas do mesmo
     * naipe
     * 
     * @param cartList
     * @return
     */
    public boolean isRoyalStraightFlush(List<Carta> cartList) {
        return containsSequence(cartList, new int[] { 10, 11, 12, 13, 1 }) && hasOnlyOneNaipe(cartList);
    }

    /**
     * Straight Flush: Sequência de 5 cartas todas do mesmo naipe
     * 
     * @param cartList
     * @return
     */
    public boolean isStraightFlush(List<Carta> cartList) {
        return isSequence(cartList) && hasOnlyOneNaipe(cartList);
    }

    /**
     * Quadra (Four of a kind): 4 cartas com mesmo valor
     * 
     * @param cartas
     * @return
     */
    public boolean isFourOfKind(List<Carta> cartList) {
        return occurs(cartList, 4);
    }

    /**
     * Full House: Um par (One pair ) e Trinca (Three of a kind ) ao mesmo tempo
     * 
     * @param cartas
     * @return
     */
    public boolean isFullHouse(List<Carta> cartList) {
        Map<Integer, Integer> valueCountMap = new HashMap<>();

        for (Carta cart : cartList) {
            int value = cart.getValor();
            valueCountMap.put(value, valueCountMap.getOrDefault(value, 0) + 1);
        }

        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int count : valueCountMap.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }

        return hasThreeOfAKind && hasPair;
    }

    /**
     * 5 cartas do mesmo naipe e que não formam uma sequência
     * 
     * @param cartas
     * @return
     */
    public boolean isFlush(List<Carta> cartas) {
        return hasOnlyOneNaipe(cartas) && !isSequence(cartas);
    }

    /**
     * 5 cartas que formam uma sequência, mas que não são todas do
mesmo naipes
     * @param cartList
     * @return
     */
    public boolean isSequence(List<Carta> cartList) {
        int[] values = cartList.stream()
                .mapToInt(c -> c.getValor())
                .toArray();

        return IntStream.range(0, values.length - 1)
                .allMatch(i -> values[i] + 1 == values[i + 1]);
    }

    /**
     * Trinca (Three of a kind): 3 cartas com mesmo valor
     * 
     * @param cartas
     * @return
     */
    public boolean isThreeOfKind(List<Carta> cartList) {
        return occurs(cartList, 3);
    }

    /**
     * Dois pares (Two Pairs): 2 cartas com um mesmo valor, e outras 2 cartas com
     * outro
     * mesmo valor
     * 
     * @param cartas
     * @return
     */
    public boolean isTwoPairs(List<Carta> cartList) {
        Map<Integer, Long> valueCountMap = cartList.stream()
                .collect(Collectors.groupingBy(c -> c.getValor(), Collectors.counting()));
        return valueCountMap.values().stream().filter(v -> v == 2).count() == 2;
    }

    /**
     * Um par (One Pair): 2 cartas com o mesmo valoR
     * 
     * @param cartas
     * @return
     */
    public boolean isOnePair(List<Carta> cartList) {
        return occurs(cartList, 2);
    }

    /**
     * Verifica se uma lista de cartas contém uma sequência de valores
     * @param cartList
     * @param sequence
     * @return
     */
    public static boolean containsSequence(List<Carta> cartList, int[] sequence) {
        int[] values = cartList.stream()
                .mapToInt(c -> c.getValor())
                .toArray();

        return IntStream.range(0, values.length - sequence.length + 1)
                .anyMatch(i -> IntStream.range(0, sequence.length)
                        .allMatch(j -> values[i + j] == sequence[j]));
    }


    /**
     * Verifica se há apenas um naipe em uma lista de cartas
     * @param cartas
     * @return
     */
    private boolean hasOnlyOneNaipe(List<Carta> cartas) {
        return cartas.stream().map(c -> c.getNaipe()).distinct().count() == 1;
    }

    /**
     * Verifica se uma lista de cartas possui um certo número de ocorrências em cartas.
     * Útil para verificar se há pares, trincas, quadras, etc.
     * @param cartList
     * @param numberOfOccurences
     * @return
     */
    private boolean occurs(List<Carta> cartList, long numberOfOccurences) {
        Map<Integer, Long> valueCountMap = cartList.stream()
                .collect(Collectors.groupingBy(c -> c.getValor(), Collectors.counting()));
        return valueCountMap.containsValue(numberOfOccurences);
    }

}

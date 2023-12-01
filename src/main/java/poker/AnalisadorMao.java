package poker;

import java.util.List;
import java.util.stream.IntStream;

public class AnalisadorMao {

    public boolean isRoyalStraightFlush(List<Carta> cartList) {
        return containsSequence(cartList, new int[]{10,11,12,13,1}) && hasOnlyOneNaipe(cartList);
    }

    public boolean isStraightFlush(List<Carta> cartList) {
        return isSequence(cartList) && hasOnlyOneNaipe(cartList);
    }

    private boolean isSequence(List<Carta> cartList) {
        int[] values = cartList.stream()
                .mapToInt(c -> c.getValor())
                .toArray();

        return IntStream.range(0, values.length - 1)
                .allMatch(i -> values[i] + 1 == values[i + 1]);
    }

    private static boolean containsSequence(List<Carta> cartList, int[] sequence) {
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

}

package poker.builders;

import poker.Carta;
import poker.Naipe;

public class CartaBuilder {
    private Naipe naipe;
    private Integer valor;

    private CartaBuilder() {
    }

    public static CartaBuilder carta() {
        return new CartaBuilder();
    }

    public CartaBuilder withNaipe(Naipe naipe) {
        this.naipe = naipe;
        return this;
    }

    public CartaBuilder withValor(Integer valor) {
        this.valor = valor;
        return this;
    }

    public Carta build() {
        return new Carta(valor, naipe);
    }
}

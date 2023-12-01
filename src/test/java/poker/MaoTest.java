package poker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static poker.builders.CartaBuilder.carta;

public class MaoTest {

	@Test
	public void test() {
		//arrange
		List<Carta> cartas = new ArrayList<Carta>();
		
		cartas.add(carta().withNaipe(Naipe.PAUS).withValor(1).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.SEQUENCIA, ranking);
	}

}

package poker;

import static poker.builders.CartaBuilder.carta;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MaoTest {
	@Test
	public void testarRoyalStraightFlush()
	{
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(10).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(11).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(12).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(13).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.ROYAL_STRAIGHT_FLUSH, ranking);
	}

	@Test
	public void testarStraightFlush()
	{
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(3).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(4).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(5).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.STRAIGHT_FLUSH, ranking);
	}

	@Test
	public void testarQuadra() {
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.ESPADAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.OUROS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.PAUS).build());
		cartas.add(carta().withValor(5).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.QUADRA, ranking);
	}

	@Test
	public void testarFullHouse() {
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.ESPADAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.OUROS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.PAUS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.FULL_HOUSE, ranking);
	}

	@Test
	public void testarFlush()
	{
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(3).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(5).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(7).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(9).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);

		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.FLUSH, ranking);
	}

	@Test
	public void testarSequencia() {
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.ESPADAS).build());
		cartas.add(carta().withValor(3).withNaipe(Naipe.OUROS).build());
		cartas.add(carta().withValor(4).withNaipe(Naipe.PAUS).build());
		cartas.add(carta().withValor(5).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.SEQUENCIA, ranking);
	}

	@Test
	public void testarTrinca() {
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.ESPADAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.OUROS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.PAUS).build());
		cartas.add(carta().withValor(3).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.TRINCA, ranking);
	}

	@Test
	public void testarDoisPares() {
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.ESPADAS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.OUROS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.PAUS).build());
		cartas.add(carta().withValor(3).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.DOIS_PARES, ranking);
	}

	@Test
	public void testarUmPar() {
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(1).withNaipe(Naipe.ESPADAS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.OUROS).build());
		cartas.add(carta().withValor(3).withNaipe(Naipe.PAUS).build());
		cartas.add(carta().withValor(4).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.UM_PAR, ranking);
	}

	@Test
	public void testarMaoSemJogoValido()
	{
		//arrange
		List<Carta> cartas = new ArrayList<>();

		cartas.add(carta().withValor(1).withNaipe(Naipe.COPAS).build());
		cartas.add(carta().withValor(2).withNaipe(Naipe.ESPADAS).build());
		cartas.add(carta().withValor(3).withNaipe(Naipe.OUROS).build());
		cartas.add(carta().withValor(4).withNaipe(Naipe.PAUS).build());
		cartas.add(carta().withValor(6).withNaipe(Naipe.COPAS).build());

		Mao mao = new Mao(cartas);
		
		//act
		RankingMao ranking = mao.ranking();

		//assert
		assertEquals(RankingMao.NADA, ranking);
	}
}

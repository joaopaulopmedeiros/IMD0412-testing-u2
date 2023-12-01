package poker;

import java.util.List;

/**
 * 
 */
public class Mao {
	private List<Carta> cartas;
	private AnalisadorMao analisador;

	public Mao(List<Carta> cartas) {
		this.setCartas(cartas);
		this.analisador = new AnalisadorMao();
	}

	public RankingMao ranking() {
		if (this.analisador.isRoyalStraightFlush(this.cartas)) {
			return RankingMao.ROYAL_STRAIGHT_FLUSH;
		}

		if (this.analisador.isStraightFlush(this.cartas)) {
			return RankingMao.STRAIGHT_FLUSH;
		}

		if (this.analisador.isFourOfKind(this.cartas)) {
			return RankingMao.QUADRA;
		}

		if (this.analisador.isFullHouse(this.cartas)) {
			return RankingMao.FULL_HOUSE;
		}

		if (this.analisador.isFlush(this.cartas)) {
			return RankingMao.FLUSH;
		}

		if (this.analisador.isThreeOfKind(this.cartas)) {
			return RankingMao.TRINCA;
		}

		if (this.analisador.isSequence(this.cartas)) {
			return RankingMao.SEQUENCIA;
		}

		if (this.analisador.isTwoPairs(this.cartas)) {
			return RankingMao.DOIS_PARES;
		}

		if (this.analisador.isOnePair(this.cartas)) {
			return RankingMao.UM_PAR;
		}

		return RankingMao.NADA;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
}

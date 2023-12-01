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

		return RankingMao.SEQUENCIA;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
}

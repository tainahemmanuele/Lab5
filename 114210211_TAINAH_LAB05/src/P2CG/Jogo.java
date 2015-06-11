/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.HashSet;

import P2CG.Exceptions.JogoException;

/**
 * Classe criada para criar o jogo. Possui o construtor de jogo. Possui um
 * metodo que permite que o jogo criado seja jogado.
 * 
 * @author tainahemmanuele
 *
 */

public abstract class Jogo {
	private String nome;
	private double preco;
	private int score;
	private int vezesJogadas;
	private int zeraJogo;
	private HashSet<EstiloJogos> jogabilidade;
	private int pontos;

	/**
	 * Construtor usado para criar um jogo
	 * 
	 * @param nome
	 *            , nome do jogo
	 * @param preco
	 *            , preco do jogo
	 * @throws JogoException
	 *             , a excecao sera lan�ada caso o nome do jogo seja vazio ou
	 *             o preco do jogo seja negativo.
	 */
	public Jogo(String nome, double preco) throws JogoException {
		if (nome.equals("")) {
			throw new JogoException("Nome do jogo nao pode ser vazio");
		}
		if (preco < 0) {
			throw new JogoException("Preco do jogo nao pode ser negativo");
		}

		this.nome = nome;
		this.preco = preco;
		this.score = 0;
		this.vezesJogadas = 0;
		this.zeraJogo = 0;
		this.jogabilidade = new HashSet<EstiloJogos>();
		this.pontos = 0;
	}

	/**
	 * Metodo criado para jogar um jogo
	 * 
	 * @param score
	 *            , valor do score
	 * @param jogozerado
	 *            , boolean que indica se o jogador zerou o jogo ou nao
	 */
	public void joga(int score, boolean jogozerado) {
		this.vezesJogadas += 1;
		if (jogozerado == true) {
			this.zeraJogo += 1;

		}
		if (score > this.score) {
			this.score = score;
		}
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getVezesjogadas() {
		return vezesJogadas;
	}

	public void setVezesjogadas(int vezesJogadas) {
		this.vezesJogadas = vezesJogadas;
	}

	public int getZerajogo() {
		return zeraJogo;
	}

	public void setZerajogo(int zerajogo) {
		this.zeraJogo = zerajogo;
	}

	public HashSet<EstiloJogos> getJogabilidade() {
		return jogabilidade;
	}

	public void setJogabilidade(HashSet<EstiloJogos> jogabilidade) {
		this.jogabilidade = jogabilidade;
	}

	public int getPontos() {
		return pontos;
	}

	public int setPontos(int pontos) {
		return this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "Jogo [getNome()=" + getNome() + ", getPreco()=" + getPreco()
				+ ", getScore()=" + getScore() + ", getVezesjogadas()="
				+ getVezesjogadas() + ", getZerajogo()=" + getZerajogo()
				+ ", getJogabilidade()=" + getJogabilidade() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Equals criado para indicar que dois jogos sao iguais quando tiverem o
	 * mesmo nome e preco.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo) {

			Jogo jogo = (Jogo) obj;
			if (jogo.getNome().equals(this.getNome())
					&& jogo.getPreco() == this.getPreco()) {
				return true;

			} else {

				return false;
			}
		}
		return false;
	}
}

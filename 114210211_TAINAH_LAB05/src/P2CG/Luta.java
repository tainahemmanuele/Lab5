/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import P2CG.Exceptions.JogoException;

/**
 * Classe herdada de jogo. Cria jogo do tipo luta.
 * 
 * @author tainahemmanuele
 *
 */
public class Luta extends Jogo {

	public Luta(String nome, double preco) throws JogoException {
		super(nome, preco);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo criado para jogar um jogo. Sobrescreve o metodo de mesmo nome da
	 * classe Jogo. Porem , possui condicao propria para dar pontos a usuarios
	 * que jogam o jogo. Nesse caso, enquanto o score do usuario for menor que
	 * 100000 no jogo de luta, o mesmo ganha uma pontuacao baseada no score.
	 * Esses pontos sao adicionados aos pontos totais do usuario.
	 */
	public void joga(int score, boolean zerajogo) {
		super.joga(score, zerajogo);
		if (score <= 100000) {
			if ((score % 1000) == 0) {
				setPontos(score / 1000);
			}
		}
	}

}

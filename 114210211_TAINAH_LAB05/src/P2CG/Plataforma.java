/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import P2CG.Exceptions.JogoException;

/**
 * Classe herdada de jogo. Cria jogo do tipo plataforma.
 * 
 * @author tainahemmanuele
 *
 */
public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco) throws JogoException {
		super(nome, preco);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo criado para jogar um jogo. Sobrescreve o metodo de mesmo nome da
	 * classe Jogo. Porem , possui condicao propria para dar pontos a usuarios
	 * que jogam o jogo. Nesse caso, cada vez que o usuario zera o jogo, e
	 * adicionado 20 pontos aos pontos totais do usuario.
	 */
	public void joga(int score, boolean jogozerado) {
		super.joga(score, jogozerado);
		if (jogozerado == true) {
			setPontos(20);
		} else {
			setPontos(0);
		}

	}
}

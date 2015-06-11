/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import P2CG.Exceptions.JogoException;

/**
 * Classe herdada de jogo. Cria jogo do tipo RPG.
 * 
 * @author tainahemmanuele
 *
 */
public class RPG extends Jogo {

	public RPG(String nome, double preco) throws JogoException {

		super(nome, preco);
		// TODO Auto-generated constructor stub

	}

	/**
	 * Metodo criado para jogar um jogo. Sobrescreve o metodo de mesmo nome da
	 * classe Jogo. Porem , possui condicao propria para dar pontos a usuarios
	 * que jogam o jogo. Nesse caso, cada vez que o usuario jogou o jogo e
	 * multiplicado por dez e esse valor e adicionado aos pontos totais do
	 * usuario.
	 */
	public void joga(int score, boolean zerajogo) {
		super.joga(score, zerajogo);
		setPontos(getVezesjogadas() * 10);
	}

}

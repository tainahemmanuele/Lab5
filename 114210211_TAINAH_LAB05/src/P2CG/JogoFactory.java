/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.HashSet;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;

/**
 * Classe criada para auxliar a classe Loja a cria um jogo. Cria os jogos de
 * acordo com o tipo (RPG,Luta ou Plataforma).
 * 
 * @author tainahemmanuele
 *
 */
public class JogoFactory {

	/**
	 * Metodo criado para criar um jogo do tipo RPG
	 * 
	 * @param nome
	 *            , nome do jogo
	 * @param preco
	 *            , preco do jogo
	 * @param jogabilidade
	 *            , lista com as jogabilidade
	 * @return, retorna o jogo criado
	 * @throws JogoException
	 *             a excecao sera lancada caso o nome do jogo seja vazio ou o
	 *             preco do jogo seja negativo.
	 */
	public Jogo criaJogoRPG(String nome, double preco,
			HashSet<EstiloJogos> jogabilidade) throws JogoException {

		Jogo rpg = new RPG(nome, preco);
		rpg.setJogabilidade(jogabilidade);
		return rpg;

	}

	/**
	 * Metodo criado para criar um jogo do tipo Plataforma
	 * 
	 * @param nome
	 *            , nome do jogo
	 * @param preco
	 *            , preco do jogo
	 * @param jogabilidade
	 *            , lista com as jogabilidade
	 * @return, retorna o jogo criado
	 * @throws JogoException
	 *             a excecao sera lancada caso o nome do jogo seja vazio ou o
	 *             preco do jogo seja negativo.
	 */
	public Jogo criaJogoPlataforma(String nome, double preco,
			HashSet<EstiloJogos> jogabilidade) throws JogoException {
		Jogo plataforma = new Plataforma(nome, preco);
		plataforma.setJogabilidade(jogabilidade);
		return plataforma;

	}

	/**
	 * Metodo criado para criar um jogo do tipo Luta
	 * 
	 * @param nome
	 *            , nome do jogo
	 * @param preco
	 *            , preco do jogo
	 * @param jogabilidade
	 *            , lista com as jogabilidade
	 * @return, retorna o jogo criado
	 * @throws JogoException
	 *             ,a excecao sera lancada caso o nome do jogo seja vazio ou o
	 *             preco do jogo seja negativo.
	 */
	public Jogo criaJogoLuta(String nome, double preco,
			HashSet<EstiloJogos> jogabilidade) throws JogoException {
		Jogo luta = new Luta(nome, preco);
		luta.setJogabilidade(jogabilidade);
		return luta;

	}

	/**
	 * Metodo criado para criar um jogo
	 * 
	 * @param nome
	 *            , nome do jogo
	 * @param preco
	 *            , preco do jogo
	 * @param tipo
	 *            , tipo do jogo. A partir desse tipoque o metodo chamar o
	 *            metodo especifico da criacao de cada tipo de jogo.
	 * @param jogabilidade
	 *            , lista de jogabilidades
	 * @return , retorna o jogo criado
	 * @throws JogoException
	 *             ,JogoException a excecao sera lancada caso o nome do jogo
	 *             seja vazio ou o preco do jogo seja negativo.
	 */
	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<EstiloJogos> jogabilidade) throws JogoException {
		if (tipo.equals("RPG")) {
			Jogo jogo = criaJogoRPG(nome, preco, jogabilidade);
			return jogo;
		} else if (tipo.equals("Luta")) {
			Jogo jogo = criaJogoLuta(nome, preco, jogabilidade);
			return jogo;
		} else if (tipo.equals("Plataforma")) {
			Jogo jogo = criaJogoPlataforma(nome, preco, jogabilidade);
			return jogo;
		}
		return null;
	}
}

/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.UsuarioException;

/**
 * Classe herdada de usuario. Cria usuario do tipo noob.
 * 
 * @author tainahemmanuele
 *
 */
public class Noob extends Usuario {

	/**
	 * Construtor usado para criar um usuario do tipo Noob
	 * 
	 * @param nome
	 *            , nome do usuario
	 * @param login
	 *            , login do usuario
	 * @param dinheiro
	 *            , dinheiro do usuario
	 * @throws CriacaoUsuarioException
	 *             , excecao lan�ada caso o nome do usuario seja vazio, o
	 *             login do usuario seja vazio ou o dinheiro do usuario seja
	 *             negativo.
	 */
	public Noob(String nome, String login, double dinheiro)
			throws CriacaoUsuarioException {

		super(nome, login, dinheiro);
		setDesconto(0.1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo criado para a compra do jogo. Herda da classe Usuario. Nesse
	 * metodo, e gerado os pontos do usuario pela compra do jogo; O desconto do
	 * preco do jogo e calculado; O preco do jogo com desconto e subtraido do
	 * dinheiro total do usuario; O jogo e adicionado na lista de jogos do
	 * usuario.
	 */
	@Override
	public void compraJogo(Jogo jogo) throws UsuarioException {
		adicionaPontos(jogo.getPreco());
		subtraiDinheiro(jogo.getPreco() - (getDesconto() * jogo.getPreco()));
		add(jogo);

	}

	/**
	 * Metodo criado para recompensar usuario com pontos, de acordo com as
	 * jogabilidades dos jogos que o mesmo jogou. Os pontos sao adicionados ao
	 * total de pontos do usuario.
	 */
	@Override
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) {
		for (Jogo jogo : getJogos()) {
			if (jogo.getNome().equals(nomeJogo)) {
				jogo.joga(scoreObtido, zerou);
				setPontos(jogo.getPontos());
			}
			if (jogo.getNome().equals(nomeJogo)) {
				if (jogo.getJogabilidade().contains(EstiloJogos.OFFLINE)) {
					setPontos(30);
				}
				if (jogo.getJogabilidade().contains(EstiloJogos.MULTIPLAYER)) {
					setPontos(10);

				}
			}
		}

	}

	/**
	 * Metodo criado para punir usuario com pontos, de acordo com as
	 * jogabilidades do jogos que o mesmo jogou. Os pontos sao subtraidos do
	 * total de pontos do usuario.
	 */
	@Override
	public int punir(String nomeJogo, int scoreObtido, boolean zerou) {
		for (Jogo jogo : getJogos()) {
			if (jogo.getNome().equals(nomeJogo)) {
				jogo.joga(scoreObtido, zerou);
				setPontos(jogo.getPontos());
			}
			if (jogo.getNome().equals(nomeJogo)) {
				if (jogo.getJogabilidade().contains(EstiloJogos.ONLINE)) {
					setPontos(-10);
				}
				if (jogo.getJogabilidade().contains(EstiloJogos.COMPETITIVO)) {
					setPontos(-20);
				}
				if (jogo.getJogabilidade().contains(EstiloJogos.COOPERATIVO)) {
					setPontos(-50);
				}
				return getPontos();
			}
		}
		return (Integer) null;

	}

}

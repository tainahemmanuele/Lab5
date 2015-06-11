/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import java.util.ArrayList;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.SaldoException;
import P2CG.Exceptions.UsuarioException;

/**
 * Classe criada para criar o usuario.Possui o construtor do Jogo. Possui
 * metodos que permite que o usuario jogue o jogo comprado na loja, que adiciona
 * pontos ao usuario conforme o tipo de jogo que o mesmo jogou, que subtrai
 * pontos do usuario conforme o tipo de jogo que o mesmo jogou.
 * 
 * @author tainahemmanuele
 *
 */
public abstract class Usuario {
	private String nome;
	private String login;
	protected ArrayList<Jogo> jogos;
	private double dinheiro;
	private double desconto;
	private double dinheiroDesconto;
	private int pontos;

	/**
	 * Construtor usado para criar um usuario
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

	public Usuario(String nome, String login, double dinheiro)
			throws CriacaoUsuarioException {
		if (nome.equals("")) {
			throw new CriacaoUsuarioException(
					"Nome do usuario nao pode ser vazio");
		}
		if (login.equals("")) {
			throw new CriacaoUsuarioException(
					"Login do usuario nao pode ser vazio");
		}
		if (dinheiro < 0) {
			throw new CriacaoUsuarioException(
					"Dinheiro do usuario nao pode ser negativo");
		}

		this.nome = nome;
		this.login = login;
		this.jogos = new ArrayList<Jogo>();
		this.dinheiro = dinheiro;
		this.desconto = 0;
		this.pontos = 0;

	}

	/**
	 * Metodo que permite que adicione mais dinheiro ao usuario
	 * 
	 * @param dinheiro
	 *            , dinheiro do usuario
	 */
	public void adicionaDinheiro(double dinheiro) {
		this.dinheiro += dinheiro;
	}

	/**
	 * Metodo que permite a adicao de pontos ao usuario a partir do preco do
	 * jogo.
	 * 
	 * @param preco
	 *            , preco do jogo.
	 * @return, quantidade de pontos.
	 */
	public int adicionaPontos(double preco) {
		this.pontos += (preco * 10);
		return this.pontos;
	}

	/**
	 * Metodo criado para subtrair do dinheiro do usuario o valor do jogo
	 * comprado (com desconto a partir do tipo de usuario) Esse metodo e chamado
	 * dentro do metodo compraJogo
	 * 
	 * @param dinheiro
	 *            , dinheiro do usuario
	 * @return , retorna o total que o usuario gastou com desconto nos jogos
	 * @throws UsuarioException
	 *             , excecao lancada caso o dinheiro do usuario seja menor que o
	 *             valor do jogo
	 */
	public double subtraiDinheiro(double preco) throws UsuarioException {
		if (this.dinheiro < preco) {
			throw new SaldoException("Saldo insuficiente");
		} else {
			dinheiroDesconto += preco;
			this.dinheiro -= preco;
			return dinheiroDesconto;
		}
	}

	/**
	 * Metodo criado para a compra do jogo. E do tipo abstrato. Cada classe que
	 * herda Usuario(Noob e Veterano)possuem suas proprias condicoes de
	 * manipulacao dos argumentos
	 * 
	 * @param jogo
	 *            , jogo criado
	 * @throws UsuarioException
	 *             , excecao lancada caso o dinheiro do usuario seja menor que o
	 *             valor do jogo
	 */
	public abstract void compraJogo(Jogo jogo) throws UsuarioException;

	/**
	 * Metodo criado para recompensar o usuario de acordo com as jogabilidades
	 * dos jogos que ele jogou . E do tipo abstrato. Cada classe que herda
	 * Usuario(Noob e Veterano)possuem suas proprias condicoes de manipulacao
	 * dos argumentos
	 * 
	 * @param nomeJogo
	 *            , nome do jogo que o usuario jogou e deve ser recompensado por
	 *            isso
	 * @param scoreObtido
	 *            , o score obtido no jogo
	 * @param zerou
	 *            , se o uzuario zerou ou nao o jogo
	 */
	public abstract void recompensar(String nomeJogo, int scoreObtido,
			boolean zerou);

	/**
	 * Metodo criado para punir o usuario de acordo com as jogabilidades dos
	 * jogos que ele jogou . E do tipo abstrato. Cada classe que herda
	 * Usuario(Noob e Veterano)possuem suas proprias condicoes de manipulacao
	 * dos argumentos
	 * 
	 * @param nomeJogo
	 *            , nome do jogo que o usuario jogou e deve ser punido por isso
	 * @param scoreObtido
	 *            , o score obtido no jogo
	 * @param zerou
	 *            , se o uzuario zerou ou nao o jogo
	 */
	public abstract int punir(String nomeJogo, int scoreObtido, boolean zerou);

	/**
	 * Metodo que adiciona o jogo criado e comprado pelo usuario na sua lista de
	 * jogos.
	 * 
	 * @param jogo
	 *            , jogo que foi comprado pelo usuario.
	 */
	public void add(Jogo jogo) {
		jogos.add(jogo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
	}

	public int getPontos() {
		return pontos;
	}

	public int setPontos(int pontos) {
		return this.pontos += pontos;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public double getDinheiroDesconto() {
		return dinheiroDesconto;
	}

	public void setDinheiroDesconto(double dinheiroDesconto) {
		this.dinheiroDesconto += dinheiroDesconto;
	}

	@Override
	public String toString() {
		return "Usuario [getDesconto()=" + getDesconto() + ", getDinheiro()="
				+ getDinheiro() + ", getAdiciona()=" + getPontos()
				+ ", getDinheiroDesconto()=" + getDinheiroDesconto()
				+ ", getNome()=" + getNome() + ", getLogin()=" + getLogin()
				+ ", getJogos()=" + getJogos() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Equals criado para indicar que dois usuarios s�o iguais quando tiverem
	 * o mesmo nome e login.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {

			Usuario usuario = (Usuario) obj;
			if (usuario.getNome().equals(this.getNome())
					&& usuario.getLogin() == this.getLogin()) {
				return true;

			} else {

				return false;
			}
		}
		return false;
	}

}

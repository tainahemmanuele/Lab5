/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.DowngradeException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UpgradeException;
import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.UsuarioInvalidoException;

/**
 * Classe criada para auxuliar no funcionamento da loja de jogos. Possui metodo
 * que auxiliam na criaco de jogos e usuarios alem de fazer o upgrade e o
 * downgrade dos usuarios. A partir dos metodos da loja, que metodos das classes
 * Jogo, JogoFactory e Usuario sao chamados.
 * 
 * @author tainahemmanuele
 *
 */

public class Loja {
	private ArrayList<Usuario> usuarios;
	private String nomeJogo;
	private double preco;
	private String tipo;
	private String tipoUsuario;
	private double dinheiro;
	private double valorTotal;
	private JogoFactory fabricaJogos;
	private Jogo jogo;
	private double desconto;

	/**
	 * Construtor criado para inicializar um objeto do tipo loja.
	 */
	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.fabricaJogos = new JogoFactory();
		this.desconto = 0;
		this.preco = 0;
	}

	/**
	 * Metodo utilizado para criar usuario, seja do tipo Noob, seja do tipo
	 * Veterano. Esse metodo chama as classes correspondentes ao tipo do usuario
	 * Depois de criar o usuario, o adiciona em uma lista que deve ter todos os
	 * usuarios criados na loja sejam de qualquer tipo
	 * 
	 * @param nome
	 *            , nome do usuario
	 * @param login
	 *            , nome de login do usuario
	 * @param dinheiro
	 *            , dinheiro do usuario
	 * @param tipoUsuario
	 *            , tipo de usuario que deve ser criado. A partir desse atributo
	 *            que as classes correspondentes aos tipos de usuario sao
	 *            chamadas.
	 * @return, retorna um tipo Usuario.
	 * @throws UsuarioInvalidoException
	 *             , essa excecao e lancada caso tente criar um usuario
	 *             diferente dos tipos veterano e noob.
	 */
	public Usuario criaUsuario(String nome, String login, double dinheiro,
			String tipoUsuario) throws UsuarioInvalidoException {
		try {
			if (tipoUsuario.equals("Noob")) {
				Usuario usuario = new Noob(nome, login, dinheiro);
				usuarios.add(usuario);
				return usuario;
			} else if (tipoUsuario.equals("Veterano")) {
				Usuario usuario = new Veterano(nome, login, dinheiro);
				usuarios.add(usuario);
				return usuario;
			} else if (!tipoUsuario.equals("Noob")
					|| tipoUsuario.equals("Veterano")) {
				throw new UsuarioInvalidoException("Tipo de usuario invalido");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	/**
	 * Metodo usado para criar o jogo. Esse metodo chama a classe JogoFactory
	 * que contem todos os metodos para a criacao de jogos.
	 * 
	 * @param nome
	 *            , nome do jogo a ser criado
	 * @param preco
	 *            , preco do jogo a ser criado
	 * @param tipo
	 *            , tipo de jogo. A partir desse atributo que as classes
	 *            correspondentes aos tipos de jogos sao chamadas.
	 * @param jogabilidade
	 *            , lista que contem as jogabilidades do jogo
	 * @return, retorna um objeto do tipo jogo.
	 */
	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<EstiloJogos> jogabilidade) {
		try {
			this.jogo = fabricaJogos.criaJogo(nome, preco, tipo, jogabilidade);
			this.preco = preco;
		} catch (JogoException e) {
			System.out.println(e.getMessage());
		}

		return jogo;

	}

	/**
	 * Metodo criado para adicionar um jogo a lista de jogos do usuario. O jogo
	 * so e adicionado se o preco dele for menor que a quantidade total de
	 * dinheiro do usuario
	 * 
	 * @param nome
	 *            , nome do jogo a ser adicionado ao usuario.
	 * @param usuario
	 *            , recebe um objeto do tipo usuario, o usuario que quer comprar
	 *            o jogo.
	 */
	public void adicionaJogo(String nome, Usuario usuario) {
		if (preco < usuario.getDinheiro()) {
			valorTotal += preco;
			try {
				usuario.compraJogo(jogo);
			} catch (UsuarioException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Adiciona mais dinheiro a um usuario.
	 * 
	 * @param dinheiro
	 *            , quantidade de dinheiro a ser adicionada.
	 * @param usuario
	 *            , recebe um objeto do tipo usuario,o usuario que deve ser
	 *            adicionado o dinheiro.
	 */
	public void adicionaDinheiro(double dinheiro, Usuario usuario) {
		usuario.adicionaDinheiro(dinheiro);
	}

	/**
	 * Metodo usado para tranformar um usuario do tipo Noob em Veterano conforme
	 * condicao: possuir mais de 1000 pontos totais acumulados ou mais
	 * 
	 * @param login
	 *            , login do usuario que deve ser feito o upgrade
	 * @return, retorna um objeto do tipo usuario , com as mesmas informacoes
	 *          antes do upgrade, mas com o tipo de usuario modificado
	 * @throws UpgradeException
	 *             , excecao lancada caso se tente fazer um upgrade de um
	 *             usuario que nao possua pontos suficientes ou ja seja do tipo
	 *             veterano
	 */
	public Usuario upgrade(String login) throws UpgradeException {
		for (Usuario usuario : getUsuarios()) {
			if (usuario.getLogin().equals(login)) {
				if (usuario.getPontos() < 1000) {
					throw new UpgradeException(
							"Usuario nao possui pontos suficientes para upgrade");
				}
				if (usuario.getClass().getSimpleName().equals("Veterano")) {
					throw new UpgradeException("Usuario ja e do tipo veterano");
				}

				else {
					try {
						Usuario usuarioUpgrade = new Veterano(
								usuario.getNome(), usuario.getLogin(),
								usuario.getDinheiro());
						usuarioUpgrade.setJogos(usuario.getJogos());
						usuarioUpgrade.setPontos(usuario.getPontos());
						usuarioUpgrade.setDinheiroDesconto(usuario
								.getDinheiroDesconto());
						getUsuarios().remove(usuario);
						getUsuarios().add(usuarioUpgrade);
						return usuarioUpgrade;
					} catch (CriacaoUsuarioException e) {
						System.out.println(e.getMessage());
					}

				}
			}
		}
		return null;
	}

	/**
	 * Metodo usado para tranformar um usuario do tipo Veterano em Noob conforme
	 * condicao: possuir mmenos de 1000 pontos totais acumulados.
	 * 
	 * @param login
	 *            , login do usuario que deve ser feito o downgrade
	 * @return, retorna um objeto do tipo usuario , com as mesmas informacoes
	 *          antes do downgrade, mas com o tipo de usuario modificado
	 * @throws UpgradeException
	 *             , excecao lancada caso se tente fazer um downgrade de um
	 *             usuario que possua mais de 1000 pontos ou que ja seja do tipo
	 *             noob.
	 */
	public Usuario downgrade(String login) throws DowngradeException {
		for (Usuario usuario : getUsuarios()) {
			if (usuario.getLogin().equals(login)) {
				if (usuario.getPontos() > 1000) {
					throw new DowngradeException(
							"Usuario tem pontos maiores que 1000 ");
				}
				if (usuario.getClass().getSimpleName().equals("Noob")) {
					throw new DowngradeException("Usuario ja e do tipo noob");
				} else {
					try {
						Usuario usuarioDowngrade = new Noob(usuario.getNome(),
								usuario.getLogin(), usuario.getDinheiro());
						usuarioDowngrade.setJogos(usuario.getJogos());
						usuarioDowngrade.setPontos(usuario.getPontos());
						usuarioDowngrade.setDinheiroDesconto(usuario
								.getDinheiroDesconto());
						getUsuarios().remove(usuario);
						getUsuarios().add(usuarioDowngrade);
						return usuarioDowngrade;
					} catch (CriacaoUsuarioException e) {
						System.out.println(e.getMessage());
					}

				}
			}
		}
		return null;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void imprime() {
		System.out.println("=== Central P2-CG ===");
		System.out.println();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getNome());
			System.out.println("Jogador " + usuario.getClass().getSimpleName()
					+ ": " + usuario.getPontos() + " x2p");
			System.out.println("Lista de Jogos:");
			for (Jogo jogo : usuario.getJogos()) {
				System.out.println("+" + jogo.getNome() + " - "
						+ jogo.getClass().getSimpleName() + ":");
				System.out.println("===> Jogou " + jogo.getVezesjogadas()
						+ " vez(es)");
				System.out.println("===> Zerou " + jogo.getZerajogo()
						+ " vez(es)");
				System.out.println("===> Maior Score " + jogo.getScore());
				System.out.println();

			}
			desconto += usuario.getDinheiroDesconto();
			System.out.println(desconto);
		}
		System.out.println("Total de preco dos jogos: R$ " + valorTotal);
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("Total arrecadado com vendas de jogos:" + desconto);
	}

}

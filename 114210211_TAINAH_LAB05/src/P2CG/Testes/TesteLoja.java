/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import java.util.HashSet;

import P2CG.EstiloJogos;
import P2CG.Jogo;
import P2CG.Loja;
import P2CG.Plataforma;
import P2CG.Usuario;
import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.UsuarioInvalidoException;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteLoja {

	/**
	 * Teste criado para testar se a classe loja esta funcionando corretamente.
	 * Neste teste e testado os metodos de criar o jogo, criar o usuario e se a
	 * partir disso o usuario consegue jogar o jogo, alem de imprimir as
	 * informacoes referentes a loja.
	 */
	@Test
	public void testLojaCriacaoUsuarioeJogo() {
		try {
			Loja loja = new Loja();
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");
			HashSet<EstiloJogos> estilo = new HashSet();
			HashSet<EstiloJogos> estilo1 = new HashSet();
			HashSet<EstiloJogos> estilo2 = new HashSet();

			estilo.add(EstiloJogos.ONLINE);
			estilo.add(EstiloJogos.MULTIPLAYER);
			estilo2.add(EstiloJogos.OFFLINE);

			Jogo injustice = loja.criaJogo("Injustice", 159.99, "Luta", estilo);
			loja.adicionaJogo("Injustice", tainah);

			Jogo supermario = loja.criaJogo("Super Mario World", 30.00,
					"Plataforma", estilo2);
			loja.adicionaJogo("Super Mario World", tainah);

			loja.adicionaDinheiro(58.96, tainah);

			tainah.recompensar("Injustice", 0, false);
			tainah.recompensar("Super Mario World", 50, true);
			tainah.recompensar("Super Mario World", 150, true);

			Jogo papermario = loja.criaJogo("Paper Mario", 75.00, "RPG",
					estilo1);
			loja.adicionaJogo("Paper Mario", tainah);

			loja.imprime();
		} catch (UsuarioInvalidoException e) {
			Assert.fail();
		}
	}

	/**
	 * Teste criado para testar o comportamento da classe loja e seus metodos na
	 * criacao de varios usuarios.
	 *
	 */
	@Test
	public void testLojaCriaVariosUsuarioseJogos() {
		try {
			Loja loja = new Loja();
			HashSet<EstiloJogos> estilo = new HashSet();
			HashSet<EstiloJogos> estilo1 = new HashSet();
			HashSet<EstiloJogos> estilo2 = new HashSet();

			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 1050.00, "Veterano");
			Usuario gabriela = loja.criaUsuario("Maria Gabriela", "mgabriela",
					750.00, "Noob");
			Usuario homer = loja.criaUsuario("Homer Simpson", "homer.simpson",
					258.00, "Noob");
			Usuario lisa = loja.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");
			Usuario burns = loja.criaUsuario("Mr.Burns", "burns", 85000.00,
					"Noob");
			Usuario bart = loja.criaUsuario("Bart Simpson", "bart.simpson",
					150.00, "Veterano");

			estilo.add(EstiloJogos.COMPETITIVO);
			estilo.add(EstiloJogos.MULTIPLAYER);
			estilo.add(EstiloJogos.ONLINE);

			estilo1.add(EstiloJogos.OFFLINE);
			estilo1.add(EstiloJogos.MULTIPLAYER);

			estilo2.add(EstiloJogos.ONLINE);
			estilo2.add(EstiloJogos.COMPETITIVO);

			loja.criaJogo("Injustice", 159.99, "Luta", estilo);
			loja.adicionaJogo("Injustice", tainah);

			loja.criaJogo("Guilty", 80.00, "Luta", estilo);
			loja.adicionaJogo("Guilty", tainah);

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", tainah);

			loja.criaJogo("Injustice", 159.99, "Luta", estilo);
			loja.adicionaJogo("Injustice", gabriela);

			loja.criaJogo("Super Mario World", 30.00, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario World", gabriela);

			loja.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			loja.adicionaJogo("Paper Mario", gabriela);

			loja.criaJogo("Guilty", 80.00, "Luta", estilo);
			loja.adicionaJogo("Guilty", gabriela);

			loja.criaJogo("Mario e Luigi: Superstar Saga", 85.99, "RPG", estilo);
			loja.adicionaJogo("Mario e Luigi: Superstar Saga", gabriela);

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", gabriela);

			loja.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			loja.adicionaJogo("Paper Mario", lisa);

			loja.criaJogo("Mario e Luigi: Superstar Saga", 85.99, "RPG", estilo);
			loja.adicionaJogo("Mario e Luigi: Superstar Saga", burns);

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", burns);

			loja.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			loja.adicionaJogo("Paper Mario", burns);

			loja.criaJogo("Super Mario World", 30.00, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario World", burns);

			loja.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			loja.adicionaJogo("Paper Mario", bart);

			tainah.recompensar("Injustice", 120, true);
			tainah.recompensar("Injustice", 150, true);
			tainah.punir("Injustice", 130, false);
			tainah.recompensar("Super Mario Bros", 1500, true);

			gabriela.recompensar("Paper Mario", 1500, true);
			gabriela.recompensar("Mario e Luigi: Superstar Saga", 5, false);
			gabriela.punir("Mario e Luigi: Superstar Saga", 350, true);
			gabriela.recompensar("Mario e Luigi: Superstar Saga", 5, false);
			gabriela.punir("Injustice", 350, false);
			gabriela.punir("Super Mario World", 15089, true);
			gabriela.recompensar("Guilty", 3560, true);
			gabriela.recompensar("Super Mario Bros", 1520, true);

			lisa.recompensar("Paper Mario", 3500, true);
			lisa.recompensar("Paper Mario", 3550, true);
			lisa.punir("Paper Mario", 3500, false);
			lisa.recompensar("Paper Mario", 4589, true);

			bart.recompensar("Paper Mario", 2985, true);

			loja.imprime();
		} catch (UsuarioInvalidoException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}

	}

	/**
	 * Teste criado para saber se a classe loja captura e lanca as excecoes
	 * referentes a criacao do usuario.
	 */
	@Test
	public void testLojaCriacaoUsuarioInvalido() {
		Loja loja = new Loja();
		try {

			loja.criaUsuario("", "tainahemmanuele", 250.00, "Noob");
		} catch (UsuarioInvalidoException e) {
			Assert.assertEquals("Nome do usuario nao pode ser vazio",
					e.getMessage());
		}
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele", "", 250.00,
					"Noob");
		} catch (UsuarioInvalidoException e) {
			Assert.assertEquals("Login do usuario nao pode ser vazio",
					e.getMessage());
		}
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", -250.00, "Noob");
		} catch (UsuarioInvalidoException e) {
			Assert.assertEquals("Dinheiro do usuario nao pode ser negativo",
					e.getMessage());
		}
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "");
		} catch (UsuarioInvalidoException e) {
			Assert.assertEquals("Tipo de usuario invalido", e.getMessage());
		}
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Usuario");
		} catch (UsuarioInvalidoException e) {
			Assert.assertEquals("Tipo de usuario invalido", e.getMessage());
		}
	}

	/**
	 * Teste criado para saber se a classe loja captura e lanca as excecoes
	 * referentes a criacao do jogo.
	 */
	@Test
	public void testLojaCriacaoJogoInvalido() {
		Loja loja = new Loja();
		HashSet<EstiloJogos> estilo = new HashSet();
		estilo.add(EstiloJogos.COMPETITIVO);
		estilo.add(EstiloJogos.MULTIPLAYER);
		estilo.add(EstiloJogos.ONLINE);

		try {
			loja.criaJogo("", 159.99, "Luta", estilo);
		} catch (Exception e) {
			Assert.assertEquals("Nome do jogo nao pode ser vazio",
					e.getMessage());
		}
		try {
			loja.criaJogo("Injustice", -159.99, "Luta", estilo);
		} catch (Exception e) {
			Assert.assertEquals("Preco do jogo nao pode ser negativo",
					e.getMessage());
		}

	}

}

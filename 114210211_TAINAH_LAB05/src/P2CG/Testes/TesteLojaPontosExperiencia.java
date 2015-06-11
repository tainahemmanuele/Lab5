/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import static org.junit.Assert.*;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

import P2CG.EstiloJogos;
import P2CG.Loja;
import P2CG.Usuario;
import P2CG.Exceptions.UsuarioInvalidoException;

public class TesteLojaPontosExperiencia {

	/**
	 * Teste criado para testar se os pontos referentes a experiencia dos
	 * jogadores estao sendo computados corretamente (pontos referentes a compra
	 * do jogo).Nesse caso, referente a jogos do tipo RPG.
	 */
	@Test
	public void testPontosExperienciaRPG() {
		Loja loja = new Loja();
		HashSet<EstiloJogos> estilo = new HashSet();

		estilo.add(EstiloJogos.ONLINE);
		estilo.add(EstiloJogos.MULTIPLAYER);
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");
			Usuario lisa = loja.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");

			loja.criaJogo("Mario e Luigi: Superstar Saga", 85.99, "RPG", estilo);
			loja.adicionaJogo("Mario e Luigi: Superstar Saga", tainah);

			loja.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			loja.adicionaJogo("Paper Mario", lisa);

			Assert.assertTrue(859 == tainah.getPontos());
			Assert.assertTrue(750 == lisa.getPontos());

			tainah.recompensar("Mario e Luigi: Superstar Saga", 0, false);

			Assert.assertTrue(879 == tainah.getPontos());

			lisa.recompensar("Paper Mario", 1500, true);

			Assert.assertTrue(770 == lisa.getPontos());
		} catch (UsuarioInvalidoException e) {
			Assert.fail();
		}

	}

	/**
	 * Teste criado para testar se os pontos referentes a experiencia dos
	 * jogadores estao sendo computados corretamente (pontos referentes a compra
	 * do jogo).Nesse caso, referente a jogos do tipo Plataforma.
	 */
	@Test
	public void testPontosExperienciaPlataforma() {
		Loja loja = new Loja();
		HashSet<EstiloJogos> estilo1 = new HashSet();
		estilo1.add(EstiloJogos.OFFLINE);
		estilo1.add(EstiloJogos.MULTIPLAYER);

		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");
			Usuario lisa = loja.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");

			loja.criaJogo("Super Mario World", 30.00, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario World", lisa);

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", tainah);

			Assert.assertTrue(356 == tainah.getPontos());
			Assert.assertTrue(300 == lisa.getPontos());

			tainah.recompensar("Super Mario Bros", 150, true);
			tainah.recompensar("Super Mario Bros", 160, true);
			tainah.recompensar("Super Mario Bros", 130, false);
			tainah.recompensar("Super Mario Bros", 200, true);

			lisa.recompensar("Super Mario World", 300, true);

			Assert.assertTrue(576 == tainah.getPontos());
			Assert.assertTrue(320 == lisa.getPontos());

		} catch (UsuarioInvalidoException e) {
			Assert.fail();
		}

	}

	/**
	 * Teste criado para testar se os pontos referentes a experiencia dos
	 * jogadores estao sendo computados corretamente (pontos referentes a compra
	 * do jogo).Nesse caso, referente a jogos do tipo Luta.
	 */
	@Test
	public void testPontosExperienciaLuta() {
		Loja loja = new Loja();
		HashSet<EstiloJogos> estilo = new HashSet();

		estilo.add(EstiloJogos.ONLINE);
		estilo.add(EstiloJogos.MULTIPLAYER);
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");
			Usuario lisa = loja.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");

			loja.criaJogo("Injustice", 159.99, "Luta", estilo);
			loja.adicionaJogo("Injustice", tainah);

			loja.criaJogo("Guilty", 80.00, "Luta", estilo);
			loja.adicionaJogo("Guilty", lisa);

			Assert.assertTrue(1599 == tainah.getPontos());
			Assert.assertTrue(800 == lisa.getPontos());

			tainah.recompensar("Injustice", 15000, true);
			tainah.recompensar("Injustice", 18000, true);
			tainah.recompensar("Injustice", 20000, true);

			lisa.recompensar("Guilty", 20000, true);
			lisa.recompensar("Guilty", 30000, true);
			lisa.recompensar("Guilty", 50000, true);

			Assert.assertTrue(1682 == tainah.getPontos());
			Assert.assertTrue(930 == lisa.getPontos());

		} catch (UsuarioInvalidoException e) {
			Assert.fail();
		}
	}

}

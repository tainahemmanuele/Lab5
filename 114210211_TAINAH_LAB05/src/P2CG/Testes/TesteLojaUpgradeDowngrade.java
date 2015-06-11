/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import static org.junit.Assert.*;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

import P2CG.EstiloJogos;
import P2CG.Loja;
import P2CG.Usuario;
import P2CG.Exceptions.DowngradeException;
import P2CG.Exceptions.UpgradeException;
import P2CG.Exceptions.UsuarioInvalidoException;

public class TesteLojaUpgradeDowngrade {

	/**
	 * Teste criado para testar se a loja consegue fazer o downgrade ou upgrade
	 * dos usuarios.
	 */
	@Test
	public void testLojaUpgradeDowngrade() {
		Loja loja = new Loja();
		HashSet<EstiloJogos> estilo1 = new HashSet();
		HashSet<EstiloJogos> estilo = new HashSet();
		estilo1.add(EstiloJogos.OFFLINE);
		estilo1.add(EstiloJogos.MULTIPLAYER);
		estilo.add(EstiloJogos.COMPETITIVO);
		estilo.add(EstiloJogos.MULTIPLAYER);
		estilo.add(EstiloJogos.ONLINE);
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");
			Usuario lisa = loja.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");

			loja.criaJogo("Super Mario World", 30.00, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario World", lisa);

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", tainah);

			loja.criaJogo("Injustice", 159.99, "Luta", estilo);
			loja.adicionaJogo("Injustice", tainah);

			// Assert.assertTrue(356 == tainah.getPontos());
			Assert.assertTrue(300 == lisa.getPontos());

			tainah.recompensar("Super Mario Bros", 150, true);
			tainah.recompensar("Super Mario Bros", 160, true);
			tainah.recompensar("Super Mario Bros", 130, false);
			tainah.recompensar("Super Mario Bros", 200, true);
			tainah.recompensar("Super Mario Bros", 220, true);
			tainah.recompensar("Super Mario Bros", 290, true);

			tainah = loja.upgrade("tainahemmanuele");

			lisa = loja.downgrade("lisa.simpson");

			lisa.recompensar("Super Mario World", 300, true);

			Assert.assertTrue("Veterano",tainah.getClass().getSimpleName().equals("Veterano"));
			Assert.assertTrue("Noob",lisa.getClass().getSimpleName().equals("Noob"));
			
			Assert.assertTrue(2295 == tainah.getPontos());
			Assert.assertTrue(360 == lisa.getPontos());

			
		} catch (UsuarioInvalidoException | UpgradeException
				| DowngradeException e) {
			Assert.fail();
		}

	}

	/**
	 * Teste criado para saber se a classe loja captura e lanca as excecoes
	 * referentes ao upgrade do usuario.
	 */

	@Test
	public void testLojaUpgradeInvalido() {
		Loja loja = new Loja();
		HashSet<EstiloJogos> estilo1 = new HashSet();
		HashSet<EstiloJogos> estilo = new HashSet();
		estilo1.add(EstiloJogos.OFFLINE);
		estilo1.add(EstiloJogos.MULTIPLAYER);
		estilo.add(EstiloJogos.COMPETITIVO);
		estilo.add(EstiloJogos.MULTIPLAYER);
		estilo.add(EstiloJogos.ONLINE);

		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", tainah);

			tainah = loja.upgrade("tainahemmanuele");

		} catch (UsuarioInvalidoException | UpgradeException e) {
			Assert.assertEquals(
					"Usuario nao possui pontos suficientes para upgrade",
					e.getMessage());
		}

		try {
			Usuario lisa = loja.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");
			loja.criaJogo("Injustice", 159.99, "Luta", estilo);
			loja.adicionaJogo("Injustice", lisa);

			loja.upgrade("lisa.simpson");

		} catch (UsuarioInvalidoException | UpgradeException e) {
			Assert.assertEquals("Usuario ja e do tipo veterano", e.getMessage());
		}
	}

	/**
	 * Teste criado para saber se a classe loja captura e lanca as excecoes
	 * referentes ao downgrade do usuario.
	 */
	@Test
	public void TestLojaDowngradeInvalido() {
		Loja loja = new Loja();
		HashSet<EstiloJogos> estilo1 = new HashSet();
		HashSet<EstiloJogos> estilo = new HashSet();
		estilo1.add(EstiloJogos.OFFLINE);
		estilo1.add(EstiloJogos.MULTIPLAYER);
		estilo.add(EstiloJogos.COMPETITIVO);
		estilo.add(EstiloJogos.MULTIPLAYER);
		estilo.add(EstiloJogos.ONLINE);
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Veterano");

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", tainah);

			tainah = loja.downgrade("tainahemmanuele");

		} catch (UsuarioInvalidoException | DowngradeException e) {
			Assert.assertEquals("Usuario tem pontos maiores que 1000",
					e.getMessage());
		}
		try {
			Usuario tainah = loja.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", tainah);

			tainah = loja.downgrade("tainahemmanuele");

		} catch (UsuarioInvalidoException | DowngradeException e) {
			Assert.assertEquals("Usuario ja e do tipo noob", e.getMessage());
		}
	}
}

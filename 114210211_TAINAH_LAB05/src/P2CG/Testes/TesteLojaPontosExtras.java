/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import static org.junit.Assert.*;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

import P2CG.EstiloJogos;
import P2CG.Jogo;
import P2CG.Loja;
import P2CG.Usuario;
import P2CG.Exceptions.UsuarioInvalidoException;

public class TesteLojaPontosExtras {

	/**
	 * Teste criado para testar se os pontos referentes aos metodos punir ou
	 * recompensar estao sendo computados corretamente.
	 * 
	 */
	@Test
	public void testPontosExtras() {
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

			loja.criaJogo("Injustice", 159.99, "Luta", estilo);
			loja.adicionaJogo("Injustice", tainah);

			loja.criaJogo("Injustice", 159.99, "Luta", estilo);
			loja.adicionaJogo("Injustice", lisa);

			loja.criaJogo("Super Mario World", 30.00, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario World", lisa);

			loja.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			loja.adicionaJogo("Super Mario Bros", tainah);

			Assert.assertTrue(1955 == tainah.getPontos());
			Assert.assertTrue(1899 == lisa.getPontos());

			tainah.recompensar("Super Mario Bros", 150, true);
			Assert.assertTrue(2015 == tainah.getPontos());

			// tainah.jogar("Injustice", 120, true);
			tainah.punir("Injustice", 120, true);
			Assert.assertTrue(1985 == tainah.getPontos());

			lisa.recompensar("Super Mario World", 300, true);
			Assert.assertTrue(1919 == lisa.getPontos());

			lisa.punir("Injustice", 20, false);
			Assert.assertTrue(1899 == lisa.getPontos());

			lisa.recompensar("Injustice", 20, false);
			Assert.assertTrue(1909 == lisa.getPontos());

			tainah.recompensar("Injustice", 120, true);
			Assert.assertTrue(1995 == tainah.getPontos());
		} catch (UsuarioInvalidoException e) {
			Assert.fail();
		}
	}

}

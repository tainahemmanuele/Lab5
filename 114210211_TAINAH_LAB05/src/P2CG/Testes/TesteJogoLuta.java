/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import P2CG.Jogo;
import P2CG.Luta;
import P2CG.Exceptions.JogoException;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteJogoLuta {

	/**
	 * Teste criado para saber se a classe Luta esta criando o jogo
	 * corretamente.
	 */
	@Test
	public void testJogoLuta() {

		try {
			Jogo guilty = new Luta("Guilty Gears", 80.00);
			Jogo guilty2 = new Luta("Guilty Gears", 80.00);

			Jogo injustice = new Luta("Injustice", 120.99);

			Assert.assertEquals(guilty, guilty2);
			Assert.assertFalse(guilty.equals(injustice));

		} catch (JogoException e) {
			Assert.fail();
		}
	}

	/**
	 * Teste criado para saber se ao tentar criar um jogo faltando nome ou o
	 * preco negativo a Exception e lancada.
	 */
	@Test
	public void testJogoLutaInvalido() {

		try {
			Jogo guilty = new Luta("", 80.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Nome do jogo nao pode ser vazio",
					e.getMessage());

		}
		try {
			Jogo guilty = new Luta("Guilty Gears", -80.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Preco do jogo nao pode ser negativo",
					e.getMessage());

		}
		try {
			Jogo guilty = new Luta("", -80.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Nome do jogo nao pode ser vazio",
					e.getMessage());

		}
	}

}

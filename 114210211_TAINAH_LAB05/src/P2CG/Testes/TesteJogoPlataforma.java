/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import P2CG.Plataforma;
import P2CG.Jogo;
import P2CG.Exceptions.JogoException;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteJogoPlataforma {

	/**
	 * Teste criado para saber se a classe Plataforma esta criando o jogo
	 * corretamente.
	 */
	@Test
	public void testJogoPlataforma() {

		try {
			Jogo supermario = new Plataforma("Super Mario World", 30.00);
			Jogo supermario2 = new Plataforma("Super Mario World", 30.00);

			Jogo mariobros = new Plataforma("Super Mario Bros", 35.60);

			Assert.assertEquals(supermario, supermario2);
			Assert.assertFalse(supermario.equals(mariobros));

		} catch (JogoException e) {
			Assert.fail();
		}
	}

	/**
	 * Teste criado para saber se ao tentar criar um jogo faltando nome ou o
	 * preco negativo a Exception e lancada.
	 */
	@Test
	public void testJogoPlataformaInvalido() {

		try {
			Jogo supermario = new Plataforma("", 30.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Nome do jogo nao pode ser vazio",
					e.getMessage());

		}
		try {
			Jogo supermario = new Plataforma("Super Mario World", -30.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Preco do jogo nao pode ser negativo",
					e.getMessage());

		}
		try {
			Jogo supermario = new Plataforma("", -30.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Nome do jogo nao pode ser vazio",
					e.getMessage());

		}
	}

}

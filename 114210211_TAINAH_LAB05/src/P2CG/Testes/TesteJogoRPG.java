/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import P2CG.Jogo;
import P2CG.RPG;
import P2CG.Exceptions.JogoException;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteJogoRPG {

	/**
	 * Teste criado para saber se a classe RPG esta criando o jogo corretamente.
	 */
	@Test
	public void testJogoRPG() {

		try {
			Jogo papermario = new RPG("Paper Mario", 75.00);
			Jogo papermario2 = new RPG("Paper Mario", 75.00);

			Jogo superstarsaga = new RPG("Mario e Luigi: Superstar Saga", 85.99);

			Assert.assertEquals(papermario, papermario2);
			Assert.assertFalse(papermario.equals(superstarsaga));

		} catch (JogoException e) {
			Assert.fail();
		}
	}

	/**
	 * Teste criado para saber se ao tentar criar um jogo faltando nome ou o
	 * preco negativo a Exception e lancada.
	 */
	@Test
	public void testJogoRPGInvalido() {

		try {
			Jogo papermario = new RPG("", 75.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Nome do jogo nao pode ser vazio",
					e.getMessage());

		}
		try {
			Jogo papermario = new RPG("Paper Mario", -75.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Preco do jogo nao pode ser negativo",
					e.getMessage());

		}
		try {
			Jogo papermario = new RPG("", -75.00);
			Assert.fail();
		} catch (JogoException e) {
			Assert.assertEquals("Nome do jogo nao pode ser vazio",
					e.getMessage());

		}
	}
}

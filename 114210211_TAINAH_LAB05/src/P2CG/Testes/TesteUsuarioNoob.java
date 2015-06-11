/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import P2CG.Usuario;
import P2CG.Noob;
import P2CG.Exceptions.CriacaoUsuarioException;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteUsuarioNoob {

	/**
	 * Teste criado para saber se a classe Noob esta criando o usuario
	 * corretamente.
	 */
	@Test
	public void testUsuarioNoob() {
		try {
			Usuario tainah = new Noob("Tainah Emmanuele", "tainahemmanuele",
					158.00);
			Usuario tainah2 = new Noob("Tainah Emmanuele", "tainahemmanuele",
					158.00);

			Usuario gabi = new Noob("Maria Gabriela", "mgabriela", 190.00);

			Assert.assertEquals(tainah, tainah2);
			Assert.assertFalse(tainah.equals(gabi));

		} catch (CriacaoUsuarioException e) {
			Assert.fail();
		}

	}

	/**
	 * Teste criado para saber se ao tentar criar um usuario faltando nome ou o
	 * preco negativo a Exception e lancada.
	 */

	@Test
	public void testUsuarioNoobInvalido() {
		try {
			Usuario tainah = new Noob("", "tainahemmanuele", 158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Nome do usuario nao pode ser vazio",
					e.getMessage());

		}
		try {
			Usuario tainah = new Noob("Tainah Emmanuele", "", 158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Login do usuario nao pode ser vazio",
					e.getMessage());

		}
		try {
			Usuario tainah = new Noob("Tainah Emmanuele", "tainahemmanuele",
					-158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Dinheiro do usuario nao pode ser negativo",
					e.getMessage());
		}
		try {
			Usuario tainah = new Noob("", "", -158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Nome do usuario nao pode ser vazio",
					e.getMessage());
		}
		try {
			Usuario tainah = new Noob("Tainah Emmanuele", "", -158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Login do usuario nao pode ser vazio",
					e.getMessage());
		}
	}

}

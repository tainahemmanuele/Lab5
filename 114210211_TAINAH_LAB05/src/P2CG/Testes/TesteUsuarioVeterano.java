/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import P2CG.Usuario;
import P2CG.Veterano;
import P2CG.Exceptions.CriacaoUsuarioException;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteUsuarioVeterano {

	/**
	 * Teste criado para saber se a classe Veterano esta criando o usuario
	 * corretamente.
	 */
	@Test
	public void testUsuarioVeterano() {
		try {
			Usuario tainah = new Veterano("Tainah Emmanuele",
					"tainahemmanuele", 158.00);
			Usuario tainah2 = new Veterano("Tainah Emmanuele",
					"tainahemmanuele", 158.00);

			Usuario gabi = new Veterano("Maria Gabriela", "mgabriela", 190.00);

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
	public void testUsuarioVeteranoInvalido() {
		try {
			Usuario tainah = new Veterano("", "tainahemmanuele", 158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Nome do usuario nao pode ser vazio",
					e.getMessage());

		}
		try {
			Usuario tainah = new Veterano("Tainah Emmanuele", "", 158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Login do usuario nao pode ser vazio",
					e.getMessage());

		}
		try {
			Usuario tainah = new Veterano("Tainah Emmanuele",
					"tainahemmanuele", -158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Dinheiro do usuario nao pode ser negativo",
					e.getMessage());
		}
		try {
			Usuario tainah = new Veterano("", "", -158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Nome do usuario nao pode ser vazio",
					e.getMessage());
		}
		try {
			Usuario tainah = new Veterano("Tainah Emmanuele", "", -158.00);
			Assert.fail();
		} catch (CriacaoUsuarioException e) {
			Assert.assertEquals("Login do usuario nao pode ser vazio",
					e.getMessage());
		}
	}

}

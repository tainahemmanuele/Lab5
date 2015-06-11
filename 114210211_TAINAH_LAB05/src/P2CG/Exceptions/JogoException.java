/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Exceptions;

public class JogoException extends Exception {

	public JogoException(String string) {
		super(string);
	}

	public JogoException() {
		super("Informacoes invalidas para criar o jogo.Tente Novamente");
	}
}

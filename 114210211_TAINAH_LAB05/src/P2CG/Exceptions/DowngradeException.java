/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Exceptions;

public class DowngradeException extends Exception {

	public DowngradeException(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	public DowngradeException() {
		super("Usuario nao possui requisitos para downgrade");
		// TODO Auto-generated constructor stub
	}
}

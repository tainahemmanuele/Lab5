/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Exceptions;

public class UpgradeException extends Exception {

	public UpgradeException(String string) {
		super(string);
	}

	public UpgradeException() {
		super("Usuario nao possui requisitos para upgrade");
		// TODO Auto-generated constructor stub
	}
}

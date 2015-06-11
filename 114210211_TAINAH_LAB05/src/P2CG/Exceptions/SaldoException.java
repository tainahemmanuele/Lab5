/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Exceptions;

public class SaldoException extends UsuarioException {

	public SaldoException(String string) {
		super(string);
	}

	public SaldoException() {
		super("Saldo insuficiente");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1695619654310274396L;

}

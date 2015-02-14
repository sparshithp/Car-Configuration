package exceptions;

import java.util.Scanner;

public class OptionException extends AutoException {

	private static final int CODE = 401;
	private static final String MSG = "Option Set Not Found";

	public OptionException() {
		super(CODE, MSG);
	}
	

	@Override
	public void print() {
		System.out.println(MSG);
	}
	

}

package exceptions;

import java.util.Scanner;

public class InvalidFileNameException extends AutoException {
	
	private static final int CODE = 301;
	private static final String MSG = "Invalid File name";
	
	public InvalidFileNameException() {
		super(CODE, MSG);
	}

	
	@Override
	public void print() {
		System.out.println(MSG);
	}

}

package exceptions;

import java.util.Scanner;

public class InvalidFileTypeException extends AutoException {
	
	private static final int CODE = 101;
	private static final String MSG = "Invalid File Type";
	
	public InvalidFileTypeException() {
		super(CODE, MSG);
	}

	
	@Override
	public void print() {
		System.out.println(MSG);
	}

}

package exceptions;

import java.util.Scanner;

public class BlankFileException extends AutoException{
	
	private static final int CODE = 201;
	private static final String MSG = "File is Blank";
	
	public BlankFileException() {
		super(CODE, MSG);
	}
	
	/*
	@Override
	public String fix() {
		System.out.println("Please enter the correct non blank file name");
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		return fileName;
	}
	*/
	@Override
	public void print() {
		System.out.println(MSG);
	}
	
	

}

package exceptions;

import java.util.Scanner;

public class BlankModelName extends AutoException {
	private static final int CODE = 501;
	private static final String MSG = "Model name in the file is blank";

	public BlankModelName() {
		super(CODE, MSG);
	}

	

	@Override
	public void print() {
		System.out.println(MSG);
	}
}

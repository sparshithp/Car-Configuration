package model;

import java.io.IOException;

import exceptions.BlankFileException;
import exceptions.InvalidFileNameException;
import exceptions.InvalidFileTypeException;
import util.FileIO;
import util.ReadData;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidFileTypeException, BlankFileException, InvalidFileNameException {
		// TODO Auto-generated method stub
		ReadData rd = new ReadData();
		Automobile automotive = rd.readFile("ford");
		System.out.println(automotive.print());
		FileIO.serial(automotive);
		automotive = FileIO.deserial();
		System.out.println("Deserialized print");
		System.out.println();
		System.out.println(automotive.print());
	}

}

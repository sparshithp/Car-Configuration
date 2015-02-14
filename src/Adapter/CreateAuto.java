package Adapter;

import exceptions.BlankFileException;
import exceptions.InvalidFileNameException;
import exceptions.InvalidFileTypeException;

public interface CreateAuto {
	public void buildAuto(String filename)throws InvalidFileTypeException, BlankFileException, InvalidFileNameException;
	public void printAuto(String modelName);
}

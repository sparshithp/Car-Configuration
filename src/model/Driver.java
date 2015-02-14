package model;

import exceptions.BlankFileException;
import exceptions.InvalidFileNameException;
import exceptions.InvalidFileTypeException;
import Adapter.BuildAuto;

public class Driver {

	public static void main(String[] args) throws InvalidFileTypeException,
			BlankFileException, InvalidFileNameException {
		// TODO Auto-generated method stub

		// Case where no exception is raised
		BuildAuto b = new BuildAuto();
		b.buildAuto("ford.txt");
		b.printAuto("Ford Focus");

		// Change the price for automatic transmission option from 0 to 15
		System.out.println();
		System.out.println("Price changed from automatic transmission");
		System.out.println();
		b.updateOptionPrice("Ford Focus", "Transmission", "Automatic", 15);
		b.printAuto("Ford Focus");
		
		//Change the option set name from 'Transmission' to 'Shift'
		System.out.println();
		System.out.println("Option Set name changed from Transmission to shift ");
		System.out.println();
		b.updateOptionSetName("Ford Focus", "Transmission", "Shift");
		b.printAuto("Ford Focus");

		// Exception raise due to a blank file. Please enter ford.txt when
		// prompted for a new file on the console
		System.out.println();
		System.out.println("2nd case:");
		System.out.println();
		b = new BuildAuto();
		b.buildAuto("blank.txt");
		b.printAuto("Ford Focus");

		// Exception raised due to wrong file extension. Please enter ford.txt
		// when
		// prompted for a new file on the console
		System.out.println();
		System.out.println("3rd case:");
		System.out.println();
		b = new BuildAuto();
		b.buildAuto("ford");
		b.printAuto("Ford Focus");
	}

}

package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Automobile;

public class FileIO {
	public static void serial(Automobile auto) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"/home/sparshith/sd.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(auto);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static Automobile deserial() throws ClassNotFoundException {
		Automobile e = null;
		try {
			FileInputStream fileIn = new FileInputStream(
					"/home/sparshith/sd.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Automobile) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return e;
	}
}

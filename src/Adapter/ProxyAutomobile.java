package Adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

import exceptions.AutoException;
import exceptions.BlankFileException;
import exceptions.InvalidFileNameException;
import exceptions.InvalidFileTypeException;
import exceptions.OptionException;
import util.ReadData;
import model.*;

public abstract class ProxyAutomobile {
	private Automobile a1;
	private static LinkedHashMap<String, Automobile> automobiles = new LinkedHashMap<String, Automobile>();

	public void buildAuto(String fileName) throws InvalidFileTypeException, BlankFileException, InvalidFileNameException {
		ReadData rd = new ReadData();
		try {
			a1 = rd.readFile(fileName);
		} catch(AutoException e){
			e.print();
			String corrected = fix(e.getErrorCode());
			if(e != null){
				buildAuto(corrected);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		automobiles.put(a1.getModel(), a1);
	}

	public void printAuto(String modelName) {
		System.out.println(automobiles.get(modelName).print());
	}

	public void updateOptionSetName(String modelName, String optionSetName,
			String newName) {
		a1 = automobiles.get(modelName);
		a1.getOptionSetByName(optionSetName).setName(newName);
	}

	public void updateOptionPrice(String modelName, String optionName,
			String Option, float newPrice) {
		a1 = automobiles.get(modelName);
		try {
			a1.findOptionSet(optionName).findOptionByName(Option)
					.setPrice(newPrice);
		} catch (OptionException e) {
			e.print();
			String corrected = fix(e.getErrorCode());
		}
	}
	
	public String fix(int code){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switch(code){
		case 101: 
			System.out.print("Please input file of correct type:");
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		case 201: 
			System.out.print("Please input a non blank filename:");
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		case 301: 
			System.out.print("Please input the correct filename:");
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		case 401: 
			System.out.print("Please enter new Option set name:");
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		case 501: 
			System.out.print("Please input a file with correct model name");
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		default: return null;
		}
	}
}

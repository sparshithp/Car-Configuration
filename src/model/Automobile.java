package model;

import java.io.Serializable;
import java.util.LinkedHashMap;

import exceptions.OptionException;
import model.OptionSet.Option;

public class Automobile implements Serializable {
	private String name;
	private OptionSet[] opset;
	private int baseprice;
	private String make;
	private String model;

	// Constructor with arguments
	public Automobile(int size, String name, int baseprice) {
		opset = new OptionSet[size];
		this.name = name;
		this.baseprice = baseprice;
		for (int i = 0; i < size; i++) {
			opset[i] = new OptionSet();
		}
	}

	// Constructor with no Arguments
	public Automobile() {
		super();
	}

	// Begin getters
	public String getName() {
		return name;
	}
	
	public OptionSet getOptionSet(int index) {
		return opset[index];
	}

	public int getOptionSetSize() {
		return opset.length;
	}

	public OptionSet getOptionSetByName(String name) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().equals(name))
				return opset[i];
		}
		return null;
	}

	public int getBaseprice() {
		return baseprice;
	}

	// End getters

	// Begin setters
	public void setName(String name) {
		this.name = name;
	}

	public void setOptionSet(int index, OptionSet optionSet) {
		opset[index] = optionSet;
	}

	/* Initialize an optionset array with a given size */
	public void setOptionset(int optionsetsize) {
		opset = new OptionSet[optionsetsize];
		for (int i = 0; i < optionsetsize; i++) {
			OptionSet optionset = new OptionSet();
			opset[i] = optionset;
		}
	}

	/* Initialize an option array with a given size for a given optionset */
	public void setOption(OptionSet opset, int optionsize) {
		opset.setOption(optionsize);
	}

	public void setBaseprice(int baseprice) {
		this.baseprice = baseprice;
	}

	/* Set the names of optionsets */
	public void setOptionValue(int index, int index2, String value) {
		opset[index2].setOptionValue(index, value);
	}

	/* Set the prices of options */
	public void setOptionPrice(int index, int index2, int price) {
		opset[index2].setOptionPrice(index, price);
	}

	/* Set the names of options */
	public void setOptionsetName(int index, String string) {
		opset[index].setName(string);
	}

	// End setters

	// Begin find methods
	public OptionSet findOptionSet(String name) throws OptionException {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().equals(name)) {
				return opset[i];
			}
		}
		throw new OptionException();
	}

	public Option findOption(String name) {
		for (int i = 0; i < opset.length; i++) {
			opset[i].findOptionByName(name);
		}
		return null;
	}

	// End find methods

	// Begin delete methods
	public void deleteOpset(int index) {
		opset[index] = null;
	}

	public void deleteOption(int indexoptset, int indexopt) {
		opset[indexoptset].deleteOption(indexopt);
	}

	// End delete methods

	// Print Method
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("The model of the car is: " + model + "\n");
		sb.append("The base price of the car is " + baseprice + "\n");
		sb.append("The options available are \n");
		for (int i = 0; i < opset.length; i++) {
			sb.append(opset[i].print());
		}
		return sb.toString();
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setOptionChoice(String setName, String optionName) throws OptionException {
		findOptionSet(setName).setChoice(
				findOptionSet(setName).findOptionByName(optionName));
	}

	public String getOptionChoice(String setName) throws OptionException {
		return findOptionSet(setName).getChoice().getName();
	}

	public int getOptionChoicePrice(String setName) throws OptionException {
		return (int) findOptionSet(setName).getChoice().getPrice();
	}

	public int getTotalPrice() throws OptionException {
		int total = baseprice;
		for (int i = 0; i < opset.length; i++) {
			total += this.getOptionChoicePrice(opset[i].getName());
		}
		return total;
	}

}

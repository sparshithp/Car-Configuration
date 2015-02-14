package model;

import java.io.Serializable;

public class OptionSet implements Serializable {
	public class Option implements Serializable {
		String name;
		float price;

		Option() {
			super();
		}

		Option(String name, float price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return name + ", Price=" + price;
		}
	}

	private Option[] opt;
	private String name;
	private Option choice;

	public Option getChoice() {
		return choice;
	}

	public void setChoice(Option choice) {
		this.choice = choice;
	}

	public Option getOptionChoice() {
		return this.choice;
	}

	public void setOptionChoice(String optionName) {
		this.choice = findOptionByName(optionName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OptionSet(String n, int size) {
		opt = new Option[size];
		name = n;
		for (int i = 0; i < size; i++) {
			opt[i] = new Option();
		}
	}

	public void deleteOption(int indexopt) {
		opt[indexopt] = null;
	}

	public Option findOptionByName(String name) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].getName().equals(name))
				return opt[i];
		}
		return null;
	}

	public void setOption(int index, Option option) {
		opt[index] = option;
	}

	OptionSet() {
		super();
	}

	public void setOption(int optionsize) {
		// TODO Auto-generated method stub
		opt = new Option[optionsize];
		for (int i = 0; i < optionsize; i++) {
			Option n = new Option();
			opt[i] = n;
		}
	}

	public void setOptionValue(int index, String value) {
		opt[index].setName(value);

	}

	public void setOptionPrice(int index, int price) {
		opt[index].setPrice(price);
	}

	@Override
	public String toString() {
		return "OptionSet [name=" + name + "]";
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("Option set " + name + ":\n");
		for (int i = 0; i < opt.length; i++) {
			sb.append(opt[i]);
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

}

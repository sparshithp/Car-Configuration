package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import exceptions.BlankFileException;
import exceptions.InvalidFileNameException;
import exceptions.InvalidFileTypeException;
import model.Automobile;
import model.OptionSet;

public class ReadData {

	public Automobile readFile(String fileName) throws IOException,
			InvalidFileTypeException, BlankFileException, InvalidFileNameException {
		String ext = fileName.substring(fileName.length() - 4,
				fileName.length());
		if (!ext.equals(".txt"))
			throw new InvalidFileTypeException();
		Automobile automotive = new Automobile();
		FileReader file;
		file = new FileReader(fileName);
			if(file == null) throw new InvalidFileNameException();

		BufferedReader br = new BufferedReader(file);

		// First Line has the size of the optionsets.
		String first = br.readLine();
		if (first == null) {
			throw new BlankFileException();
		}
		int numOptionSets = Integer.parseInt(first);
		automotive.setOptionset(numOptionSets);

		// Second line has the base price
		String second = br.readLine();
		if (second == null)
			return null;
		automotive.setBaseprice(Integer.parseInt(second));

		// Third line has size of all the option sets in the option set array
		String third = br.readLine();
		if (first == null)
			return null;

		StringTokenizer st = new StringTokenizer(third);
		int[] optSetSize = new int[numOptionSets];
		int index = 0;
		while (st.hasMoreTokens()) {
			automotive.getOptionSet(index).setOption(
					Integer.parseInt(st.nextToken()));
			/*
			 * optSetSize[index] = Integer.parseInt(st.nextToken());
			 * automotive.setOption(automotive.getOptionSet(index),
			 * optSetSize[index]);
			 */
			index++;
			if (index == numOptionSets)
				break;
		}

		// Fourth line has the name of the automobile
		String fourth = br.readLine().trim();
		if (fourth == null)
			return null;
		automotive.setModel(fourth);

		// Next lines have the optionsets name along with their option name and
		// price seperated by ":"
		int i = 0;
		while (i < numOptionSets) {
			OptionSet current = automotive.getOptionSet(i);
			String line = br.readLine();
			st = new StringTokenizer(line);
			current.setName(st.nextToken());
			int j = 0;
			while (st.hasMoreTokens()) {
				String[] attr = st.nextToken().split(":");
				automotive.getOptionSet(i).setOptionValue(j, attr[0]);
				automotive.getOptionSet(i).setOptionPrice(j,
						Integer.parseInt(attr[1]));
				j++;
			}
			i++;
		}

		br.close();
		return automotive;
	}
}

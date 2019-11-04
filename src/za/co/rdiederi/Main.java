package za.co.rdiederi;

import java.io.*;
import java.util.ArrayList;

import za.co.Exceptions.InvalidCoordinateException;
import za.co.Exceptions.TypeNotFoundException;
import za.co.Exceptions.InvalidFormatException;

public class Main {
	static void runner(int total, ArrayList<String[]> scn) {
		AircraftFactory factory = new AircraftFactory();
		WeatherTower tower = new WeatherTower();
		try {
			for (String[] var : scn) {
				if (var.length != 5)
				{
					throw new InvalidFormatException("The scenario is in an Invalid format!");
				}
				Flyable craft = factory.newAircraft(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),
						Integer.parseInt(var[4]));
				tower.register(craft);
			}
			for (int i = 0; i < total; i++) {
				tower.conditionsChanged();
			}
		} catch (TypeNotFoundException ex) {
			System.out.println(ex);
		} catch (InvalidCoordinateException ex) {
			System.out.println(ex);
		} catch (NumberFormatException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		ArrayList<String[]> mylist = new ArrayList<>();
		if (args.length == 1) {
			try {
				FileReader file = new FileReader(new File(args[0]));
				BufferedReader reader = new BufferedReader(file);
				String line = reader.readLine();
				int repeat = Integer.parseInt(line);
				line = reader.readLine();
				while (line != null) {
					String cmd[] = line.split(" ");
					mylist.add(cmd);
					line = reader.readLine();
				}
				reader.close();
				if(mylist.size() == 0) {
					throw new InvalidFormatException("invalid format! You have to add compnonents to the simulation");
				}
				runner(repeat, mylist);
			}
			catch(NumberFormatException ex) {
				throw new InvalidFormatException("Invalid format! First line should be a number");
			}
			catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}
}

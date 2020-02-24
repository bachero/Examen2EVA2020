import java.io.*;
import java.util.*;

public class Exercise1 {

	public static void main(String[] args) throws IOException {
		
		if (args.length != 1) {
			System.err.println("Usage: Exercise <filename>");
			System.exit(1);
		}
		
		Scanner input = new Scanner(System.in);
		String province = "";
		while (!province.equalsIgnoreCase("EXIT")) {
			System.out.println("Enter provice (EXIT to finish)");
			province = input.nextLine();
			if (!province.equalsIgnoreCase("EXIT")) {
				displayDeaths(province,args[0]);
			}
		}
	}

	private static void displayDeaths(String province, String filename) throws IOException {
		
		BufferedReader input = null;
		
		try  {
			input = new BufferedReader(new FileReader(filename));
			String line;
			input.readLine();
			int totalDeaths = 0;
			while ((line = input.readLine()) != null) {
				String[] items = line.split(",");
				String readProvince = items[2];
				if (province.equalsIgnoreCase(readProvince)) {
					int deaths = Integer.parseInt(items[6]);
					totalDeaths += deaths;
				}
			}
			System.out.println("Total deaths in " + province + ": " + totalDeaths);
		} catch (FileNotFoundException e) {
			System.err.println("File " + filename + " not found.");
			System.exit(1);
		} catch (IOException e) {
			 System.err.println("Error reading " + filename + ".");
			 System.exit(1);
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

}

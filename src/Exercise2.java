import java.util.*;
import java.io.*;

public class Exercise2 {

	public static void main(String[] args) throws IOException {
		
		Map <String, Integer> map = readMapFromCSV();
		System.out.println(map);
		printInfectionsBiggerThan(map, 1000);
	}

	public static Map<String, Integer> readMapFromCSV() throws IOException{
		Map <String, Integer> map = new HashMap<String, Integer>();
		
		BufferedReader input = null;
		
		try {
			input = new BufferedReader(new FileReader("corona2.csv"));
			String line;
			input.readLine();
			while((line = input.readLine()) != null) {
				String[] items = line.split(",");
				String country = items[3];
				int infected = Integer.parseInt(items[5]);
				if (map.get(country) == null) {
					map.put(country, infected);
				} else {
					map.put(country, infected + map.get(country));
				}
			}
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
			System.exit(1);
		} catch (IOException e) {
			 System.err.println("Error reading.");
			 System.exit(1);
		} finally {
			if (input != null) {
				input.close();
			}
		}
		
		return map;
	}
	
	public static void printInfectionsBiggerThan(Map<String,Integer> map,int minim) {
		
		for(String key: map.keySet()) {
			int infections = map.get(key);
			if (infections >= minim) {
				System.out.println(key + " / " + infections);
			}
		}
	}
}

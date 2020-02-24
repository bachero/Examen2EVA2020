import java.io.*;
import java.util.*;

public class Person implements Serializable,Comparable<Person>{

	private static final long serialVersionUID = 1L;
	private Dni dni;
	private String name;
	private int age;
	
	public Person(Dni dni,String name,int age) {
		this.dni = dni;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return dni.toFormattedString() + " " + name + "(" + age +")";
	}
	
	public static void savePersons(List<Person> list) throws IOException {
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(
						new BufferedOutputStream(
							new FileOutputStream("people.dat")));
			for (Person p: list) {
				out.writeObject(p);
			}
		} finally {
			if (out != null){
				out.close();
			}
		}
	}
	
	public static void printFileOfPeople() throws IOException {
		ObjectInputStream input = null;
		List<Person> list = new ArrayList<Person>();
		try {
			input = new ObjectInputStream(
						new BufferedInputStream(
							new FileInputStream("people.dat")));
			while (true) {
				Person p = (Person)input.readObject();
				list.add(p);
			}
		} catch (EOFException ex ){
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
		
			if (input != null) {
				input.close();
			}
		}
		Collections.sort(list);
		for (Person p: list) {
			System.out.println(p);
		}
	}

	@Override
	public int compareTo(Person p) {
		if (age < p.age) {
			return -1;
		} else {
			if (age > p.age) {
				return 1;
			}
		}
		return 0;
	}
}

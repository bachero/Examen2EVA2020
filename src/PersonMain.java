import java.io.IOException;
import java.util.*;

public class PersonMain {

	public static void main(String[] args) throws IOException {
		List<Person> list = new ArrayList<Person>();

		list.add(new Person(new Dni(123), "111", 20));
		list.add(new Person(new Dni(124), "222", 40));
		list.add(new Person(new Dni(125), "333", 10));
		
		//Person.savePersons(list);
		Person.printFileOfPeople();
	}

}

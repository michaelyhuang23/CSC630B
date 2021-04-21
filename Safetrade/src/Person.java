import java.util.*;

public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;

	public Person(String firstn, String lastn) {
		firstName = firstn;
		lastName = lastn;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int compareTo(Person person) {
		int compared = this.lastName.compareTo(person.getLastName());
		if (compared == 0) {
			compared = this.firstName.compareTo(person.getFirstName());
		}
		return compared;
	}

	public static void main(String[] arg) {
		Person person1 = new Person("Michael", "Kennedy");
		Person person2 = new Person("John", "Kennedy");
		System.out.println(person1.compareTo(person2));
		System.out.println("Michael".compareTo("John"));
	}
}

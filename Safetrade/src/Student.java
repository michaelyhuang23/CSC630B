
import java.util.*;

public class Student {
	/***
	 * This class is written for exercise 14 of Java Methods chapter 20 Author:
	 * Michael Huang
	 */

	private String name;
	private double GPA;

	public Student() {
	}

	public Student(String name, double GPA) {
		/***
		 * first variable of this constructor is the name of the student and the second
		 * one is his or her GPA
		 */
		this.name = name;
		this.GPA = GPA;
	}

	public double getGPA() {
		/***
		 * returns the GPA of the student
		 */
		return GPA;
	}

	public Queue<Student> cutAtGPA(Queue<Student> students, double minGPA) {
		/***
		 * This method returns a Queue of students whose GPA is not less than minGPA
		 */
		Queue<Student> Q = new LinkedList<Student>();
		while (!students.isEmpty()) {
			Student std = students.remove();
			if (std.GPA >= minGPA)// we can just access private field GPA because its part of the memory of space
									// enclosed by the class Student
				Q.add(std);
		}
		return Q;
	}

	public static String randName() {
		/***
		 * generates a random name for a student
		 */
		Random rand = new Random();
		String str = "";
		for (int i = 0; i < 3 + rand.nextInt(10); i++)
			str += (char) (97 + rand.nextInt(26));
		return str;
	}

	public String toString() {
		/***
		 * converts the Student object to String
		 */
		return name + " : " + GPA;
	}

	public static void main(String[] args) {
		Queue<Student> students = new LinkedList<Student>();
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			students.add(new Student(randName(), rand.nextDouble() * 6));
		}
		System.out.println(students);
		students = (LinkedList<Student>) (new Student()).cutAtGPA(students, 5.0);
		System.out.println(students);
	}
}

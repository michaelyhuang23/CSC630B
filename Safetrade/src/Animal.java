import java.util.*;
public class Animal implements Movable,Carnivorous{
	double maxSpeed;
	ArrayList<Animal> ediblePrey=new ArrayList<Animal>();
	ArrayList<Animal> preferredPrey=new ArrayList<Animal>();
	public Animal(double maxsp){
		super();
		this.maxSpeed=maxsp;
		
	}
	public Animal(double maxsp, ArrayList<Animal> edi, ArrayList<Animal> pref){
		this(maxsp);
		ediblePrey=edi;
		preferredPrey=pref;
		
	}
	public Animal() {
		super();
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed=maxSpeed;
	}
	public boolean equals(Object o) {
		Animal otherA=(Animal)(o);
		return this.getClass().equals(otherA.getClass());
	}
	public boolean isEdible(Animal animal) {
		return ediblePrey.contains(animal);
	}
	public boolean isPreferred(Animal animal) {
		return preferredPrey.contains(animal);
	}
	public void addEdi(Animal animal) {
		this.ediblePrey.add((Animal)animal);
	}
	public void addPref(Animal animal) {
		preferredPrey.add(animal);
	}
	public static void main(String[] arr) {
		Animal Mary;
		Mary=new Animal();
		Animal Henry;
		Henry=new Dog();
		Mary.addEdi(new Dog());
		System.out.print(Mary.isEdible(Henry));
	}
	
}
